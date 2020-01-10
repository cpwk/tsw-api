package com.mdtech.tsw.api.admin.repository;

import com.mdtech.tsw.api.admin.model.AdminSession;
import com.mdtech.tsw.common.reposiotry.BaseRepository;

public interface IAdminSessionRepository extends BaseRepository<AdminSession, Integer> {

    AdminSession findByToken(String token);

}