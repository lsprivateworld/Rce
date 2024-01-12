package com.xd.rce.controller.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xd.rce.util.HttpClientGet;
import com.xd.rce.util.ReadCsvUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/function")
@Controller
public class AlgorithmController {
    @ResponseBody
    @RequestMapping("/ftaAlgorithm")
    public List<String> ftsAlgorithm(@RequestBody JSONObject jsonObjectFile){

//       String inputFileName=jsonObjectFile.get("inputFileName").toString();
//        String url="http://192.168.59.22:7004/api/v1/algo/fta/FTA?input_path=/root/matlab/data/rce/input/"+inputFileName+"&output_path=/root/matlab/data/rce/output/FTAresult_wmsx.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
//        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\FTAresult_wmsx.csv");
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/FTAresult_wmsx.csv");


        List<String> read = readCsvUtil.read();

        return read;

    }
    @ResponseBody
    @RequestMapping("/ftaAlgorithm1")
    public List<String> ftsAlgorithm1(@RequestBody JSONObject jsonObjectFile){
//        String inputFileName=jsonObjectFile.get("inputFileName").toString();
//        String url="http://192.168.59.22:7004/api/v1/algo/fta/FTA?input_path=/root/matlab/data/rce/input/"+inputFileName+"&output_path=/root/matlab/data/rce/output/FTAresult_dyzz.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
//        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\FTAresult_dyzz.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/FTAresult_dyzz.csv");
        List<String> read = readCsvUtil.read();
        return read;

    }
    @ResponseBody
    @RequestMapping("/ftaAlgorithm2")
    public List<String> ftsAlgorithm2(@RequestBody JSONObject jsonObjectFile){
//        String inputFileName=jsonObjectFile.get("inputFileName").toString();
//        String url="http://192.168.59.22:7004/api/v1/algo/fta/FTA?input_path=/root/matlab/data/rce/input/"+inputFileName+"&output_path=/root/matlab/data/rce/output/FTAresult_zkcy.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
//        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
//        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\FTAresult_zkcy.csv");
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/FTAresult_zkcy.csv");
        List<String> read = readCsvUtil.read();
        return read;

    }

    @ResponseBody
    @RequestMapping("/MTFBAlgorithm")
    public List<String> MTFBAlgorithm(@RequestBody JSONObject jsonObjectFile){
//        String inputFileName=jsonObjectFile.get("inputFileName").toString();
//       String url="http://192.168.59.22:7004/api/v1/algo/MCMC/MTBF?input_path=/root/matlab/data/rce/input/"+inputFileName+"&output_path=/root/matlab/data/rce/output/mtbfresult_wmsx.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
//        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\mtbfresult_wmsx.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/mtbfresult_wmsx.csv");
        List<String> read = readCsvUtil.read();
        return read;
    }

    @ResponseBody
    @RequestMapping("/MTFBAlgorithm1")
    public List<String> MTFBAlgorithm1(@RequestBody JSONObject jsonObjectFile){
//       String inputFileName=jsonObjectFile.get("inputFileName").toString();
//       String url="http://192.168.59.22:7004/api/v1/algo/MCMC/MTBF?input_path=/root/matlab/data/rce/input/"+inputFileName+"&output_path=/root/matlab/data/rce/output/mtbfresult_dyzz.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
       // ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\mtbfresult_dyzz.csv");
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/mtbfresult_dyzz.csv");
        List<String> read = readCsvUtil.read();
        return read;
    }
    @ResponseBody
    @RequestMapping("/MTFBAlgorithm2")
    public List<String> MTFBAlgorithm2(@RequestBody JSONObject jsonObjectFile){
//    String inputFileName=jsonObjectFile.get("inputFileName").toString();
//       String url="http://192.168.59.22:7004/api/v1/algo/MCMC/MTBF?input_path=/root/matlab/data/rce/input/"+inputFileName+"&output_path=/root/matlab/data/rce/output/mtbfresult_zkcy.csv";
//        String string = HttpClientGet.restGet(url);
//        JSONObject jsonObject= JSON.parseObject(string);
//        String datas = jsonObject.get("datas").toString();
//        String path=datas.split("：")[1];
//        /*     ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
//        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\mtbfresult_zkcy.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/mtbfresult_zkcy.csv");
        List<String> read = readCsvUtil.read();
        return read;
    }

    @GetMapping("/dataReviewFun")
    public  Map<String, Object> review( Map<String, Object> map) {
            String filePath="C:\\Users\\fcbfd\\Desktop\\mtbfresult.csv";
            ReadCsvUtil readCsvUtil=new ReadCsvUtil(filePath);
            List<String> result = readCsvUtil.read();
            map.put("result", result);
            System.out.println(result.toString());
            return map;
//        return "/function/wmsx";
    }
//
    @ResponseBody
    @RequestMapping("/ftaAlgorithmCsv")
    public  List<String> reviewFTA( ) {
        String filePath="C:\\Users\\fcbfd\\Desktop\\FTAresut.csv";
        ReadCsvUtil readCsvUtil=new ReadCsvUtil(filePath);
        List<String> result = readCsvUtil.read();
        return result;
    }
}
