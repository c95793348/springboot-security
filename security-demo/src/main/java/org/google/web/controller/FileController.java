package org.google.web.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.google.dto.FileInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by wbcaoa on 2018/3/27.
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private final String folder = "F:\\application\\google-security\\security-demo\\src\\main\\java\\org\\google\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {

        System.out.println("name : " + file.getName());
        System.out.println("originalFilename : " + file.getOriginalFilename());
        System.out.println("size : " + file.getSize());

        File localFile = new File(folder, new Date().getTime() + ".txt");

        file.transferTo(localFile);

        return new FileInfo(folder);

    }

    @GetMapping("/{id}")
    public void download(@PathVariable(name = "id") String idxxx, HttpServletRequest request,
                         HttpServletResponse response) throws Exception {

        try ( FileInputStream inputStream = new FileInputStream(new File(folder, idxxx + ".txt"));
              OutputStream outputStream = response.getOutputStream()){

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }

}
