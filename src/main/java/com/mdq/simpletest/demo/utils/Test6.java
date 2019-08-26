package com.mdq.simpletest.demo.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Test6 {


    public static void main(String[] args) {

        //图片
        String path = "D:\\downloads\\mater.jpg";
        String base64 = base64(path);
        System.out.println("经过base64转码和压缩" + base64);
        //解压重新生成文件 base64解码 ，gizp解压
        byte[] data = gzipTobase64(base64);
        //解压后文件进行Base64加密（存入数据库）
        byte[] b = Base64.encodeBase64(data);
        //数据库获取到的
        //加密后文件进行图片查看进行base64 解码
        byte[] a = Base64.decodeBase64(b);
        writeFile(a,"test2.jpg","D:\\");
    }

    /**
     * 二进制文件写入文件
     * @param data 二进制数据
     * @param fileName 文件名
     * @param path 路径地址
     */
    public static void writeFile(byte[] data, String fileName, String path) {
        try
        {
            String url = path + "//" + fileName;
            FileUtils.writeByteArrayToFile(new File(url), data);
        }
        catch (IOException e)
        {
            System.out.println("写文件出错" + e);
        }
    }
    /**
     * 读取文件并压缩数据然后转Base64编码
     * @param pathName 图片的绝对路径地址
     * @return
     */
    public static String base64(String pathName) {
        byte[] data = getPicData(pathName);
        if (data == null) {
            return null;
        }
        byte[] zipData = gZip(data);
        return Base64.encodeBase64String(zipData);
    }

    /**
     * @description 获取图片的二进制数据
     * @param pathName 图片的绝对路径地址
     * @return
     */
    public static byte[] getPicData(String pathName) {
        byte[] data = null;
        try {
            FileInputStream fi = new FileInputStream(pathName);
            int length = fi.available();
            data = new byte[length];
            fi.read(data);
            fi.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    /***
     * @description 压缩GZip
     * @param data 要压缩的二进制数据
     * @return
     */
    public static byte[] gZip(byte[] data) {
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
    }

    /**
     * GZIP解码解压
     * @param file_info
     * @return
     */
    public static byte[] gzipTobase64(String file_info) {
        byte[] b =null;
        try {
            byte[]   data = Base64.decodeBase64(file_info);
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            byte[] buf = new byte[1024];
            int num = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((num = gzip.read(buf, 0, buf.length)) != -1)
            {
                baos.write(buf, 0, num);
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return b;
    }

    private static byte[] jieya(String base64){
        byte[] b = null;
        try{
           byte[] data =  Base64.decodeBase64(base64);
           ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
           GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
           byte[] buff = new byte[1024];
           int num = -1;
           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while((num = gzipInputStream.read(buff,0,buff.length)) !=-1){
                byteArrayOutputStream.write(buff,0,num);
            }
            b = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;

    }
}
