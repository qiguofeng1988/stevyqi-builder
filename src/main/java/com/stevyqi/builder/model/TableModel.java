package com.stevyqi.builder.model;

import java.util.List;
import java.util.Set;

public class TableModel {

	private String tableName;
	private String beanName;
	private String lowerBeanName;
	private FieldModel primaryKey;
	private List<FieldModel> fieldList;
	private Set<String> importSet;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getLowerBeanName() {
		return lowerBeanName;
	}

	public void setLowerBeanName(String lowerBeanName) {
		this.lowerBeanName = lowerBeanName;
	}

	public FieldModel getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(FieldModel primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<FieldModel> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldModel> fieldList) {
		this.fieldList = fieldList;
	}

	public Set<String> getImportSet() {
		return importSet;
	}

	public void setImportSet(Set<String> importSet) {
		this.importSet = importSet;
	}

	@Override
	public String toString() {
		return "TableModel{" +
				"tableName='" + tableName + '\'' +
				", beanName='" + beanName + '\'' +
				", lowerBeanName='" + lowerBeanName + '\'' +
				", primaryKey=" + primaryKey +
				", fieldList=" + fieldList +
				", importSet=" + importSet +
				'}';
	}


}
