package com.city.api;


import com.city.config.Upload;
import com.city.helper.FileUploadHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 雷楚桥
 * @deprecation 文件上传接口
 * @email leichuqiao@126.com
 * @date 2018-06-17 14:16
 */
@RestController
public class UploadApi {

    /**
     * @deprecation 上传文件
     * @author 雷楚桥
     * @date 2018-06-17 14:16
     */
    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadStep(MultipartFile file) throws IOException {

        Map<String, Object> map = new HashMap<>();

        if (null != file) {
            String localFileName = file.getOriginalFilename();
            String fileName = FileUploadHelper.getRandomString(35) + '.' + localFileName.substring(localFileName.lastIndexOf(".") + 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(System.currentTimeMillis());

            String savePath = Upload.UPLOAD_URL + Upload.IMG_URL + "/" + date;

            //创建保存路径
            File fileDir = new File(savePath);
            if (!fileDir.exists()) {
                fileDir.setWritable(true, false);
                fileDir.mkdirs();
            }
            String path = savePath + "/" + fileName;
            String relativePath = Upload.IMG_URL + "/" + date + "/" + fileName;

            File localFile = new File(path);
            file.transferTo(localFile);

            String src = "http://" + Upload.SERVER_IP + relativePath;
            System.out.println("src:" + src);

            Map<String, Object> data = new HashMap<>();

            data.put("src", src);            //图片url
            map.put("code", 0);
            map.put("msg", "上传成功");        //提示消息
            map.put("data", data);

            return map;
        }
        return null;
    }

}
