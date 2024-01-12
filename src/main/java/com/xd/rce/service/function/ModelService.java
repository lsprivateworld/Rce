package com.xd.rce.service.function;

import com.xd.rce.domain.function.ModelAndParam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ModelService {

    public String saveModel(ModelAndParam modelAndParam);
    public List<ModelAndParam> showModelList();

    void modelDeleteById(Integer id);


    ModelAndParam openModelById(Integer id);

    ModelAndParam modifyModelById(Integer id);

    String updateModel(ModelAndParam modelAndParam);
}
