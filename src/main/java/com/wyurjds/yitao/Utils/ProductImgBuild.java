package com.wyurjds.yitao.Utils;

import com.wyurjds.yitao.Dto.ProductIncludeImg;
import com.wyurjds.yitao.Entity.Products;

import java.util.ArrayList;

public class ProductImgBuild {

    public static ProductIncludeImg getOneProduct(Products products){
        ProductIncludeImg productIncludeImg=new ProductIncludeImg(products);
        return productIncludeImg;
    }

    public static ArrayList<ProductIncludeImg> getListProduct(ArrayList<Products> data){
        ArrayList<ProductIncludeImg> result=new ArrayList<ProductIncludeImg>();
            for (int i = 0; i < data.size(); i++) {
                result.add(getOneProduct(data.get(i)));
            }
        return result;
    }

}
