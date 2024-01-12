package com.xd.rce.service.function;


import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.domain.perform.FileAndUploadper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface FileSearchService {

        List<FileAndUploadFun> fileSearch();
        FileAndUploadFun selectAllfillByid(Integer id);
        void fileDeleteByid(Integer id);
        List<FileAndUploadFun> findByfilenameLike(String res);
}
