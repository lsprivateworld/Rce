package com.xd.rce.domain.function;


public class ModelAndParam {

    private Integer id;



    private  String param1form;

    private  String param2form;

    private  String param3form;

    private  String param4form;
    private String procElements;
    private String procName;
    private String modelGroup;

    public String getModelGroup() {
        return modelGroup;
    }

    public void setModelGroup(String modelGroup) {
        this.modelGroup = modelGroup;
    }

    private  String mtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getProcElements() {
        return procElements;
    }

    public void setProcElements(String procElements) {
        this.procElements = procElements;
    }

    public String getParam1form() {
        return param1form;
    }

    public void setParam1form(String param1form) {
        this.param1form = param1form;
    }

    public String getParam2form() {
        return param2form;
    }

    public void setParam2form(String param2form) {
        this.param2form = param2form;
    }

    public String getParam3form() {
        return param3form;
    }

    public void setParam3form(String param3form) {
        this.param3form = param3form;
    }

    public String getParam4form() {
        return param4form;
    }

    public void setParam4form(String param4form) {
        this.param4form = param4form;
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ModelAndParam{");
        sb.append("id=").append(id);
        sb.append(", procName='").append(procName).append('\'');
        sb.append(", modelGroup='").append(modelGroup).append('\'');
        sb.append(", procElements='").append(procElements).append('\'');
        sb.append(", param1form='").append(param1form).append('\'');
        sb.append(", param2form='").append(param2form).append('\'');
        sb.append(", param3form='").append(param3form).append('\'');
        sb.append(", param4_orm='").append(param4form).append('\'');
        sb.append(", time='").append(mtime).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }
}
