package com.xd.rce.serviceImpl.function;

import com.xd.rce.domain.function.FileAndUploadFun;
import com.xd.rce.mapper.function.FileSearchMapper;
import com.xd.rce.service.function.FileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileSearchImpl implements FileSearchService {
    @Autowired
    private FileSearchMapper fileSearchMapper;
    @Override
    public List<FileAndUploadFun> fileSearch() {
        return fileSearchMapper.fileSerach();
    }

    @Override
    public FileAndUploadFun selectAllfillByid(Integer id) {
        return fileSearchMapper.selectAllfillByid(id);
    }

    @Override
    public void fileDeleteByid(Integer id) {
     fileSearchMapper.fileDeleteByid(id);
    }

    @Override
    public List<FileAndUploadFun> findByfilenameLike(String res) {
        return fileSearchMapper.findByfilenameLike(res);
    }


}
