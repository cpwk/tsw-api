package com.mdtech.tsw.common.controller;

import com.mdtech.tsw.api.admin.authority.AdminPermission;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.authority.SessionUtil;
import com.mdtech.tsw.common.context.Context;
import com.mdtech.tsw.common.context.Contexts;
import com.mdtech.tsw.common.context.SessionThreadLocal;
import com.mdtech.tsw.common.context.SessionWrap;
import com.mdtech.tsw.common.entity.ApiParams;
import com.mdtech.tsw.common.entity.ErrorCode;
import com.mdtech.tsw.common.exception.DetailedException;
import com.mdtech.tsw.common.util.WebUtils;
import com.sunnysuperman.commons.util.FormatUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DefaultInterceptor extends SessionUtil implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (CrossDomainHandler.handle(request, response)) {
            return false;
        }

        Context wrapper = new Context();
        wrapper.setRequestIp(WebUtils.getRemoteAddress(request));
        wrapper.setCustomerId(FormatUtil.parseLong(WebUtils.getHeader(request, ApiParams.CUSTOMER_ID)));
        SessionThreadLocal.getInstance().set(wrapper);

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        boolean authorized = false;
        RequiredPermission requiredPermission = handlerMethod.getMethodAnnotation(RequiredPermission.class);
        for (AdminType adminType : requiredPermission.adminType()) {
            if (adminType == AdminType.ADMIN) {
                //多个权限满足其一即可
                for (AdminPermission permission : requiredPermission.adminPermission()) {
                    authorized = findSessionWrap(AdminType.ADMIN, request, permission.name()) != null;
                    if (authorized) {
                        break;
                    }
                }
            } else {
                // no session
                authorized = true;
            }
            if (authorized) {
                break;
            }
        }
        if (!authorized) {
            throw new DetailedException(ErrorCode.SESSIONTIMEOUT.name());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    private SessionWrap findSessionWrap(Enum type, HttpServletRequest request, String permission) throws Exception {
        String token = WebUtils.getHeader(request, ApiParams.ADMIN_TOKEN);
        SessionWrap wrap = adminPermissionCheck(type, token, permission);
        Contexts.get().setSession(wrap);
        return wrap;
    }

}