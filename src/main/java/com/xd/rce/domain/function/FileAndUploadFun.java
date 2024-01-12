package com.xd.rce.domain.function;

public class FileAndUploadFun {
    private Integer id;
    private String fileName;
    private String fileGroup;
    private String fileKind;
    private String fileTime;
    private String filePath;
    private String fileSize;
    private String fileText;

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileGroup() {
        return fileGroup;
    }

    public void setFileGroup(String fileGroup) {
        this.fileGroup = fileGroup;
    }

    public String getFileKind() {
        return fileKind;
    }

    public void setFileKind(String fileKind) {
        this.fileKind = fileKind;
    }

    public String getFileTime() {
        return fileTime;
    }

    public void setFileTime(String fileTime) {
        this.fileTime = fileTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public FileAndUploadFun() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FileAndUploadFun{");
        sb.append("id=").append(id);
        sb.append(", fileName='").append(fileName).append('\'');
        sb.append(", fileGroup='").append(fileGroup).append('\'');
        sb.append(", fileKind='").append(fileKind).append('\'');
        sb.append(", fileTime='").append(fileTime).append('\'');
        sb.append(", filePath='").append(filePath).append('\'');
        sb.append(", fileSize='").append(fileSize).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
