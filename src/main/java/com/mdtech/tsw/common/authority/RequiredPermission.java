package com.mdtech.tsw.common.authority;

import com.mdtech.tsw.api.admin.authority.AdminPermission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RequiredPermission {

    AdminType[] adminType();

    AdminPermission[] adminPermission() default AdminPermission.NONE;

}
