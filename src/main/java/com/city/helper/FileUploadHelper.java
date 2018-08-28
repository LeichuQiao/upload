package com.city.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * @author 雷楚桥
 * @deprecation 文件上传类
 * @email leichuqiao@126.com
 * @date 2018-06-17 14:23
 */
public class FileUploadHelper {

    /**
     * @deprecation 上传文件
     * @author 雷楚桥
     * @date 2018-06-17 14:23
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * @param length Integer 随机字符串长度
     * @return 随机后的字符串
     * @deprecation 得到随机字符串
     * @author 雷楚桥
     * @date 2018-06-17 16:15
     */
    public static String getRandomString(int length) {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
