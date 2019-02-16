package com.tkm.dao;

import com.tkm.domain.SysPermission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from sys_permission")
    List<SysPermission> findAll();

    @Insert("insert into sys_permission values (SEQ_PERMISSION.nextval,#{permissionName},#{url},#{pid})")
    void save(SysPermission permission);


}
