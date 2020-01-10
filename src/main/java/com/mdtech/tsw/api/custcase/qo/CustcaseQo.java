package com.mdtech.tsw.api.custcase.qo;

import com.mdtech.tsw.common.reposiotry.support.DataQueryObjectPage;
import com.mdtech.tsw.common.reposiotry.support.QueryField;
import com.mdtech.tsw.common.reposiotry.support.QueryType;

public class CustcaseQo extends DataQueryObjectPage {

    private String sortPropertyName = "priority";

    @QueryField(type = QueryType.EQUAL, name = "status")
    private Integer status = 1;

    @QueryField(type = QueryType.EQUAL, name = "settop")
    private Integer ontop;

    @QueryField(type = QueryType.EQUAL, name = "settop")
    private Integer offtop;

    public CustcaseQo() {

    }

    @Override
    public String getSortPropertyName() {
        return sortPropertyName;
    }

    @Override
    public void setSortPropertyName(String sortPropertyName) {
        this.sortPropertyName = sortPropertyName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status == 0 ? null : status;
    }

    public Integer getOntop() {
        return ontop;
    }

    public void setOntop(Integer ontop) {
        this.ontop = ontop == 0 ? null : ontop;
    }

    public Integer getOfftop() {
        return offtop;
    }

    public void setOfftop(Integer offtop) {
        this.offtop = offtop == 0 ? null : offtop;
    }

}
