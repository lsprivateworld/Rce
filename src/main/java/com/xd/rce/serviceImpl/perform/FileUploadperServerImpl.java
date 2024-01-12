package com.xd.rce.serviceImpl.perform;

import com.xd.rce.domain.perform.Algorithmper;
import com.xd.rce.domain.perform.AnalyseModelProcess;
import com.xd.rce.domain.perform.FileAndUploadper;
import com.xd.rce.mapper.perform.FileUploadperMapper;
import com.xd.rce.service.perform.FileUploadperServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUploadperServerImpl implements FileUploadperServer {
    @Autowired
    private FileUploadperMapper fileUploadperMapper;

    @Override
    public void uploadFileper(FileAndUploadper fileAndUploadper){
        fileUploadperMapper.uploadFileper(fileAndUploadper);
    }

    @Override
    public List<FileAndUploadper> findAllFile() {
        return fileUploadperMapper.findAllFile();
    }

    @Override
    public FileAndUploadper selectAllfillByid(Integer id) {
        return fileUploadperMapper.selectAllfillByid(id);
    }

    @Override
    public List<Algorithmper> selectDataDealByid() {
        return fileUploadperMapper.selectDataDealByid();
    }

    @Override
    public Algorithmper selectalgorithmname() {
        return fileUploadperMapper.selectalgorithmname();
    }

    @Override
    public void deletFileByid(@Param("id") Integer id) {
        fileUploadperMapper.deletFileByid(id);
    }

    @Override
    public Algorithmper selectalgorithByid(@Param("algorithmid")Integer algorithmid) {
        return fileUploadperMapper.selectalgorithByid(algorithmid);
    }

    @Override
    public void saveAlgorithm(Algorithmper algorithmper) {
        fileUploadperMapper.saveAlgorithm(algorithmper);
    }

    @Override
    public void deleteAlgorithm(@Param("algorithmid") Integer algorithmid) {
        fileUploadperMapper.deleteAlgorithm(algorithmid);
    }

    @Override
    public FileAndUploadper selectfillByname(@Param("file_name") String file_name) {
        return fileUploadperMapper.selectfillByname(file_name);
    }

    @Override
    public void insertAnalyseModel(@Param("modelname")String modelname, @Param("modelname")String modelprocess) {
        fileUploadperMapper.insertAnalyseModel(modelname,modelprocess);
    }

    @Override
    public List<AnalyseModelProcess> selectAllModel() {
        return fileUploadperMapper.selectAllModel();
    }

    @Override
    public void deleteModelByid(@Param("id") Integer id) {
        fileUploadperMapper.deleteModelByid(id);
    }

    @Override
    public AnalyseModelProcess selectAllModelByid(Integer id) {
        return fileUploadperMapper.selectAllModelByid(id);
    }

    @Override
    public List<FileAndUploadper> moHuDataSource(@Param("file_name") String file_name) {
        return fileUploadperMapper.moHuDataSource(file_name);
    }

    @Override
    public List<Algorithmper> algorithmSearchSource(@Param("algorithmname") String algorithmname) {
        return fileUploadperMapper.algorithmSearchSource(algorithmname);
    }


}
