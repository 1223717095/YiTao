package com.wyurjds.yitao.Controller;


import com.wyurjds.yitao.Dto.SendMessageRequest;
import com.wyurjds.yitao.Dto.YitaoResult;
import com.wyurjds.yitao.Service.MessagePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@CrossOrigin
@RequestMapping("/MessagePage")
public class MessagePageController {

    @Autowired
    private MessagePageService messagePageService;


    //获取未读消息接口
    @ResponseBody
    @RequestMapping(value = "/getUnreadNews", method = RequestMethod.POST)
    public YitaoResult getUnreadNews(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=messagePageService.getUnreadNews(wxId);
        return yitaoResult;
    }

    //获取消息列表接口
    @ResponseBody
    @RequestMapping(value = "/getMyOneNews", method = RequestMethod.POST)
    public YitaoResult getMyOneNews(@RequestParam("wxId") String wxId){
        YitaoResult yitaoResult=messagePageService.getMyOneNews(wxId);
        return yitaoResult;
    }

    //获取一个消息框的全部消息
    @ResponseBody
    @RequestMapping(value = "/getMyAllNews", method = RequestMethod.POST)
    public YitaoResult getMyAllNews(@RequestParam("buyerId") String buyerId,@RequestParam("productId") long productId){
        YitaoResult yitaoResult=messagePageService.getMyAllNews(buyerId,productId);
        return yitaoResult;
    }

    //发送消息接口
    @ResponseBody
    @RequestMapping(value = "/SendMessage", method = RequestMethod.POST)
    public YitaoResult SendMessage(@RequestBody SendMessageRequest sendMessageRequest){
        YitaoResult yitaoResult=messagePageService.sendMessage(sendMessageRequest);
        return yitaoResult;
    }

    //删除聊天框
    @ResponseBody
    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    public YitaoResult deleteMessage(@RequestParam("buyerId") String buyerId,
                                     @RequestParam("productId") long productId){
        YitaoResult yitaoResult=messagePageService.deleteMessage(buyerId, productId);
        return yitaoResult;
    }
}
