package com.tkm.dao;

import com.tkm.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
System.out.println("AAAAAAAAAAAAAAAAA");
public interface IUserDao {

//    根据用户名查询

    @Select("select * from sys_user where username=#{username}")
    List<SysUser> findByName(String username);

    @Select("select * from sys_user")
    List<SysUser> findAll();

    @Select("insert into sys_user  values(SEQ_USER.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser user);

    @Select("select * from sys_user where id=#{userid}")
    @Results({
            @Result(id = true,property = "id",column = "id"),

            @Result(property = "roles",column = "id", javaType = List.class,
            many = @Many(select = "",fetchType = FetchType.LAZY))
    })
    SysUser findById(Integer id);
}
