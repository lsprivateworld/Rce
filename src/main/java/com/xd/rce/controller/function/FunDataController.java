package com.xd.rce.controller.function;

import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.mapper.function.FileSearchMapper;
import com.xd.rce.service.FileService;
import com.xd.rce.service.function.FileSearchService;
import com.xd.rce.service.function.FileUploadFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class FunDataController {
    @Autowired
    private FileSearchMapper fileSearchMapper;
    @Autowired
    private FileSearchService fileSearchService ;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileUploadFunService fileUploadFunService;
    @ResponseBody
    @PostMapping("/saveFile")
    public void upFile(@RequestParam("filename") MultipartFile multipartFile, @RequestParam("fileKind") String fileKind,
                       @RequestParam("fileGroup") String fileGroup ,@RequestParam("fileText") String fileText) throws Exception {

        String[] fileInformation = fileService.Upload(multipartFile);
        String fileName = fileInformation[0];
        String filePath = fileInformation[1];
        String fileSize = fileInformation[2];
//      System.out.println(fileName+"----"+ filePath+"----"+fileSize+"----"+fileKind+"----"+ fileGroup);
        FileAndUploadFun fileAndUploadFun = new FileAndUploadFun();
        fileAndUploadFun.setFileName(fileName);
        fileAndUploadFun.setFilePath(filePath);
        fileAndUploadFun.setFileSize(fileSize);
        fileAndUploadFun.setFileGroup(fileGroup);
        fileAndUploadFun.setFileKind(fileKind);
        fileAndUploadFun.setFileText(fileText);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        fileAndUploadFun.setFileTime(date);
        fileUploadFunService.uploadFileFun(fileAndUploadFun);
    }

    //数据回显
    @GetMapping("/dataReviewFun/{id}")
    public String review(@PathVariable("id") Integer id, Map<String, Object> map) {


        FileAndUploadFun fileAndUploadFun = fileSearchService.selectAllfillByid(id);
        String fileName = fileAndUploadFun.getFileName();
        String filePath = fileAndUploadFun.getFilePath();
        String fileTime = fileAndUploadFun.getFileTime();
        map.put("fileName", fileName);
        map.put("filePath", filePath);
        map.put("fileTime",fileTime);
        String fileType = fileName.split("\\.")[1];
        map.put("fileType",fileType);
//        System.out.println(fileName+"-----"+fileType +"-----"+filePath);

        //读取的是csv文件

         List<String> result = fileService.readCsvFile(filePath);
         map.put("result", result);
        int dataLines=result.size();
        map.put("dataLines",dataLines);
        //不管是不是csv格式，都返回页面，如果不是在前端页面再处理
        return "/function/dataReviewFun";
    }

    //数据搜索
    @GetMapping( "/dataSearch")
    public ModelAndView dataSearch(Model model ,@RequestParam("search_text") String search_text){
        //拼接模糊查询的通配符
        String res = "%" +search_text+"%";
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.findByfilenameLike(res);
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        return new ModelAndView("function/dataManage","modelModel",model);
    }

    //数据删除
    @GetMapping("/fileDelete/{id}")
    public ModelAndView fileDelete(@PathVariable("id") Integer id ,Model model){
      //删除服务器记录
        fileSearchService.fileDeleteByid(id);
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        return new ModelAndView("function/dataManage", "modelModel", model);
    }


}
