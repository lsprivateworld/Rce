package com.xd.rce.service;


import com.xd.rce.util.FileUpUtil;
import com.xd.rce.util.ReadCsvUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * @Description:    上传文件返回上传路径
 * @Author:         XiaYiTiao
 * @CreateDate:     2019/3/12 15:36
 * @Bug：尝试参数写活，返回相对路径
 */
@Service
public class FileService {

    public final static String IMG_PATH_PREFIX = "static/data/";

    public String[] Upload(@RequestParam("filename") MultipartFile file) {
        /*
         * 功能描述:上传文件，返回文件多的名称、路径和的大小信息
         * @param: [file]
         * @return: java.lang.String[]
         */

        String[] fileInformation = new String[3];
        if(!file.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file.getOriginalFilename();

            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            //获取项目类加载器下的资源路径
//            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            String path = new String("src/main/resources/"  + IMG_PATH_PREFIX);
//            String path = new String("http://192.168.80.32:7004/tasks/" );
            //String path = LOCAL_UPFILE_PATH;//尝试用参数启动，改为本地路径
            File fileDir = new File(path);
            if(!fileDir.exists()){
                // 递归生成文件夹
                fileDir.mkdirs();
            }
//            System.out.println(path);
//            path = path.substring(1,path.length());
            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
                FileUpUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {

                e.printStackTrace();
            }

            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            // FileAndUpload upSuccessFile = new FileAndUpload();

            //将文件的大小进行数据格式转换，保留两位小数
            String fileSize = String.format("%1.2f",(float)file.getSize()/1024 )+"KB";


            String filePath = path + fileName;
            fileInformation[0] = fileName;
            fileInformation[1] = filePath;
            fileInformation[2] = fileSize;

            //upSuccessFile.setFliePath("http://localhost:8082/"+fileName);//服务器访问路径
            //upSuccessFile.setFliePath(ACCESS_PATH);//尝试用参数启动，改为访问路径
            //fileRepository.save(upSuccessFile);
        }
        return fileInformation;

    }

    public void deleteFile(String filePath){
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            boolean result = file.delete();
            if (!result) {
                System.gc();
                file.delete();
            }
        }
    }


    //读数据进入数据库
    public void csvToDatabase(){

    }

    //读取csv文件
    public List<String> readCsvFile(String filePath){
        ReadCsvUtil readCsvUtil = new ReadCsvUtil(filePath);
        List<String> result =readCsvUtil.read();
        return result;
    }

}

