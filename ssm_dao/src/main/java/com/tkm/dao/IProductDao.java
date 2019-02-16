package com.tkm.dao;

import com.tkm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductDao {

    /*
    * 查询全部
    * */
    @Select("select * from product")
    List<Product>  findAll();

    @Insert("insert into product values(SEQ_PRODUCT.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("SELECT * from product where id=#{id}")
    Product findById(Integer id);

    @Update("update product set productNum=#{productNum},productName=#{productName}" +
            ",cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice}," +
            "productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void update(Product product);


    @Delete("delete from product where id=#{id}")
    void delete(String productIds);

    /*
    * 分页查询
    * */
    @Select("select * from(select p.*,rownum rn from product p " +
            "where rownum <= #{index}) where rn> #{count}")
    List<Product> findByPage(@Param("index")int index,
                             @Param("count") int count);
    @Select("select count(1) from product")
    long count();
}
