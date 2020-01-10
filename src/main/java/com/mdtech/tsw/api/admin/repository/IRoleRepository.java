package com.mdtech.tsw.api.admin.repository;

import com.mdtech.tsw.api.admin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}