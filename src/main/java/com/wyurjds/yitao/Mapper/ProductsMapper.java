package com.wyurjds.yitao.Mapper;

import com.wyurjds.yitao.Dto.ProductIdAndSellerId;
import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Utils.ProductsExtend;
import com.wyurjds.yitao.Utils.QueryObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface ProductsMapper {

    //获取我发布的商品
    ArrayList<Products> getMyProduct(@Param("wxId") String wxId);

    //根据商品id获取商品
    Products getOneProduct(@Param("productId") long productId);

    //获取我售出的商品
    ArrayList<Products> getSoldProduct(@Param("wxId") String wxId);

    //根据商品id获取卖家id
    ProductIdAndSellerId productIdGetSellerId(@Param("productId") long productId);

    /**
     * 添加商品
     * @param products
     */
    void insertProduct(Products products) throws SQLException;

    /**
     * 更新商品
     * @param products
     */
    void updateProduct(Products products) throws SQLException;

    /**
     * 根据商品id获取商品
     * @return
     */
    ProductsExtend queryProductsById(Integer productId);

    /**
     * 查询符合条件的商品的数目
     * @param qb
     * @return
     */
    int queryProductsCount(QueryObject qb);


    List<Products> selectProductsByCondition(QueryObject qb);

    //更改商品为售出状态
    void updateProductStatus(@Param("productId") Long productId);

    int onOffShelves(@Param("productId") Long productId,
                      @Param("productStatus") int productStatus);
}
