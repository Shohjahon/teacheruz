package com.teacher.uz.my.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Shoh Jahon on 14.04.2018.
 */
public class FileUploadUtility {

    private static final String ABS_PATH = "D:\\Intellij\\Teacher.uz\\MyTeacher.Uz\\src\\main\\webapp\\resources\\images\\thumbnails\\";
    private static String REAL_PATH = "";
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

    public static void uploadFile(HttpServletRequest request, MultipartFile file,String code){
        REAL_PATH = request.getSession().getServletContext().getRealPath("resources\\images\\thumbnails\\");

        logger.info("real: "+REAL_PATH);
        logger.info("absolute: "+ABS_PATH);

        if (!new File(ABS_PATH).exists()){
            new File(ABS_PATH).mkdirs();
        }

        try{
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
