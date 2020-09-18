package com.wyurjds.yitao.Service;


import com.wyurjds.yitao.Dto.NewsWithProduct;
import com.wyurjds.yitao.Dto.ProductIdAndSellerId;
import com.wyurjds.yitao.Dto.SendMessageRequest;
import com.wyurjds.yitao.Dto.YitaoResult;
import com.wyurjds.yitao.Entity.News;
import com.wyurjds.yitao.Entity.UnreadNews;
import com.wyurjds.yitao.Entity.Users;
import com.wyurjds.yitao.Mapper.NewsMapper;
import com.wyurjds.yitao.Mapper.ProductsMapper;
import com.wyurjds.yitao.Mapper.UnreadNewsMapper;
import com.wyurjds.yitao.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class MessagePageService {


    @Autowired
    private UnreadNewsMapper unreadNewsMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private UserMapper userMapper;


    public YitaoResult getUnreadNews(String wxId){
        ArrayList<UnreadNews> news =unreadNewsMapper.getUnreadNews(wxId);
        YitaoResult result;
        if(news!=null){
            result=YitaoResult.ok(news);
            unreadNewsMapper.deleteUnreadNews(wxId);
        }
        else {
            result=YitaoResult.build(200,"无新消息");
        }
        return result;
    }

    public YitaoResult getMyOneNews(String wxId){
        //获取与我有关的全部商品id
        ArrayList<Long> allProductId=newsMapper.userGetAllProductId(wxId);
        //根据商品id获取卖家id
        ArrayList<ProductIdAndSellerId> productIdAndSellerIds=new ArrayList<ProductIdAndSellerId>();
        if(allProductId!=null){
            for(int i=0;i<allProductId.size();i++){
                productIdAndSellerIds.add(productsMapper.productIdGetSellerId(allProductId.get(i)));
            }
        }
        //分别查询消息表的发送者和接收者，找出每个商品的全部买家
        ArrayList<HashSet<String>> senderWithProductId=new ArrayList<HashSet<String>>();
        YitaoResult yitaoResult;
        if(productIdAndSellerIds!=null){
            for (int i=0;i<productIdAndSellerIds.size();i++){
                ArrayList<String> data1=newsMapper.productIdGetsenderId(productIdAndSellerIds.get(i).getProductId(),productIdAndSellerIds.get(i).getSellerId());
                HashSet<String> buyerId=new HashSet<String>();
                for (String d:data1){
                    buyerId.add(d);
                }
                ArrayList<String> data2=newsMapper.productIdGetreceiverId(productIdAndSellerIds.get(i).getProductId(),productIdAndSellerIds.get(i).getSellerId());
                for (String d:data2){
                    buyerId.add(d);
                }
                senderWithProductId.add(buyerId);
            }
            //根据商品id与买家id查找最新一条信息
            System.out.println(senderWithProductId);
            ArrayList<NewsWithProduct> news=new ArrayList<NewsWithProduct>();
            for(int i=0;i<productIdAndSellerIds.size();i++){
                for(String buyer:senderWithProductId.get(i)){
                    News oneNew=newsMapper.senderProductIdGetOneNews(buyer,productIdAndSellerIds.get(i).getProductId());
                    NewsWithProduct newsWithProduct=new NewsWithProduct(oneNew);
                    newsWithProduct.setProduct(productsMapper.getOneProduct(productIdAndSellerIds.get(i).getProductId()));
                    //获取对方信息
                    if(newsWithProduct.getNewsSenderId().equals(wxId)!=true){
                        Users users=userMapper.userIdQueryUser(newsWithProduct.getNewsSenderId());
                        newsWithProduct.setUser(users);
                    }else {
                        Users users=userMapper.userIdQueryUser(newsWithProduct.getNewsReceiverId());
                        newsWithProduct.setUser(users);
                    }
                    news.add(newsWithProduct);
                }
            }
            yitaoResult=YitaoResult.ok(news);
        }
        else{
            yitaoResult=YitaoResult.build(500,"无消息");
        }
        return yitaoResult;
    }

    public YitaoResult sendMessage(SendMessageRequest sendMessageRequest){
        newsMapper.addOneNew(sendMessageRequest);
        unreadNewsMapper.addOneNew(sendMessageRequest);
        YitaoResult yitaoResult=YitaoResult.ok();
        return yitaoResult;
    }

    public YitaoResult getMyAllNews(String buyerId,long productId){
        ArrayList<News> data=newsMapper.buyerProductIdGetAllNews(buyerId,productId);
        YitaoResult yitaoResult=YitaoResult.ok(data);
        return yitaoResult;
    }

    public YitaoResult deleteMessage(String buyerId, long productId){
        newsMapper.deleteMessage(buyerId, productId);
        YitaoResult yitaoResult=YitaoResult.ok();
        return yitaoResult;
    }
}
