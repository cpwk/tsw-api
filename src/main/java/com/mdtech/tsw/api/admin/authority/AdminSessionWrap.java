package com.mdtech.tsw.api.admin.authority;

import com.alibaba.fastjson.annotation.JSONField;
import com.mdtech.tsw.api.admin.model.Admin;
import com.mdtech.tsw.api.admin.model.AdminSession;
import com.mdtech.tsw.common.context.SessionWrap;

public class AdminSessionWrap implements SessionWrap {

    private Admin admin;
    @JSONField(serialize = false)
    private AdminSession adminSession;

    public AdminSessionWrap(Admin admin, AdminSession adminSession) {
        this.admin = admin;
        this.adminSession = adminSession;
    }

    public AdminSession getAdminSession() {
        return adminSession;
    }

    public void setAdminSession(AdminSession adminSession) {
        this.adminSession = adminSession;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
