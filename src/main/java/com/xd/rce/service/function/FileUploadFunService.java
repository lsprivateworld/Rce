package com.xd.rce.service.function;


import com.xd.rce.domain.function.FileAndUploadFun;
import org.springframework.stereotype.Service;


@Service
public interface FileUploadFunService {
    void uploadFileFun(FileAndUploadFun fileAndUploadFun);
}
