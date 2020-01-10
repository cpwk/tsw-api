package com.mdtech.tsw.api.custcase.service;

import com.mdtech.tsw.api.custcase.model.Custcase;
import com.mdtech.tsw.api.custcase.qo.CustcaseQo;
import com.mdtech.tsw.api.custcase.repository.ICustcaseRepository;
import com.mdtech.tsw.common.entity.Constants;
import com.mdtech.tsw.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustcaseService implements ICustcaseService {

    @Autowired
    private ICustcaseRepository custcaseRepository;

    @Override
    public Custcase custcase(int id) {
        return custcaseRepository.getOne(id);
    }

    @Override
    public List<Custcase> getTopCases(int limit) {
        CustcaseQo qo = new CustcaseQo();
        qo.setPageSize(limit);
        qo.setOntop(1);
        return custcaseRepository.findAll(qo).getContent();
    }

    @Override
    public Page<Custcase> custcases(CustcaseQo qo, boolean adm) throws ServiceException {
        if (adm) {
            qo.setStatus(0);
        }
        return custcaseRepository.findAll(qo);

    }

    @Override
    public void save(Custcase custcase) throws ServiceException {

        if (custcase.getId() == null) {
            custcase.setCreatedAt(System.currentTimeMillis());
        }
        if (custcase.getStatus() == null) {
            custcase.setStatus(Constants.STATUS_OK);
        }
        custcaseRepository.save(custcase);
    }

    @Override
    public void remove(int id) {
        custcaseRepository.deleteById(id);
    }

}
