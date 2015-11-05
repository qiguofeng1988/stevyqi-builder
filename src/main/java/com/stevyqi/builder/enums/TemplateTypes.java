package com.stevyqi.builder.enums;

public enum TemplateTypes {
	JAVABEAN(1, "templates/javabean.vm", ".java", "model"),
	DAO(2, "templates/dao.vm", "Mapper.java", "dao"),
	MYBAITIS_XML(3, "templates/mybaitisXml.vm", "Mapper.xml", "mapper"),
	SERVICE(4, "templates/service.vm", "Service.java", "service"),
	SERVICE_IMPL(5, "templates/serviceImpl.vm", "ServiceImpl.java", "service.impl"),
	CONTROLLER(6, "templates/controller.vm", "Controller.java", "controller"),
	LIST_VIEW(7, "templates/listView.vm", "_list.vm", "views");

	TemplateTypes(int key, String templateFileName, String extName, String packageName) {
		this.key = key;
		this.templateFileName = templateFileName;
		this.extName = extName;
		this.packageName = packageName;
	}

	private int key;
	private String templateFileName;
	private String extName;
	private String packageName;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getTemplateFileName() {
		for (TemplateTypes template : TemplateTypes.values()) {
			if ((template.getKey() + "").equals(this.key + "")) {
				return template.templateFileName;
			}
		}
		return null;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

	public String getExtName() {
		for (TemplateTypes template : TemplateTypes.values()) {
			if ((template.getKey() + "").equals(this.key + "")) {
				return template.extName;
			}
		}
		return null;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	public String getPackageName() {
		for (TemplateTypes template : TemplateTypes.values()) {
			if ((template.getKey() + "").equals(this.key + "")) {
				return template.packageName;
			}
		}
		return null;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
