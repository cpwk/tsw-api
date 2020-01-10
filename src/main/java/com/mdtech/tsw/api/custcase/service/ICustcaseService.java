package com.mdtech.tsw.api.custcase.service;

import com.mdtech.tsw.api.custcase.model.Custcase;
import com.mdtech.tsw.api.custcase.qo.CustcaseQo;
import com.mdtech.tsw.common.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustcaseService {

    List<Custcase> getTopCases(int limit);

    Custcase custcase(int id);

    Page<Custcase> custcases(CustcaseQo qo, boolean adm) throws ServiceException;

    void save(Custcase custcase) throws ServiceException;

    void remove(int id);

}
