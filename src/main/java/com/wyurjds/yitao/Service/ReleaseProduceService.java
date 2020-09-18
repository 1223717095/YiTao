package com.wyurjds.yitao.Service;


import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Mapper.ProductsMapper;
import com.wyurjds.yitao.Mapper.TopCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ReleaseProduceService {

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private TopCategoryMapper topCategoryMapper;

    public void addProduct(Products products) throws SQLException {
        productsMapper.insertProduct(products);
    }

    public void updateProduct(Products products) throws SQLException {
        productsMapper.updateProduct(products);

    }

}
