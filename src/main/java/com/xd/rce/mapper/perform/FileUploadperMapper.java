package com.xd.rce.mapper.perform;

import com.xd.rce.domain.perform.Algorithmper;
import com.xd.rce.domain.perform.AnalyseModelProcess;
import com.xd.rce.domain.perform.FileAndUploadper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface FileUploadperMapper {
    void uploadFileper(FileAndUploadper fileAndUploadper);
    List<FileAndUploadper> findAllFile();
     FileAndUploadper selectAllfillByid(Integer id);
    FileAndUploadper selectfillByname(@Param("file_name") String file_name);
    List<Algorithmper> selectDataDealByid();
    Algorithmper selectalgorithmname();
    void deletFileByid(@Param("id") Integer id);
    Algorithmper selectalgorithByid(@Param("algorithmid") Integer algorithmid);
    void saveAlgorithm(Algorithmper algorithmper);
    void deleteAlgorithm(@Param("algorithmid") Integer algorithmid);
    void insertAnalyseModel(@Param("modelname") String modelname, @Param("modelprocess") String modelprocess);
    List<AnalyseModelProcess> selectAllModel();
    void deleteModelByid(@Param("id") Integer id);
    AnalyseModelProcess selectAllModelByid(@Param("id") Integer id);
    List<FileAndUploadper> moHuDataSource(@Param("file_name") String file_name);
    List<Algorithmper> algorithmSearchSource(@Param("algorithmname") String algorithmname);
}
