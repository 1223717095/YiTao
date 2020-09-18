package com.wyurjds.yitao.Controller;


import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Service.ReleaseProduceService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 发布商品
 */
@Controller
@CrossOrigin
@RequestMapping("/ReleaseProduce")
@PropertySource("classpath:resource.properties")
public class ReleaseProduceController {

    @Autowired
    private ReleaseProduceService releaseProduceService;

    @Value("${SAVE_PIC_URL}")
    private String savePicUrl;

    @Value("${GET_PIC_URL}")
    private String getPicUrl;

    /**
     * 发布商品
     *
     * @param products
     * @return
     */
    @RequestMapping(value = "/ReleaseOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String releaseOrUpdateProducts(@RequestBody Products products){

        try{
            // 判断当前商品有没有id,如果有id,那么就是更新操作
            if (products.getProductId() == null || products.getProductId() == 0) {
                //把商品添加到数据库
                releaseProduceService.addProduct(products);
            } else {

                //编辑商品信息前,处理图片路径
                if(products.getProductUrl() != null && products.getProductUrl() != ""){
                    List<String> urls = Arrays.asList(products.getProductUrl().split(","));

                    for(int i = 0;i < urls.size();i++ ){
                        int isExist = urls.get(i).lastIndexOf("/");
                        if(isExist != -1){
                            urls.set(i,urls.get(i).substring(isExist + 1));
                        }
                    }
                    products.setProductUrl(StringUtils.join(urls,','));
                }
                //更新商品信息
                releaseProduceService.updateProduct(products);
            }

        }catch(Exception e){
            return "error";
        }
        return "OK";
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/upLoadFiles", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFiles(@RequestParam(required=false) MultipartFile file) {

        if (file != null) {
            String filename = file.getOriginalFilename();

            //如果图片名是绝对路径,返回最后一个/ 的索引
            int isExist = filename.lastIndexOf("/");

            //如果图片是完整路径,截取图片名
            if(isExist != -1){
                filename = filename.substring(isExist + 1);
            }

            File picPath = new File(savePicUrl + filename);
            //如果是更新,可能有部分图片已经存在服务器,如果不存在,就保存图片
            if (!picPath.exists()) {
                // 为没有上传过的图片添加随机字符
                filename = UUID.randomUUID().toString().replace("-", "") + "_" + filename;
                //保存图片
                try {
                    FileOutputStream out = new FileOutputStream(new File(savePicUrl + filename));
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return filename;
        }
        //没有选择图片时
        return "error";
    }
}

