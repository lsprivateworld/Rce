package com.xd.rce.controller.perform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xd.rce.domain.perform.Algorithmper;
import com.xd.rce.domain.perform.AnalyseModelProcess;
import com.xd.rce.domain.perform.FileAndUploadper;
import com.xd.rce.service.FileService;
import com.xd.rce.service.perform.AlgorithmUpdateService;
import com.xd.rce.service.perform.FileUploadperServer;
import com.xd.rce.util.HttpClientGet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@RequestMapping("/perform")
@Controller
public class FileerController {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileUploadperServer fileUploadperServer;

    @Autowired
    private AlgorithmUpdateService algorithmUpdateService;



    //搜索数据
    @GetMapping(value = "/dataSearch")
    public ModelAndView dataSearch(Model model, @RequestParam("search_text") String search_text) {
        //拼接模糊查询的通配符
        String res = "%" + search_text + "%";
//        System.out.println(res);
        //返回查到的list

        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.moHuDataSource(res);


        model.addAttribute("fileAndUploadList",fileAndUploadperList);



        return new ModelAndView("perform/dataManageper", "modelModel", model);
    }

    @GetMapping(value = "/algorithmSearch")
    public ModelAndView algorithmSearch(Model model, @RequestParam("search_text") String search_text) {
        //拼接模糊查询的通配符
        String res = "%" + search_text + "%";
//        System.out.println(res);
        //返回查到的list

        List<Algorithmper> algorithmList = fileUploadperServer.algorithmSearchSource(res);


        model.addAttribute("algorithmList", algorithmList);
        return new ModelAndView("perform/algorithmList", "Modelmodel", model);
    }






    @GetMapping("/dataReviewper/{id}")
    public String review(@PathVariable("id") Integer id, Map<String, Object> map) {
        FileAndUploadper fileAndUploadper = fileUploadperServer.selectAllfillByid(id);
        String fileName = fileAndUploadper.getFileName();
        String filePath = fileAndUploadper.getFilePath();
        String fileTime = fileAndUploadper.getFileTime();
        map.put("fileName", fileName);
        map.put("filePath", filePath);
        map.put("fileTime",fileTime);
   /*     String fileType = fileName.split("\\.")[1];*/
        String fileType = "csv";
        map.put("fileType",fileType);

        //确认要读取的是csv文件
        if(fileType.equals("csv")) {
            List<String> result = fileService.readCsvFile(filePath);
            map.put("result", result);
        }
        //不管是不是csv格式，都返回页面，如果不是在前端页面再处理
        return "perform/dataReviewper";
    }




    @RequestMapping("/fileDelete/{id}")
    public ModelAndView deleteProcessId(Model model,@PathVariable("id") int id) {
        fileUploadperServer.deletFileByid(id);
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        model.addAttribute("fileAndUploadList",fileAndUploadperList);
        return new ModelAndView("perform/dataManageper","modelModel",model);
    }

    @ResponseBody
    @RequestMapping("/experimentRun")
    public Map<String,Object>  experimentRun(@RequestBody JSONObject jsonObject){
        Map map = new HashMap();
        String Aalname = jsonObject.get("namex").toString();
        String idx = jsonObject.getString("id").toString();
        int id = Integer.parseInt(idx);


        //输入文件名
        FileAndUploadper fileAndUploadpergrop = fileUploadperServer.selectAllfillByid(id);
        String inputfile = fileAndUploadpergrop.getFileName();
        String fileGroup = fileAndUploadpergrop.getFileGroup();
        String fileKind = fileAndUploadpergrop.getFileKind();

        //算法名
        String algId = jsonObject.getString("idx").toString();
        int algorithmid = Integer.parseInt(algId);
        Algorithmper algorithmper = fileUploadperServer.selectalgorithByid(algorithmid);
        String[] str = algorithmper.getAlgorithmpath().split("/");
        String Aalgorithmname = str[str.length-1].split(".py")[0];


        //输出文件名
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        String suffix = date.split(" ")[0].split("-")[1]+""+date.split(" ")[0].split("-")[2];
        String inputNames = inputfile.split(".csv")[0];
        String outfile = inputNames+"Result"+suffix;
        String outfileName = outfile+".csv";


//        String url="http://192.168.13.32:7004/api/v1/algo/all_code/ZzzsCleaning?dataPath=/root/matlab/data/zg/sources/data.csv&savePath=/root/matlab/data/zg/target/Cleaning.csv";

//        String url="http://192.168.13.32:7004/api/v1/algo/all_code/"+Aalgorithmname+"?dataPath=/root/matlab/data/zg/sources/"+inputfile+"&savePath=/root/matlab/data/zg/target/"+outfile+".csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObjectx= JSON.parseObject(string);
//        String datas = jsonObjectx.get("datas").toString();
        //这边后期改成服务器的路径
//        String filePath ="src/main/resources/static/data/"+ outfile+".csv";
        String filePath ="src/main/resources/static/data/"+ inputfile;

        String fileSize = "已处理";

        FileAndUploadper fileAndUploadper = new FileAndUploadper();
        fileAndUploadper.setFileName(outfileName);
        fileAndUploadper.setFilePath(filePath);
        fileAndUploadper.setFileSize(fileSize);
        fileAndUploadper.setFileGroup(fileGroup);
        fileAndUploadper.setFileKind(fileKind);
        fileAndUploadper.setFileTime(date);
        fileUploadperServer.uploadFileper(fileAndUploadper);
        map.put("code",1);
        return map;
    }


    @RequestMapping("/algorithmView/{id}")
    public ModelAndView algorithmView(Model model, @PathVariable("id") Integer algorithmid) throws IOException {
        Algorithmper algorithmper = fileUploadperServer.selectalgorithByid(algorithmid);
        model.addAttribute("algorithm", algorithmper);
        String algorithmpath = algorithmper.getAlgorithmpath();
        BufferedReader bfr = new BufferedReader(new FileReader(algorithmpath));
        String str = null;
        int lineNumber = 0;
        while ((str = bfr.readLine()) != null) {
            lineNumber++;
        }
        List<String> algorithmStringList = new ArrayList<>();
        BufferedReader bfr1 = new BufferedReader(new FileReader(algorithmpath));
        String str1 = null;
        int lineNumber1 = 0;
        while ((str1 = bfr1.readLine()) != null) {
            algorithmStringList.add(String.valueOf(lineNumber1) + " " + str1);
            lineNumber1++;
        }
        bfr.close();
        bfr1.close();

        String algorithmJsonString = JSON.toJSONString(algorithmStringList);
        model.addAttribute("algorithmJsonString", algorithmJsonString);
        return new ModelAndView("perform/algorithmView", "Modelmodel", model);
    }


    @ResponseBody
    @PostMapping("/updateAlgorithm")
    public Map<String, Object> upFile(@RequestParam(value = "filename", required = false) MultipartFile multipartFile, Algorithmper algorithm) throws Exception {
        Map map = new HashMap();

//        String miaoshu =algorithm.getAlgorithmmiaoshu();
//        System.out.printf(miaoshu);
        String[] fileInformation = algorithmUpdateService.Upload(multipartFile);

        if (fileInformation != null) {
            String filename = fileInformation[0];
            String[] fileName = filename.split("\\.");
//        String algorithmName = fileName[0];
            // String filepath = fileInformation[1];
            String filesize = fileInformation[2];
//        System.out.println(filename+"----"+ filepath+"----"+filesize);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = simpleDateFormat.format(new Date());
            Algorithmper algorithm1 = new Algorithmper();
        String algorithmname=algorithm.getAlgorithmname();
        String algorithmtype=algorithm.getAlgorithmtype();
        String algorithmdescribe=algorithm.getAlgorithmdescribe();
        String algorithmlabel=algorithm.getAlgorithmlabel();
        String algorithmtime=simpleDateFormat.format(new Date());
        String algorithmversion=algorithm.getAlgorithmversion();
        String algorithmpath=fileInformation[1];
        String algorithmman="xidian";
            algorithm1.setAlgorithmname(algorithmname);
            algorithm1.setAlgorithmtype(algorithm.getAlgorithmtype());
            algorithm1.setAlgorithmdescribe(algorithm.getAlgorithmdescribe());
            algorithm1.setAlgorithmlabel(algorithm.getAlgorithmlabel());
            algorithm1.setAlgorithmtime(simpleDateFormat.format(new Date()));
            algorithm1.setAlgorithmversion(algorithm.getAlgorithmversion());
            algorithm1.setAlgorithmparamsinput(algorithm.getAlgorithmparamsinput());
            algorithm1.setAlgorithmparamscontent(algorithm.getAlgorithmparamscontent());
            algorithm1.setAlgorithmparamsoutput(algorithm.getAlgorithmparamsoutput());
            algorithm1.setAlgorithmpath(fileInformation[1]);
            algorithm1.setAlgorithmman("xidian");
            algorithm1.setAlgorithmmiaoshu(algorithm.getAlgorithmmiaoshu());
        fileUploadperServer.saveAlgorithm(algorithm1);
            map.put("code", 0);
        } else {
            map.put("code", 1);
        }
        return map;
    }


    @RequestMapping("/deleteAlgorithm/{id}")
    public ModelAndView deleteAlgorithm(Model model,@PathVariable("id") Integer algorithmid) {

          Algorithmper algorithm = fileUploadperServer.selectalgorithByid(algorithmid);

        if (algorithm.getAlgorithmpath() != null) {
            File file = new File(algorithm.getAlgorithmpath());
            file.delete();
            //清除进程
            boolean result = file.delete();
            if (!result) {
                System.gc();
                file.delete();
            }
        }
        fileUploadperServer.deleteAlgorithm(algorithmid);
        List<Algorithmper> algorithmList=fileUploadperServer.selectDataDealByid();
         model.addAttribute("algorithmList", algorithmList);
        return new ModelAndView("perform/algorithmList", "Modelmodel", model);

    }



    @RequestMapping("/analyzmodelku/{id}")
    public ModelAndView analyzmodelku(Model model,@PathVariable("id") Integer id) {
        AnalyseModelProcess analyseModelProcess = fileUploadperServer.selectAllModelByid(id);

        String modelProcess = analyseModelProcess.getModelprocess();

        model.addAttribute("id",id);

        model.addAttribute("modelProcess",modelProcess);

        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        model.addAttribute("algorithmList",algorithmpers);


        return new ModelAndView("perform/analyzModelView", "Modelmodel", model);

    }








}
