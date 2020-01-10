package com.mdtech.tsw.api.custeval.service;

import com.mdtech.tsw.api.custeval.model.Custeval;
import com.mdtech.tsw.api.custeval.qo.CustevalQo;
import com.mdtech.tsw.api.custeval.repository.ICustevalRepository;
import com.mdtech.tsw.common.entity.Constants;
import com.mdtech.tsw.common.exception.DetailedException;
import com.mdtech.tsw.common.exception.ServiceException;
import com.mdtech.tsw.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustevalService implements ICustevalService {

    @Autowired
    private ICustevalRepository custevalRepository;

    @Override
    public List<Custeval> getTopCustevals(int limit) {
        CustevalQo qo = new CustevalQo();
        qo.setPageSize(limit);
        return custevalRepository.findAll(qo).getContent();
    }

    @Override
    public Custeval custeval(int id) {
        return custevalRepository.getOne(id);
    }

    @Override
    public Page<Custeval> custevals(CustevalQo qo, boolean adm) {

        if (adm) {
            qo.setStatus(0);
        }
        return custevalRepository.findAll(qo);
    }

    @Override
    public void save(Custeval custeval) throws ServiceException {

        if (StringUtils.isEmpty(custeval.getTitle())) {
            throw new DetailedException("请填写内容");
        }
        if (StringUtils.isEmpty(custeval.getImg())) {
            throw new DetailedException("请上传封面图");
        }

        if (custeval.getId() == null) {
            custeval.setCreatedAt(System.currentTimeMillis());
        }
        if (custeval.getStatus() == null) {
            custeval.setStatus(Constants.STATUS_OK);
        }
        custevalRepository.save(custeval);
    }

    @Override
    public void remove(int id) {
        custevalRepository.deleteById(id);
    }

}
