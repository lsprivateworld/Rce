package com.xd.rce.controller.function;


import com.alibaba.fastjson.JSONObject;
import com.xd.rce.domain.function.ModelAndParam;
import com.xd.rce.service.function.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * @Description:    java类作用描述
 * @Author:         XiaYiTiao
 * @CreateDate:     2019/3/4 20:26
 * @Bug
 */

@Controller
public class ModelController {
      @Autowired
      private ModelService modelService;
//    @Autowired
//    private ModelRepository modelRepository;
//
//    //创建模型
//    @RequestMapping("/modelCreate")
//    public String picture_list(){return "modelCreate";}
//
    //保存模型
    @PostMapping(value = "/function/saveModelAndParam")
    @ResponseBody
    public String saveModelAndParam(@RequestBody JSONObject jsonObject)  {
        String procName = jsonObject.getString("proc_Name");
        String modelGroup = jsonObject.getString("modelGroup");
        String procElements = jsonObject.getString("proc_Elements");
        String param1form= jsonObject.getString("param1_form");
        String param2form = jsonObject.getString("param2_form");
        String param3form = jsonObject.getString("param3_form");
        String param4form = jsonObject.getString("param4_form");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        ModelAndParam modelAndParam=new ModelAndParam();
        modelAndParam.setMtime(date);
        modelAndParam.setProcName(procName);
        modelAndParam.setParam1form(param1form);
        modelAndParam.setParam2form(param2form);
        modelAndParam.setParam4form(param3form);
        modelAndParam.setParam4form(param4form);
        modelAndParam.setModelGroup(modelGroup);
        modelAndParam.setProcElements(procElements);
        String msg = modelService.saveModel(modelAndParam);
        return msg;
    }


    //打开模型
    @GetMapping(value = "/function/modelView/{id}")
    @ResponseBody
    public ModelAndView modelView(Model model, @PathVariable("id") Integer id){
        ModelAndParam modelAndParam=modelService.openModelById(id);
        model.addAttribute("modelAndParam",modelAndParam);
        return new ModelAndView("function/modelView","modelModel",modelAndParam);
    }
//
//    //修改模型
    @GetMapping(value = "/function/modelModify/{id}")
    @ResponseBody
    public ModelAndView modelModify(Model model, @PathVariable("id") Integer id){
        ModelAndParam modelAndParam = modelService.modifyModelById(id);
        model.addAttribute("modelAndParam",modelAndParam);
        return new ModelAndView("function/modelModify","modelModel",modelAndParam);
    }
//修改模型后的保存
   @PostMapping (value = "/function/updateModelAndParam")
   @ResponseBody
   public String updateModelAndParam(@RequestBody JSONObject jsonObject)  {
        Integer modelid = Integer.valueOf(jsonObject.getString("id"));
       String procName = jsonObject.getString("proc_Name");
       String procElements = jsonObject.getString("proc_Elements");
       String param1form= jsonObject.getString("param1_form");
       String param2form = jsonObject.getString("param2_form");
       String param3form = jsonObject.getString("param3_form");
       String param4form = jsonObject.getString("param4_form");

       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
       ModelAndParam modelAndParam=new ModelAndParam();
       modelAndParam.setId(modelid);
       modelAndParam.setMtime(date);
       modelAndParam.setProcName(procName);
       modelAndParam.setParam1form(param1form);
       modelAndParam.setParam2form(param2form);
       modelAndParam.setParam4form(param3form);
       modelAndParam.setParam4form(param4form);
       modelAndParam.setProcElements(procElements);
       String msg = modelService.updateModel(modelAndParam);
       return msg;
}
    //删除模型
    @GetMapping(value = "/function/modelDelete/{id}")
    @ResponseBody
    public ModelAndView modelDelete(Model model, @PathVariable("id") Integer id){
        modelService.modelDeleteById(id);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/modelList","modelModel",model);
    }

}
