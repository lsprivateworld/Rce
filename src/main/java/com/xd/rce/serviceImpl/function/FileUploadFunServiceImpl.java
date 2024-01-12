package com.xd.rce.serviceImpl.function;

import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.mapper.function.FileUploadFunMapper;
import com.xd.rce.service.function.FileUploadFunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadFunServiceImpl implements FileUploadFunService {
    @Autowired
    private FileUploadFunMapper fileUploadFunMapper;

    @Override
    public void uploadFileFun(FileAndUploadFun fileAndUploadFun) {

        fileUploadFunMapper.uploadFileFun(fileAndUploadFun);
    }


}
