package com.zhuhai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/4/3
 * Time: 23:09
 *
 * @author: hai
 */
@Controller
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @GetMapping()
    public String uploadIndex() {
        return "upload";
    }

    @PostMapping(value = "/upload1")
    public String upload1(@RequestParam("file") MultipartFile file) throws IOException {

        log.info("file name is:{}", file.getOriginalFilename());
        log.info("file size is:{}", file.getSize());
        log.info("file type is:{}", file.getContentType());
        String path = "D:/upload/img";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File uploadFile = new File(dir,file.getOriginalFilename());
        file.transferTo(uploadFile);
        return "upload";
    }

}
