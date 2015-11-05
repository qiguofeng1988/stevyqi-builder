package com.stevyqi.builder.model;

public class FieldModel {

    private String columnName;
    private String columnType;
    private String beanName;
    private String shortBeanType;
    private String suffixBeanName;
    private String beanType;
    private String remark;
    private Integer datasize;
    private Integer digits;
    private Integer nullable;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getSuffixBeanName() {
        return suffixBeanName;
    }

    public void setSuffixBeanName(String suffixBeanName) {
        this.suffixBeanName = suffixBeanName;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDatasize() {
        return datasize;
    }

    public void setDatasize(Integer datasize) {
        this.datasize = datasize;
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public Integer getNullable() {
        return nullable;
    }

    public void setNullable(Integer nullable) {
        this.nullable = nullable;
    }

    public String getShortBeanType() {
        return shortBeanType;
    }

    public void setShortBeanType(String shortBeanType) {
        this.shortBeanType = shortBeanType;
    }

    @Override
    public String toString() {
        return "FieldModel{" +
                "columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", beanName='" + beanName + '\'' +
                ", shortBeanType='" + shortBeanType + '\'' +
                ", suffixBeanName='" + suffixBeanName + '\'' +
                ", beanType='" + beanType + '\'' +
                ", remark='" + remark + '\'' +
                ", datasize=" + datasize +
                ", digits=" + digits +
                ", nullable=" + nullable +
                '}';
    }

}
