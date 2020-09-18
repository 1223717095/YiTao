package com.wyurjds.yitao.Mapper;

import com.wyurjds.yitao.Entity.BannerPic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BannerPicMapper {
    List<BannerPic> queryBannerPics();
}
