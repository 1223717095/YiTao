package com.wyurjds.yitao.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyurjds.yitao.Dto.LoginData;
import com.wyurjds.yitao.Dto.LoginRequest;
import com.wyurjds.yitao.Dto.YitaoResult;
import com.wyurjds.yitao.Entity.*;
import com.wyurjds.yitao.Mapper.*;
import com.wyurjds.yitao.Utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HomePageService {

    @Autowired
    private TopCategoryMapper topCategoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private BannerPicMapper bannerPicMapper;

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    public List<TopCategory> getAllTopCategory(){
        List<TopCategory> topCategoryList = topCategoryMapper.queryAllTopCategory();
        return topCategoryList;
    }


    public PageBean findProductByCondition(QueryObject qb) {
        int count = productsMapper.queryProductsCount(qb);
        PageBean pageBean;
        if(count == 0){
            pageBean = new PageBean();
        }else{
            List<Products> products = productsMapper.selectProductsByCondition(qb);
            pageBean = new PageBean(qb.getCurrentPage(),qb.getPageSize(),count,products);
        }
        return pageBean;
    }

    public ProductsExtend findProductById(Integer productId) {
        ProductsExtend product = productsMapper.queryProductsById(productId);
        return product;
    }

    public List<TopCategoryExtend> findAllCategorys() {
        List<TopCategoryExtend> categorysList = topCategoryMapper.queryTopAndSecondCategorys();
        return categorysList;
    }

    public void addToCollection(Collection collection) {
        collectionMapper.insertCollection(collection);
    }

    public void moveFromCollection(Collection collection) {
        collectionMapper.deleteFromCollection(collection);
    }


    public YitaoResult login(LoginRequest loginRequest) throws IOException {

        //访问微信官方api获取Openid
        String uri="https://api.weixin.qq.com/sns/jscode2session?appid=wxf94a47099bcbe70c&secret=acc79e5d322f4f928b9174a79bf179c8&js_code="+loginRequest.getCode()+"&grant_type=authorization_code";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        String strbody= restTemplateBuilder.build().exchange(uri, HttpMethod.GET, entity,String.class).getBody();
        //解析api得到的json
        ObjectMapper mapper = new ObjectMapper();
        LoginData loginData=mapper.readValue(strbody, LoginData.class);
        Users users=new Users(loginData.getOpenid(),loginRequest.getWechatUserName(),loginRequest.getUserPic());
        Users u=userMapper.queryUser(users);
        if(u==null){
            userMapper.inserUser(users);
        }
        return YitaoResult.ok(loginData.getOpenid());
    }

    public List<BannerPic> getAllBannerPics() {

        List<BannerPic> bannerPics = bannerPicMapper.queryBannerPics();
        return bannerPics;
    }

    public YitaoResult alterProductsStatus( String buyerId,String sellerId,long productId) {
        productsMapper.updateProductStatus(productId);
        transactionRecordMapper.addTransactionRecord(sellerId,productId,buyerId);
        YitaoResult result=YitaoResult.ok();
        return result;
    }

    public Collection checkCollectionStatus(long productId, String collectorId) {
        Collection collection = collectionMapper.queryCollectionStatus(productId,collectorId);
        return collection;
    }
}
