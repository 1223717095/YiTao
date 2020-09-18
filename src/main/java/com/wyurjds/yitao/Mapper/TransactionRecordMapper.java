package com.wyurjds.yitao.Mapper;

import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Entity.TransactionRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface TransactionRecordMapper {

    //得到我的全部订单
    ArrayList<TransactionRecord> getMyBoughtTransactionRecord(@Param("wxId") String wxId);

    //添加订单
    void addTransactionRecord(@Param("sellerId") String sellerId,@Param("productId") long productId,@Param("buyerId") String buyerId);

}
