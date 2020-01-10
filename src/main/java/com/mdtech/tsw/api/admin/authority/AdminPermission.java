package com.mdtech.tsw.api.admin.authority;

import com.mdtech.tsw.common.entity.Constants;

public enum AdminPermission {

    //    none
    NONE("", ""),

    /* 功能模块 */
    // admin&role
    ROLE_EDIT("管理组管理", Constants.LEVEL_IMPORTANT), ADMIN_LIST("管理员列表", Constants.LEVEL_IMPORTANT), ADMIN_EDIT("编辑管理员", Constants.LEVEL_IMPORTANT),

    //info
    BANNER_EDIT("Banner管理", Constants.LEVEL_PRIMARY),
    ARTICLE_EDIT("动态管理", Constants.LEVEL_PRIMARY),
    CUSTCASE_EDIT("案例管理", Constants.LEVEL_PRIMARY),
    CUSTEVAL_EDIT("评价管理", Constants.LEVEL_PRIMARY);


    private String val;
    private String level;

    AdminPermission(String val, String level) {
        this.val = val;
        this.level = level;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
