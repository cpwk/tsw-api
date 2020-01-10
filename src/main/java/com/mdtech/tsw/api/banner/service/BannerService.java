package com.mdtech.tsw.api.banner.service;

import com.mdtech.tsw.api.banner.model.Banner;
import com.mdtech.tsw.api.banner.qo.BannerQo;
import com.mdtech.tsw.api.banner.repository.IBannerRepository;
import com.mdtech.tsw.common.exception.DetailedException;
import com.mdtech.tsw.common.exception.ServiceException;
import com.mdtech.tsw.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService implements IBannerService {

    @Autowired
    private IBannerRepository bannerRepository;

    @Override
    public List<Banner> banners(BannerQo qo, boolean admin) {
        if (admin) {
            qo.setStatus(0);
        }
        return bannerRepository.findAll(qo);
    }

    @Override
    public Banner banner(int id) {
        return bannerRepository.getOne(id);
    }

    @Override
    public void save(Banner banner) throws ServiceException {
        if (StringUtils.isEmpty(banner.getImg())) {
            throw new DetailedException("请上传图片");
        }
        bannerRepository.save(banner);
    }

    @Override
    public void remove(int id) {
        bannerRepository.deleteById(id);
    }

}
