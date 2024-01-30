package com.zp.controller;

import com.zp.component.MinioComp;
import com.zp.config.MinioConfiguration;
import com.zp.domain.R;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private MinioComp minioComp;

    @Autowired
    private MinioConfiguration minioConfig;

    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file,
                    @RequestParam("fileName") String fileName) {
        minioComp.upload(file, fileName);
        String url = minioComp.getUrl(fileName, 7, TimeUnit.DAYS);
        return R.success(url);
    }

    @GetMapping("/policy")
    public R policy(@RequestParam("fileName") String fileName) {
        Map policy = minioComp.getPolicy(fileName, ZonedDateTime.now().plusMinutes(10));
        return R.success(policy);
    }

    @GetMapping("/uploadUrl")
    public R uploadUrl(@RequestParam("fileName") String fileName) {
        String url = minioComp.getPolicyUrl(fileName, Method.PUT, 2, TimeUnit.MINUTES);
        return R.success(url);
    }

    @GetMapping("/url")
    public R getUrl(@RequestParam("fileName") String fileName) {
        String url = minioComp.getUrl(fileName, 7, TimeUnit.DAYS);
        return R.success(url);
    }

    /**
     * 文件上传
     *
     * @param file
     */
    @PostMapping("/upload2")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            // 文件名
            String fileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
            // 类型
            String contentType = file.getContentType();
            minioComp.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传失败");
            return "上传失败";
        }
    }

    /**
     * 删除
     *
     * @param fileName
     */
    @DeleteMapping("/delete")
    public void delete(@RequestParam("fileName") String fileName) {
        minioComp.removeFile(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件信息
     *
     * @param fileName
     * @return
     */
    @GetMapping("/info")
    public R getFileStatusInfo(@RequestParam("fileName") String fileName) {
        return R.success(minioComp.getFileStatusInfo(minioConfig.getBucketName(), fileName));
    }

    /**
     * 获取文件外链
     *
     * @param fileName
     * @return
     */
    @GetMapping("/url2")
    public String getPresignedObjectUrl(@RequestParam("fileName") String fileName) {
        return minioComp.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param response
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        try {
            InputStream fileInputStream = minioComp.getObject(minioConfig.getBucketName(), fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载失败");
        }
    }


}
