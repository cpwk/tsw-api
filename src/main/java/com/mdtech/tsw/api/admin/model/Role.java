package com.mdtech.tsw.api.admin.model;


import com.mdtech.tsw.common.authority.Permission;
import com.mdtech.tsw.common.util.StringUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "permissions")
    private String permissions;

    @Transient
    private List<Permission> pstr;

    public Role() {
    }

    public List<Permission> getPstr() {
        return pstr;
    }

    public void setPstr(List<Permission> pstr) {
        this.pstr = pstr;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissions() {
        return this.permissions;
    }

    public void setPermissions(String permissions) {
        if (StringUtils.isNull(permissions)) {
            permissions = "";
        } else {
            permissions.replaceAll(" ", "");
        }
        this.permissions = permissions;
    }

}