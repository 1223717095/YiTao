package com.wyurjds.yitao.Utils;

import com.wyurjds.yitao.Entity.SecondCategory;
import com.wyurjds.yitao.Entity.TopCategory;

import java.util.ArrayList;
import java.util.List;

public class TopCategoryExtend {

    private TopCategory topCategory;

    private List<SecondCategory> secondCategories = new ArrayList<>();

    public TopCategory getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(TopCategory topCategory) {
        this.topCategory = topCategory;
    }

    public List<SecondCategory> getSecondCategories() {
        return secondCategories;
    }

    public void setSecondCategories(List<SecondCategory> secondCategories) {
        this.secondCategories = secondCategories;
    }
}
