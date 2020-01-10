package com.mdtech.tsw.api.banner.service;


import com.mdtech.tsw.api.banner.model.Banner;
import com.mdtech.tsw.api.banner.qo.BannerQo;
import com.mdtech.tsw.common.exception.ServiceException;

import java.util.List;

public interface IBannerService {

    List<Banner> banners(BannerQo qo, boolean admin);

    Banner banner(int id);

    void save(Banner banner) throws ServiceException;

    void remove(int id);
}
