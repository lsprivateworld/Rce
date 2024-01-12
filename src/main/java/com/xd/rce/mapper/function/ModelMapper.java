package com.xd.rce.mapper.function;

import com.xd.rce.domain.function.ModelAndParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelMapper {

    boolean saveModel(ModelAndParam modelAndParam);

    public List<ModelAndParam> showModelList();
    public void modelDeleteById(Integer id);

    ModelAndParam openModelById(Integer id);

    ModelAndParam modifyModelById(Integer id);

    boolean updateModel(ModelAndParam modelAndParam);
}
