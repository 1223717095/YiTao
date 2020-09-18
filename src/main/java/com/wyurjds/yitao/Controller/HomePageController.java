package com.wyurjds.yitao.Controller;


import com.wyurjds.yitao.Dto.LoginRequest;
import com.wyurjds.yitao.Dto.YitaoResult;
import com.wyurjds.yitao.Entity.BannerPic;
import com.wyurjds.yitao.Entity.Collection;
import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Entity.TopCategory;
import com.wyurjds.yitao.Service.HomePageService;
import com.wyurjds.yitao.Utils.*;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/HomePage")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    //商品图片访问地址
    @Value("${GET_PIC_URL}")
    private String getPicUrl;

    //轮播图片访问地址
    @Value("${Get_BannerPics_URL}")
    private String bannerPicsURL;

    //大分类图片访问地址
    @Value("${Top_Category}")
    private String top_Category;

    /**
     * 首页获取大分类标签
     * @return
     */
    @RequestMapping("/listTopCategory")
    @ResponseBody
    public YitaoResult listTopCategory(){
        List<TopCategory> allTopCategorys = homePageService.getAllTopCategory();
        for(TopCategory topCategory : allTopCategorys){
            topCategory.setCategoryPicUrl(top_Category + topCategory.getCategoryPicUrl());
        }
        YitaoResult result = YitaoResult.ok(allTopCategorys);
        return result;
    }

    //登陆接口
    @RequestMapping("/login")
    @ResponseBody
    public YitaoResult login(@RequestBody LoginRequest loginRequest) throws IOException {
        YitaoResult yitaoResult=homePageService.login(loginRequest);
        return yitaoResult;
    }

    /**
     * 商品分页展示
     * @return
     */
    @RequestMapping("/queryProducts")
    @ResponseBody
    public YitaoResult productsPagination(@RequestBody(required=false) QueryObject qb){
        if(qb == null){
            qb = new QueryObject();
        }
        PageBean pageBean = homePageService.findProductByCondition(qb);
        List<Products> data = (List<Products>) pageBean.getData();
        //为获取到的商品的图片路径添加前面部分
        List<String> urlList;
        for(Products products : data){

            if(products.getProductUrl() != null && products.getProductUrl() != ""){
                urlList = Arrays.asList(products.getProductUrl().split(","));
                String urlStrs = "";
                for(int i = 0;i < urlList.size();i++ ){
                    urlList.set(i,getPicUrl + urlList.get(i));
                }
                // 把list数组转字符串
                urlStrs = StringUtils.join(urlList, ',');
                products.setProductUrl(urlStrs);
            }


        }
        urlList = null;
        return YitaoResult.build(200,"ok",pageBean);
    }

    /**
     * 根据id查询相应的商品
     * @param productId
     * @return
     */
    @RequestMapping("/queryProduct")
    @ResponseBody
    public YitaoResult findProduct(Integer productId){
        ProductsExtend product = homePageService.findProductById(productId);
        if(product == null){
            return YitaoResult.build(500,"error",null);
        }

        String picUrls = product.getProduct().getProductUrl();
        if(picUrls != null && picUrls != ""){
            // 将获取到的图片名前加上完整的路径
            List<String> urlList = Arrays.asList(picUrls.split(","));
            for(int i = 0;i < urlList.size();i++ ){
                urlList.set(i,getPicUrl + urlList.get(i));
            }
            // 把list数组转字符串
            String urlStrs = StringUtils.join(urlList, ',');
            product.getProduct().setProductUrl(urlStrs);

        }
        return YitaoResult.build(200,"ok",product);
    }

    /**
     * 查询所有的大分类以及其对应的小分类
     * @return
     */
    @RequestMapping("/queryCategorys")
    @ResponseBody
    public YitaoResult findAllCategory(){
        List<TopCategoryExtend> categorys = homePageService.findAllCategorys();
        if(categorys != null && categorys.size() > 0){
            return YitaoResult.build(200,"ok",categorys);
        }
        return YitaoResult.build(500,"error",null);
    }

    /**
     * 添加收藏
     * @param collection
     * @return
     */
    @RequestMapping("/addCollection")
    @ResponseBody
    public String addCollection(@RequestBody Collection collection){
        homePageService.addToCollection(collection);
        return "ok";
    }

    /**
     * 删除收藏
     * @param collection
     * @return
     */
    @RequestMapping("/moveCollection")
    @ResponseBody
    public String moveCollection(@RequestBody Collection collection){
        homePageService.moveFromCollection(collection);
        return "ok";
    }

    @RequestMapping("/getBannerPics")
    @ResponseBody
    public YitaoResult getBannerPics(){
        List<BannerPic> bannerPics = homePageService.getAllBannerPics();
        if(bannerPics != null && bannerPics.size() > 0){
            for(BannerPic bannerPic : bannerPics){
                bannerPic.setPicUrl(bannerPicsURL + bannerPic.getPicUrl());
            }
        }
        return YitaoResult.ok(bannerPics);
    }

    /**
     * 修改商品状态//已售出
     * @param
     * @return
     */
    @RequestMapping("/alterProductStatus")
    @ResponseBody
    public YitaoResult alterProductStatus(@RequestParam("buyerId") String buyerId,@RequestParam("sellerId") String sellerId, @RequestParam("productId") long productId){
        YitaoResult result=homePageService.alterProductsStatus(buyerId,sellerId,productId);
        return result;
    }

    /**
     * 查找商品是否被收藏
     * @param collection
     * @return
     */
    @RequestMapping("/isCollection")
    @ResponseBody
    public String checkProductIsCollection(@RequestBody Collection collection){
        Collection coll = homePageService.checkCollectionStatus(collection.getProductId(),collection.getCollectorId());
        if(coll != null){
            return "OK";
        }
        //找不到
        return "error";
    }


}
