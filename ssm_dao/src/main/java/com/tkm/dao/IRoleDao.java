package com.tkm.dao;

import com.tkm.domain.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.management.relation.Role;
import java.util.List;

public interface IRoleDao {

//    查询全部
    @Select("select * from sys_role")
    List<SysRole> findAll();

//    添加
    @Insert("insert into sys_role values (SEQ_SYSROLE.nextval,#{roleName},#{roleDesc})")
    void save(SysRole role);


    @Select("select r.* from sys_role r inner join sys_user_role ur on r.id = ur.roleid where useri=#{userId}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "permissions")

    })
    List<Role> findRolesByUserId(Integer userId);
}
