package com.mdtech.tsw.api.admin.repository;

import com.mdtech.tsw.api.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsername(String username);

}