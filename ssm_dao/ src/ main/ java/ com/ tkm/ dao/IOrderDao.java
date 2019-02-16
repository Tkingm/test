package com.tkm.dao;

import com.tkm.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderDao {
    @Select("select o.*,p.id pid,p.productnum,p.productname,p.cityname,p.productprice " +
            "from orders o inner join product p on o.productid=p.id")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "product.id",column = "pid"),
            @Result(property = "product.productNum",column = "productNum"),
            @Result(property = "product.productName",column = "productName"),
            @Result(property = "product.cityName",column = "cityName"),
            @Result(property = "product.productPrice",column = "productPrice")
    })
    List<Order> findAll();

    @Insert("insert into orders values (#{id},#{orderNum},#{peopleCount},#{product.productNum},#{product.productName},#{product.productPrice})")
    void add(Order order);

//  虎牙哈哈哈哈哈
}
