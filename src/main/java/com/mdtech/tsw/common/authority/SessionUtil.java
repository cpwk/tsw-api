package com.mdtech.tsw.common.authority;

import com.mdtech.tsw.api.admin.authority.AdminSessionWrap;
import com.mdtech.tsw.api.admin.model.Admin;
import com.mdtech.tsw.api.admin.model.AdminSession;
import com.mdtech.tsw.api.admin.service.IAdminService;
import com.mdtech.tsw.common.context.SessionWrap;
import com.mdtech.tsw.common.entity.ErrorCode;
import com.mdtech.tsw.common.exception.ServiceException;
import com.mdtech.tsw.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SessionUtil {

    public static Map<String, SessionWrap> map = new HashMap<>();
    @Autowired
    private IAdminService adminService;

    public static SessionWrap getSession(String token) {
        return map.get(token);
    }

    public static boolean tokenTimeout(String token) {
        if (map.get(token) == null) {
            return true;
        } else {
            SessionWrap wrap = map.get(token);
            if (wrap == null) {
                return true;
            }
            if (wrap instanceof AdminSessionWrap) {
                AdminSession session = ((AdminSessionWrap) wrap).getAdminSession();
                return session == null || session.getExpireAt() <= (new Date().getTime());
            } else {
                return true;
            }
        }

    }

    public static void putSession(String token, SessionWrap sess) {
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
        }
        map.put(token, sess);
    }

    public static void removeSession(String token) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (token.equals(key)) {
                iterator.remove();
                map.remove(key);
            }
        }
    }

    public SessionWrap adminPermissionCheck(Enum type, String token, String permission) throws ServiceException {

        if (tokenTimeout(token)) {
            if (type == AdminType.ADMIN) {
                AdminSession session = adminService.adminSession(token);

                if (session != null && session.getExpireAt() > (new Date().getTime())) {
                    Admin admin = adminService.admin(session.getAdminId(), true);
                    if (admin != null && admin.getStatus() == 1) {
                        AdminSessionWrap wrap = new AdminSessionWrap(admin, session);
                        putSession(token, wrap);
                        return wrap;
                    } else {
                        throw new ServiceException(ErrorCode.NO_PERMISSION.getCode());
                    }
                } else {
                    throw new ServiceException(ErrorCode.SESSIONTIMEOUT.getCode());
                }
            }
        }

        {
            boolean pass = false;

            SessionWrap wrap = getSession(token);
            if (wrap == null) {
                throw new ServiceException(ErrorCode.SESSIONTIMEOUT.getCode());
            }

            if (StringUtils.isEmpty(permission) || permission.equals("NONE")) {
                pass = true;
            } else {
                String permissions = "999";
                if (wrap instanceof AdminSessionWrap) {
                    Admin admin = ((AdminSessionWrap) wrap).getAdmin();
                    permissions = admin.getRole().getPermissions();
                }

                if (!(StringUtils.isEmpty(permissions) || permissions.length() <= 1)) {
                    String[] ps = permissions.split(",");
                    for (String p : ps) {
                        if (p.equals(permission)) {
                            pass = true;
                        }
                    }
                }
            }

            if (pass) {
                return wrap;
            } else {
                throw new ServiceException(ErrorCode.NO_PERMISSION.getCode());
            }
        }

    }

}
