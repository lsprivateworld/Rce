package com.xd.rce.controller.Index;

import com.xd.rce.util.ReadCsvUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/viewer")
@Controller
public class viewModelController {
    @RequestMapping("/viewerDeal")
    public ModelAndView index(Model model) {
        return new ModelAndView("/viewer/viewShow", "modelModel", model);
    }


    @RequestMapping("/indexview")
    public ModelAndView indexview(Model model) {
        System.out.println("xx");
        return new ModelAndView("viewer/indexview", "modelModel", model);
    }


    @RequestMapping("/f_wmsx")
    public ModelAndView f_wmsx( Model model) {
        //ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\FTAresult_wmsx.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/FTAresult_wmsx.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result",result);
        return new ModelAndView("viewer/f_wmsx", "modelModel", model);
    }
    @RequestMapping("/f_dyzz")
    public ModelAndView f_dyzz(Model model) {
       // ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\FTAresult_dyzz.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/FTAresult_dyzz.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result",result);
        return new ModelAndView("viewer/f_dyzz", "modelModel", model);
    }
    @RequestMapping("/f_zkcy")
    public ModelAndView f_zkcy(Model model) {
       // ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\FTAresult_zkcy.csv");
        ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/FTAresult_zkcy.csv");

        List<String> result = readCsvUtil.read();
        model.addAttribute("result",result);
        return new ModelAndView("viewer/f_zkcy", "modelModel", model);
    }
    @RequestMapping("/f_MTBFwmsx")
    public ModelAndView f_MTBFwmsx(Model model) {
        //ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\mtbfresult_wmsx.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/mtbfresult_wmsx.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result",result);
        return new ModelAndView("viewer/f_MTBFwmsx", "modelModel", model);
    }

    @RequestMapping("/f_MTBFdyzz")
    public ModelAndView f_MTBFdyzz(Model model) {
        //ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\mtbfresult_wmsx.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/mtbfresult_wmsx.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result",result);
        return new ModelAndView("viewer/f_MTBFdyzz", "modelModel", model);
    }
    @RequestMapping("/f_MTBFzkcy")
    public ModelAndView f_MTBFzkcy(Model model) {
        //ReadCsvUtil readCsvUtil=new ReadCsvUtil("C:\\Users\\fcbfd\\Desktop\\recResult\\mtbfresult_dyzz.csv");
         ReadCsvUtil readCsvUtil=new ReadCsvUtil("/root/408/rce/output/mtbfresult_dyzz.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result",result);
        return new ModelAndView("viewer/f_MTBFzkcy", "modelModel", model);
    }

    @RequestMapping("/degenerationView_wmsx")
    public String degenerationView(Model model) {
        ReadCsvUtil readCsvUtil = new ReadCsvUtil("/root/408/rce/output1.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result", result);
        return "/viewer/degenerationView_wmsx";
    }

    @RequestMapping("/degenerationView_dyzz")
    public String degenerationView2(Model model) {
        ReadCsvUtil readCsvUtil = new ReadCsvUtil("/root/408/rce/output1.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result", result);
        return "/viewer/degenerationView_dyzz";
    }

    @RequestMapping("/degenerationView_zkyc")
    public String degenerationView3(Model model) {
        ReadCsvUtil readCsvUtil = new ReadCsvUtil("/root/408/rce/output1.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result", result);
        return "/viewer/degenerationView_zkyc";

    }

    @RequestMapping("/reliabilityView")
    public String reliabilityView(Model model) {
        ReadCsvUtil readCsvUtil = new ReadCsvUtil("/root/408/rce/output2.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result", result);
        return "/viewer/reliabilityView";
    }

    @RequestMapping("/reliabilityView2")
    public String reliabilityView2 (Model model) {
        ReadCsvUtil readCsvUtil = new ReadCsvUtil("/root/408/rce/output2.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result", result);
        return "/viewer/reliabilityView2";
    }
    @RequestMapping("/reliabilityView3")
    public String reliabilityView3 (Model model){
        ReadCsvUtil readCsvUtil = new ReadCsvUtil("/root/408/rce/output2.csv");
        List<String> result = readCsvUtil.read();
        model.addAttribute("result", result);
        return "/viewer/reliabilityView3";
    }

}
