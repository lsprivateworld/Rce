package com.xd.rce.mapper.function;

import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.domain.perform.FileAndUploadper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FileUploadFunMapper {
    void uploadFileFun(FileAndUploadFun fileAndUploadFun);

}
