package com.wyurjds.yitao.Mapper;

import com.wyurjds.yitao.Dto.SendMessageRequest;
import com.wyurjds.yitao.Entity.News;
import com.wyurjds.yitao.Entity.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface NewsMapper {

    ArrayList<Long> userGetAllProductId(@Param("wxId") String wxId);

    ArrayList<News> buyerProductIdGetAllNews(@Param("buyerId") String buyerId,@Param("productId") Long productId);

    News senderProductIdGetOneNews(@Param("senderId") String senderId,@Param("productId") Long productId);

    ArrayList<String> productIdGetsenderId(@Param("productId") Long productId,@Param("sellerId") String sellerId);

    ArrayList<String> productIdGetreceiverId(@Param("productId") Long productId,@Param("sellerId") String sellerId);

    int addOneNew(@Param("sendMessageRequest" ) SendMessageRequest sendMessageRequest);

    void deleteMessage(@Param("buyerId") String buyerId,
                       @Param("productId") long productId);
}
