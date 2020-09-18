package com.wyurjds.yitao.Mapper;

import com.wyurjds.yitao.Entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface CollectionMapper {

    ArrayList<Collection> getMyCollection(@Param("wxId") String wxId);

    /**
     * 添加收藏
     * @param collection
     */
    void insertCollection(Collection collection);

    /**
     * 删除收藏
     * @param collection
     */
    void deleteFromCollection(Collection collection);

    Collection queryCollectionStatus(@Param("productId") long productId, @Param("collectorId") String collectorId);
}
