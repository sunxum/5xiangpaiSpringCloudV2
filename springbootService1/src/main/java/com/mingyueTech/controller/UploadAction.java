package com.mingyueTech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

@Controller
public class UploadAction {

    @RequestMapping(value = "/uploadImg")
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {

        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        String realpath=path.replaceAll("Back", "Front");
        System.out.println(realpath);
        String fileName = file.getOriginalFilename();
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        String fileNewName = new Date().getTime()+prefix;
        File targetFile = new File(realpath, fileNewName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/upload/"+fileNewName;
    }

}