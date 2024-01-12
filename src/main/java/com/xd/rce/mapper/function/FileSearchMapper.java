package com.xd.rce.mapper.function;

import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.domain.perform.FileAndUploadper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FileSearchMapper {

    List<FileAndUploadFun> fileSerach();
    FileAndUploadFun selectAllfillByid(Integer id);
    void fileDeleteByid(Integer id);
    List<FileAndUploadFun> findByfilenameLike(String res);
}
