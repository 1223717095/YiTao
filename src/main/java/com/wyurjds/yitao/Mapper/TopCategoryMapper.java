package com.wyurjds.yitao.Mapper;

import com.wyurjds.yitao.Entity.TopCategory;
import com.wyurjds.yitao.Utils.TopCategoryExtend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TopCategoryMapper {

    /**
     * 查询所有大分类
     * @return
     */
    List<TopCategory> queryAllTopCategory();

    /**
     * 查询所有大分类以及其对应的小分类
     * @return
     */
    List<TopCategoryExtend> queryTopAndSecondCategorys();

}
