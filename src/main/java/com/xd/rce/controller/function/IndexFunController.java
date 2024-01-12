package com.xd.rce.controller.function;

import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.domain.function.ModelAndParam;
import com.xd.rce.service.function.FileSearchService;
import com.xd.rce.service.function.FileUploadFunService;
import com.xd.rce.service.function.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/function")
@Controller
public class IndexFunController {
    @Autowired
    private FileSearchService fileSearchService;
    @Autowired
    private ModelService modelService;

    @Autowired
    private FileUploadFunService fileUploadFunService;

    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        return new ModelAndView("function/index", "modelModel", model);
    }

    @RequestMapping("/dyzz")
    public ModelAndView dyzz(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/dyzz", "modelModel", model);
    }

    @RequestMapping("/wmsx")
    public ModelAndView wmsx(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/wmsx", "modelModel", model);
    }

    @RequestMapping("/zkcy")
    public ModelAndView zkcy(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/zkcy", "modelModel", model);
    }

    @RequestMapping("/MTFBdyzz")
    public ModelAndView MTFBdyzz(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/MTFBdyzz", "modelModel", model);
    }

    @RequestMapping("/MTFBwmsx")
    public ModelAndView MTFBwmsx(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/MTFBwmsx", "modelModel", model);
    }

    @RequestMapping("/MTFBzkcy")
    public ModelAndView MTFBzkcy(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/MTFBzkcy", "modelModel", model);
    }


    @RequestMapping("/upFile")
    public ModelAndView upFile(Model model) {
        return new ModelAndView("function/upFile", "modelModel", model);
    }

    @RequestMapping("/dataManage")
    public ModelAndView dataManage(Model model) {
        List<FileAndUploadFun> fileAndUploadFunList = fileSearchService.fileSearch();
        model.addAttribute("fileAndUploadFunList",fileAndUploadFunList);
        return new ModelAndView("function/dataManage", "modelModel", model);
    }
    @RequestMapping("/modelManage")
    public ModelAndView modelManage(Model model) {
        return new ModelAndView("function/modelManage", "modelModel", model);
    }

    @GetMapping(value = "/modelList")
    @ResponseBody
    public ModelAndView modelList(Model model){
        List<ModelAndParam> modelAndParamList=modelService.showModelList();
        model.addAttribute("modelAndParamList",modelAndParamList);
        return new ModelAndView("function/modelList","modelModel",model);
    }

}


