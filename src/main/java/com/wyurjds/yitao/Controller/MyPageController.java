package com.wyurjds.yitao.Controller;


import com.wyurjds.yitao.Dto.YitaoResult;
import com.wyurjds.yitao.Mapper.TransactionRecordMapper;
import com.wyurjds.yitao.Service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@CrossOrigin
@RequestMapping("/MyPage")
public class MyPageController {

    @Autowired
    private MyPageService myPageService;


    //根据微信id查找全部发布的商品
    @ResponseBody
    @RequestMapping(value = "/getMyProduct", method = RequestMethod.POST)
    public YitaoResult getMyProduct(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=myPageService.getMyProduct(wxId);
        return yitaoResult;
    }


    //根据微信id查找全部收藏的商品
    @ResponseBody
    @RequestMapping(value = "/getMyCollection", method = RequestMethod.POST)
    public YitaoResult getMyCollection(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=myPageService.getMyCollection(wxId);
        return yitaoResult;
    }


    //根据微信id查找全部已卖出商品
    @ResponseBody
    @RequestMapping(value = "/getSoldProduct", method = RequestMethod.POST)
    public YitaoResult getSoldProduct(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=myPageService.getSoldProduct(wxId);
        return yitaoResult;
    }


    //根据微信id查找全部买到的商品
    @ResponseBody
    @RequestMapping(value = "/getOwnerProducts", method = RequestMethod.POST)
    public YitaoResult getOwnerProducts(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=myPageService.getOwnerProducts(wxId);
        return yitaoResult;
    }

    //根据商品id获取一个商品
    @ResponseBody
    @RequestMapping(value = "/getOneProduct", method = RequestMethod.POST)
    public YitaoResult getOneProduct(@RequestParam("productId") long productId){
        YitaoResult yitaoResult=myPageService.getOneProduct(productId);
        return yitaoResult;
    }

    //根据微信id获取该用户信息
    @ResponseBody
    @RequestMapping(value = "/wxIdGetUrlName", method = RequestMethod.POST)
    public YitaoResult wxIdGetUrlName(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=myPageService.wxIdGetUrlName(wxId);
        return yitaoResult;
    }

    //上下架商品
    @ResponseBody
    @RequestMapping(value = "/onOffShelves", method = RequestMethod.POST)
    public YitaoResult wxIdGetUrlName(@RequestParam("productId") long productId,
                                      @RequestParam("productStatus") int productStatus){
        YitaoResult yitaoResult=myPageService.onOffShelves(productId,productStatus);
        return yitaoResult;
    }
}
