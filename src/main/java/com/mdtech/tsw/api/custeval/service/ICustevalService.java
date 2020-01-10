package com.mdtech.tsw.api.custeval.service;

import com.mdtech.tsw.api.custeval.model.Custeval;
import com.mdtech.tsw.api.custeval.qo.CustevalQo;
import com.mdtech.tsw.common.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustevalService {


    List<Custeval> getTopCustevals(int limit);

    Custeval custeval(int id);

    Page<Custeval> custevals(CustevalQo qo, boolean adm);

    void save(Custeval custeval) throws ServiceException;

    void remove(int id);

}
