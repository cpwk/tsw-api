package com.mdtech.tsw.api.custeval.qo;

import com.mdtech.tsw.common.reposiotry.support.DataQueryObjectPage;
import com.mdtech.tsw.common.reposiotry.support.QueryField;
import com.mdtech.tsw.common.reposiotry.support.QueryType;

public class CustevalQo extends DataQueryObjectPage {

    @QueryField(type = QueryType.EQUAL, name = "status")
    private Integer status = 1;

    public CustevalQo() {

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status == 0 ? null : status;
    }


}
