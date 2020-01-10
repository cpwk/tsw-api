package com.mdtech.tsw.api.admin.authority;

import com.mdtech.tsw.common.authority.Permission;

import java.util.ArrayList;
import java.util.List;

public class AdminPermissionVO extends Permission {

    private static List<Permission> list = null;

    public static List<Permission> initPermissions() {
        if (list == null) {
            list = new ArrayList<>();
            for (AdminPermission p : AdminPermission.values()) {
                list.add(new Permission(p.name(), p.getVal(), p.getLevel()));
            }
        }
        return list;
    }

    public static List<Permission> initPermissionsByPs(String ps) {
        List<Permission> list = initPermissions();
        List<Permission> result = new ArrayList<Permission>();
        String[] pl = ps.split(",");
        if (pl.length > 0) {
            for (String s : pl) {
                for (Permission p : list) {
                    if (s.equals(p.getCode()))
                        result.add(p);
                }
            }
        }
        return result;
    }


}
