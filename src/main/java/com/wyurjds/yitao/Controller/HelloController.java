package com.wyurjds.yitao.Controller;

import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Entity.Users;
import com.wyurjds.yitao.Mapper.UserMapper;
import com.wyurjds.yitao.Service.ReleaseProduceService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin
@RequestMapping("/hello")
public class HelloController {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private ReleaseProduceService releaseProduceService;
//
//    @Value("${SAVE_PIC_URL}")
//    private String savePicUrl;
//
//    @Value("${GET_PIC_URL}")
//    private String getPicUrl;
//
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String hello(@RequestParam("file") MultipartFile file, Products products) throws SQLException {
//                // 保存图片操作
//                List<String> urlList = new ArrayList<>();
//                String filename = file.getOriginalFilename();
//                File picPath = new File(savePicUrl + filename);
//                //如果是更新,可能有部分图片已经存在服务器,如果不存在,就保存图片
//                if (!picPath.exists()){
//                    // 为没有上传过的图片添加随机字符
//                    filename = UUID.randomUUID().toString().replace("-", "") + "_" + filename;
//                    //保存图片
//                    try {
//                        FileOutputStream out = new FileOutputStream(new File(savePicUrl + filename));
//                        out.write(file.getBytes());
//                        out.flush();
//                        out.close();
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                /*// 保存每一张图片的路径
//                urlList.add(filename);
//                // 把list数组转字符串
//                String urlStrs = StringUtils.join(urlList, ',');*/
//                products.setProductUrl(filename);
//
//        // 判断当前商品有没有id,如果有id,那么就是更新操作
//        if(products.getProductId() == null || products.getProductId() == 0){
//            //把商品添加到数据库
//            releaseProduceService.addProduct(products);
//        }else{
//            //更新商品信息
//            releaseProduceService.updateProduct(products);
//        }
//        return "OK";
//            }

}
