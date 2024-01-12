package com.xd.rce.serviceImpl.function;



import com.xd.rce.domain.function.ModelAndParam;
import com.xd.rce.mapper.function.ModelMapper;
import com.xd.rce.service.function.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;
    public String saveModel(ModelAndParam modelAndParam){
        String msg = "0";
        if(modelMapper.saveModel(modelAndParam)){
            msg = "1";
        }
        return msg;
    }

    public  List<ModelAndParam>  showModelList(){
       return modelMapper.showModelList();
    }
    public void modelDeleteById(Integer id){
         modelMapper.modelDeleteById(id);
    }
    public ModelAndParam openModelById(Integer id){
        return modelMapper.openModelById(id);
    }
    public ModelAndParam modifyModelById(Integer id){
        return modelMapper.modifyModelById(id);
    }

    @Override
    public String updateModel(ModelAndParam modelAndParam) {
        String msg = "0";
        if(modelMapper.updateModel(modelAndParam)){
            msg = "1";
        }
        return msg;
    }
}
