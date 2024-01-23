package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    AliOSSUtils aliOSSUtils;

    //本地存储文件
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传：{}, {}, {}", name, age, image);
//        // 获取前端传来的原始文件名
//        String originalFilename = image.getOriginalFilename();
//        // 构造唯一文件名 - uuid(通用唯一识别码)
//        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String filename = UUID.randomUUID().toString() + extName; //uuid + 扩展名
//        // 制定本地存储路径
//        image.transferTo(new File("D:\\JavaLearning\\JavaWeb\\spring-learn\\Files\\" + filename));
//        return Result.success();
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传：{}", image);

        //调用阿里云oss工具类，将上传的文件存入阿里云
        String url = aliOSSUtils.upload(image);
        log.info("文件url：{}", url);

        return Result.success(url);
    }
}
