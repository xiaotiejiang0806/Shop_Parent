package com.qfedu.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 16:06 2019/6/15
 * @ Description：文件上传相关工具类
 */
public class FileUtil {

    /**
     * 创建新的文件夹
     * @param realFile
     * @param desFile
     * @return
     */
    public static File createDir(String realFile,String desFile){
        File dir = new File(realFile,desFile);
        if (!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }

    /**
     * 按月份建文件夹
     * @param realFile
     * @param desFile
     * @return
     */
    public static File createMonthDir(String realFile,String desFile){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String dirName = simpleDateFormat.format(new Date());
        File dir = new File(realFile,desFile);
        if (!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dir, dirName);
        if (!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    /**
     * 按日期建文件夹
     * @param realFile
     * @param desFile
     * @return
     */
    public static File createDayDir(String realFile,String desFile){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = simpleDateFormat.format(new Date());
        File dir = new File(realFile,desFile);
        if (!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dir, dirName);
        if (!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    /**
     *  自动清理三个月以上的文件夹
     * @return
     */
    public static boolean cleanDir(String realFile,String desFile){
        return true;
    }

    /**
     *  重命名文件名
     * @param fileName
     * @return
     */
    public static String reName(String fileName){
        if (fileName.length() > 50){
            fileName = fileName.substring(fileName.length() - 50);
        }

        return System.currentTimeMillis() + UUID.randomUUID().toString().replace(" ","_") + "_" + fileName;
    }

}
