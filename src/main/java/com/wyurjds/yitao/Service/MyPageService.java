package com.wyurjds.yitao.Service;


import com.wyurjds.yitao.Dto.ProductIncludeImg;
import com.wyurjds.yitao.Dto.YitaoResult;
import com.wyurjds.yitao.Entity.Collection;
import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Entity.TransactionRecord;
import com.wyurjds.yitao.Entity.Users;
import com.wyurjds.yitao.Mapper.CollectionMapper;
import com.wyurjds.yitao.Mapper.ProductsMapper;
import com.wyurjds.yitao.Mapper.TransactionRecordMapper;
import com.wyurjds.yitao.Mapper.UserMapper;
import com.wyurjds.yitao.Utils.ProductImgBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyPageService {

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    public YitaoResult getMyProduct(String wxId){
        ArrayList<Products> products=productsMapper.getMyProduct(wxId);
        ArrayList<ProductIncludeImg> data=ProductImgBuild.getListProduct(products);
        YitaoResult yitaoResult= YitaoResult.ok(data);
        return yitaoResult;
    }

    public YitaoResult getMyCollection(String wxId){
        YitaoResult yitaoResult;
        ArrayList<Collection> collectionData=collectionMapper.getMyCollection(wxId);
        System.out.println(collectionData);
        if(collectionData!=null){
            ArrayList<Products> productsData=new ArrayList<Products>();
            for(int i=0;i<collectionData.size();i++){
                System.out.println("1111"+collectionData.get(i).getProductId());
                productsData.add(productsMapper.getOneProduct(collectionData.get(i).getProductId()));
            }
            System.out.println(productsData);
            ArrayList<ProductIncludeImg> result=ProductImgBuild.getListProduct(productsData);
            yitaoResult=YitaoResult.ok(result);
        }
        else{
            yitaoResult=YitaoResult.ok();
        }

        return yitaoResult;
    }

    public YitaoResult getSoldProduct(String wxId){
        ArrayList<Products> data=productsMapper.getSoldProduct(wxId);
        ArrayList<ProductIncludeImg> result=ProductImgBuild.getListProduct(data);
        YitaoResult yitaoResult=YitaoResult.ok(result);
        return yitaoResult;
    }

    public YitaoResult getOwnerProducts(String wxId){
        ArrayList<TransactionRecord> data=transactionRecordMapper.getMyBoughtTransactionRecord(wxId);
        ArrayList<Products> productsData=new ArrayList<Products>();
        for(int i=0;i<data.size();i++){
            productsData.add(productsMapper.getOneProduct(data.get(i).getProductId()));
        }
        ArrayList<ProductIncludeImg> result=ProductImgBuild.getListProduct(productsData);
        YitaoResult yitaoResult=YitaoResult.ok(result);
        return yitaoResult;
    }

    public YitaoResult getOneProduct(long productId){
        Products products=productsMapper.getOneProduct(productId);
        YitaoResult yitaoResult;
        if(products==null){
            yitaoResult=YitaoResult.build(500,"无此商品");
        }
        else{
            yitaoResult=YitaoResult.ok(products);
        }
        return yitaoResult;
    }

    public YitaoResult wxIdGetUrlName(String wxId){
        Users users=userMapper.userIdQueryUser(wxId);
        YitaoResult yitaoResult;
        if(users==null){
            yitaoResult=YitaoResult.build(500,"无此用户");
        }
        else{
            yitaoResult=YitaoResult.ok(users);
        }
        return yitaoResult;
    }

    public YitaoResult onOffShelves(long productId,
                                    int productStatus){
        int result=productsMapper.onOffShelves(productId,productStatus);
        YitaoResult yitaoResult;
        if(result==1){
            yitaoResult=YitaoResult.ok();
        }else{
            yitaoResult=YitaoResult.build(500,"错误");
        }
        return yitaoResult;
    }
}
