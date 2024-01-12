package com.xd.rce.controller.perform;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xd.rce.domain.perform.Algorithmper;
import com.xd.rce.domain.perform.AnalyseModelProcess;
import com.xd.rce.service.FileService;
import com.xd.rce.service.perform.FileUploadperServer;
import com.xd.rce.util.ReadCsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/perform")
@Controller
public class AlgorithmListController {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileUploadperServer fileUploadperServer;


    @RequestMapping("/algorithmList")
    public ModelAndView algorithmListProcess(Model model) {
        List<Algorithmper> algorithmList=fileUploadperServer.selectDataDealByid();
        model.addAttribute("algorithmList", algorithmList);
        return new ModelAndView("perform/algorithmList", "Modelmodel", model);
    }



    //跑算法的接口
    @ResponseBody
    @RequestMapping("/analyseRun1")
    public  Map<String,Object> experimentRun1(@RequestBody JSONObject jsonObject){
        Map<String,Object> map = new HashMap();
        String datasName = jsonObject.get("dataVals").toString();
        String algorithmName = jsonObject.get("modelVals").toString();
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/outputx.csv");
        List<String> read = readCsvUtil.read();
        map.put("read",read);
        return map;
    }


    //跑算法的接口
    @ResponseBody
    @RequestMapping("/analyseRun2")
    public Map<String,Object> experimentRun2(@RequestBody JSONObject jsonObject){
        Map<String,Object> map = new HashMap();
        String datasName = jsonObject.get("dataVals").toString();
        String datasNamex = jsonObject.get("dataValsx").toString();
        String algorithmName = jsonObject.get("modelVals").toString();



        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\trh\\Desktop\\recResultData\\output.csv");




        List<String> read = readCsvUtil.read();
        map.put("read",read);
        return map;
    }

    @ResponseBody
    @RequestMapping("/analyseRun4")
    public   List<String>  experimentRun4(@RequestBody JSONObject jsonObject){
        String datasName = jsonObject.get("dataVals").toString();
        String algorithmName = jsonObject.get("modelVals").toString();
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\trh\\Desktop\\recResultData\\outputxx.csv");
        List<String> read = readCsvUtil.read();
        return read;
    }


    //跑算法的接口
    @ResponseBody
    @RequestMapping("/analyseRun5")
    public List<String>  experimentRun5(@RequestBody JSONObject jsonObject){
        Map<String,Object> map = new HashMap();
        String datasName = jsonObject.get("dataVals").toString();
        String algorithmName = jsonObject.get("modelVals").toString();
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\trh\\Desktop\\recResultData\\outputhu.csv");
        List<String> read = readCsvUtil.read();
        return read;
    }



    //跑算法的接口
    @ResponseBody
    @RequestMapping("/analyseRun6")
    public List<String>  experimentRun6(@RequestBody JSONObject jsonObject){
        Map<String,Object> map = new HashMap();
        String datasName = jsonObject.get("dataVals").toString();
        String algorithmName = jsonObject.get("modelVals").toString();
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\trh\\Desktop\\recResultData\\outputxxxx.csv");
        List<String> read = readCsvUtil.read();

        return read;
    }








    @ResponseBody
    @RequestMapping("/ftaAlgorithm")
    public List<String> ftsAlgorithm(){
//        String url="http://192.168.134.22:7004/api/v1/algo/fta/FTA?input_path=/root/matlab/data/rce/input/ftaInputData.csv&output_path=/root/matlab/data/rce/output/FTAresut.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\trh\\Desktop\\FTAresut.csv");
        List<String> read = readCsvUtil.read();
        return read;
    }


    @RequestMapping("/analyzModelList")
    public ModelAndView analyzModelList(Model model){
        List<AnalyseModelProcess> analyseModelList = fileUploadperServer.selectAllModel();
        model.addAttribute("analyseModelList",analyseModelList);
        return new ModelAndView("perform/analyzModelList","Modelmodel",model);
    }


    @ResponseBody
    @RequestMapping("/deleteModel")
    public String deleteModel(@RequestBody JSONObject jsonObject) throws Exception{
        String modelid = jsonObject.get("modelid").toString();
        int id = Integer.parseInt(modelid);
        fileUploadperServer.deleteModelByid(id);
        return modelid;
    }


}
