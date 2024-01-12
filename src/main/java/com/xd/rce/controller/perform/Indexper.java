package com.xd.rce.controller.perform;
import com.alibaba.fastjson.JSONObject;
import com.xd.rce.domain.perform.Algorithmper;
import com.xd.rce.domain.perform.FileAndUploadper;
import com.xd.rce.service.FileService;
import com.xd.rce.service.perform.FileUploadperServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;


@RequestMapping("/perform")

@Controller

public class Indexper {
    @Autowired
    private FileService fileService;
    @Autowired
    private FileUploadperServer fileUploadperServer;



    @GetMapping("/datasDealper")
    public ModelAndView datasDealper(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
//        model.addAttribute("algorithmpers",algorithmpers);
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            if ("源数据".equals(type)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }

        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);

        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("预处理".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }

        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/datasDealper","modelModel",model);
    }


    @RequestMapping("/index")
    public ModelAndView index(Model model) {
        return new ModelAndView("perform/indexper", "modelModel", model);
    }
    @GetMapping("/upFileper")
    public String upFile(){
        return "perform/upFileper";
    }

    @GetMapping("/degenerationper")
    public ModelAndView degenerationper(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();
        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();
            if ("已处理".equals(type) && "隐马尔可夫".equals(role)  && "无模砂型加工中心".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("隐马尔可夫".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);


        return new ModelAndView("perform/degenerationper","modelModel",model);
    }




    @GetMapping("/degenerationper2")
    public ModelAndView degenerationper2(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();
        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();
            if ("已处理".equals(type) && "隐马尔可夫".equals(role)  && "数字化低压铸造装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("隐马尔可夫".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);


        return new ModelAndView("perform/degenerationper2x","modelModel",model);
    }



    @GetMapping("/degenerationper3")
    public ModelAndView degenerationper3(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();
        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();
            if ("已处理".equals(type) && "隐马尔可夫".equals(role)  && "数字化真空差压装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("隐马尔可夫".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);


        return new ModelAndView("perform/degenerationper3x","modelModel",model);
    }







    @RequestMapping("/reliability")
    public ModelAndView reliability(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();
            if ("已处理".equals(type) && "堆栈式编码".equals(role)  && "无模砂型加工中心".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("堆栈式编码器".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/reliability","model",model);
    }



    @RequestMapping("/reliability2")
    public ModelAndView reliability2(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();
            if ("已处理".equals(type) && "堆栈式编码".equals(role)  && "数字化低压铸造装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("堆栈式编码器".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/reliability2","model",model);
    }



    @RequestMapping("/reliability3")
    public ModelAndView reliability3(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();
            if ("已处理".equals(type) && "堆栈式编码".equals(role)  && "数字化真空差压装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("堆栈式编码器".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/reliability3","model",model);
    }


    @RequestMapping("/reliability4")
    public ModelAndView reliability4(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "退化等级分析".equals(role)  && "无模砂型加工中心".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }


        model.addAttribute("fileAndUploadperList1",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("退化等级分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/degenerationper41","model",model);
    }


    @RequestMapping("/reliability14")
    public ModelAndView reliability14(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "退化等级分析".equals(role)  && "数字化低压铸造装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList1",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("退化等级分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/degenerationper41x","model",model);
    }



    @RequestMapping("/reliability24")
    public ModelAndView reliability24(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "退化等级分析".equals(role)  && "数字化真空差压装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList1",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("退化等级分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/degenerationper41xx","model",model);
    }


    @RequestMapping("/reliability5")
    public ModelAndView reliability5(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "多状态序列分析".equals(role)  && "无模砂型加工中心".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("多状态序列分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/reliability5","model",model);
    }


    @RequestMapping("/reliability51")
    public ModelAndView reliability51(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "多状态序列分析".equals(role)  && "数字化低压铸造装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("多状态序列分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/reliability511","model",model);
    }


    @RequestMapping("/reliability52")
    public ModelAndView reliability52(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "多状态序列分析".equals(role)  && "数字化真空差压装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("多状态序列分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/reliability522","model",model);
    }



    @RequestMapping("/reliability6")
    public ModelAndView reliability6(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "多态渐变分析".equals(role)  && "无模砂型加工中心".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList1",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("多态渐变分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/degenerationper6","model",model);
    }

    @RequestMapping("/reliability61")
    public ModelAndView reliability61(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "多态渐变分析".equals(role)  && "数字化低压铸造装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList1",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("多态渐变分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/degenerationper61","model",model);
    }

    @RequestMapping("/reliability62")
    public ModelAndView reliability62(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        List<FileAndUploadper> fileAndUploadperList1 = new ArrayList<>();

        for (int i = 0 ; i < fileAndUploadperList.size(); i++){
            String type = fileAndUploadperList.get(i).getFileSize();
            String role = fileAndUploadperList.get(i).getFileKind();
            String group = fileAndUploadperList.get(i).getFileGroup();

            //无模砂型加工中心 数字化低压铸造装备  数字化真空差压装备
            if ("已处理".equals(type) && "多态渐变分析".equals(role)  && "数字化真空差压装备".equals(group)){
                int j = 0;
                fileAndUploadperList1.add(j,fileAndUploadperList.get(i));
                j++;
            }
        }
        model.addAttribute("fileAndUploadperList1",fileAndUploadperList1);


        List<Algorithmper> algorithmList1 = new ArrayList<>();
        for (int i = 0 ; i < algorithmpers.size(); i++){
            String type = algorithmpers.get(i).getAlgorithmtype();
            if ("多态渐变分析".equals(type)){
                int j = 0;
                algorithmList1.add(j,algorithmpers.get(i));
                j++;
            }
        }
        model.addAttribute("algorithmList",algorithmList1);

        return new ModelAndView("perform/degenerationper62","model",model);
    }



    @RequestMapping("/analyzModelCreate")
    public ModelAndView analyzModelCreate(Model model){
        List<Algorithmper> algorithmpers =  fileUploadperServer.selectDataDealByid();
        model.addAttribute("algorithmList",algorithmpers);
        return new ModelAndView("perform/analyzModelCreate","Modelmoddel",model);
    }







    @GetMapping(value = "/dataManageper")
    public ModelAndView dataManageper(Model model){
        List<FileAndUploadper> fileAndUploadperList = fileUploadperServer.findAllFile();
        model.addAttribute("fileAndUploadList",fileAndUploadperList);
        return new ModelAndView("perform/dataManageper","modelModel",model);
    }


    @ResponseBody
    @PostMapping("/saveFile")
    public void upFile(@RequestParam("filename") MultipartFile multipartFile, @RequestParam("fileKind") String fileKind,
                       @RequestParam("fileGroup") String fileGroup) throws Exception {

        String[] fileInformation = fileService.Upload(multipartFile);
        String fileName = fileInformation[0];
        String filePath = fileInformation[1];
//        String fileSize = fileInformation[2];
        String fileSize = "源数据";
//        System.out.println(fileName+"----"+ filePath+"----"+fileSize+"----"+fileKind+"----"+ fileGroup);
        FileAndUploadper fileAndUploadper = new FileAndUploadper();
        fileAndUploadper.setFileName(fileName);
        fileAndUploadper.setFilePath(filePath);
        fileAndUploadper.setFileSize(fileSize);
        fileAndUploadper.setFileGroup(fileGroup);
        fileAndUploadper.setFileKind(fileKind);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        fileAndUploadper.setFileTime(date);
        fileUploadperServer.uploadFileper(fileAndUploadper);
    }


    @ResponseBody
    @RequestMapping("/saveAnalyse")
    public Map<String,Object> saveAnalyse(@RequestBody JSONObject jsonObject) {
        Map map = new HashMap();
        String modelname = jsonObject.get("modelname").toString();
        String modelprocess = jsonObject.get("modelprocess").toString();
        fileUploadperServer.insertAnalyseModel(modelname,modelprocess);
        map.put("code",1);
        return map;
    }

}
