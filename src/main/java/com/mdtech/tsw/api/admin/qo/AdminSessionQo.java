package com.mdtech.tsw.api.admin.qo;

import com.mdtech.tsw.common.reposiotry.support.DataQueryObjectPage;
import com.mdtech.tsw.common.reposiotry.support.QueryField;
import com.mdtech.tsw.common.reposiotry.support.QueryType;

public class AdminSessionQo extends DataQueryObjectPage {

    @QueryField(type = QueryType.EQUAL, name = "adminId")
    private Integer adminId;

    public AdminSessionQo() {
    }

    public AdminSessionQo(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

}
