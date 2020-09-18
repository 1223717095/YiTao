package com.wyurjds.yitao.Mapper;


import com.wyurjds.yitao.Dto.SendMessageRequest;
import com.wyurjds.yitao.Entity.UnreadNews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface UnreadNewsMapper {

    //获取全部未读信息
    ArrayList<UnreadNews> getUnreadNews(@Param("wxId") String wxId);

    //添加未读信息
    int addOneNew(@Param("sendMessageRequest" ) SendMessageRequest sendMessageRequest);

    //删除未读信息
    void deleteUnreadNews(@Param("wxId") String wxId);
}
