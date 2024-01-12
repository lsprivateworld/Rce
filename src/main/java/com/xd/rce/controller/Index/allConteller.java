package com.xd.rce.controller.Index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xd.rce.util.HttpClientGet;
import com.xd.rce.util.ReadCsvUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class allConteller {
    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        return new ModelAndView("newProgram", "modelModel", model);
    }

    @RequestMapping("/home")
    public ModelAndView homePage(Model model) {
        return new ModelAndView("home", "modelModel", model);
    }


    @RequestMapping("/welcome")
    public ModelAndView firstpage(Model model) {
        return new ModelAndView("welcome", "modelModel", model);
    }

    @RequestMapping("/welcomeper")
    public ModelAndView welcomeper(Model model) {
        return new ModelAndView("welcomeper", "modelModel", model);
    }

    @RequestMapping("/welcomeview")
    public ModelAndView welcomeview(Model model) {
        return new ModelAndView("welcomeview", "modelModel", model);
    }




    @ResponseBody
    @RequestMapping("/test")
    public JSON HA_dyzz_run(){
        String url="http://192.168.80.31:7004/api/v1/algo/all_code/Cleaning?dataPath=/root/matlab/data/testdatas.csv&savePath=/root/matlab/data/rusult.csv";
        String string = HttpClientGet.restGet(url);
        JSONObject jsonObject= JSON.parseObject(string);
        String path = jsonObject.get("datas").toString();
  /*      String path=datas.split("：")[1];*/
      /*       ReadCsvUtil  readCsvUtil=new ReadCsvUtil(path);*/
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\kairun\\Desktop\\test.csv");
        List<String> read = readCsvUtil.read();

        jsonObject.put("datas",read);
        return jsonObject;
    }






}
