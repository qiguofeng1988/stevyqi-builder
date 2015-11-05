package com.stevyqi.builder.enums;

public enum BeanTypes {
	BIT(-7, "java.lang.Boolean"), TINYINT(-6, "java.lang.Integer"), SMALLINT(5, "java.lang.Integer"), INTEGER(4, "java.lang.Integer"), 
	BIGINT(-5, "java.lang.Long"), FLOAT(6, "java.math.BigDecimal"), REAL(7, "java.math.BigDecimal"), DOUBLE(8, "java.math.BigDecimal"), 
	NUMERIC(2, "java.math.BigDecimal"), DECIMAL(3, "java.math.BigDecimal"), CHAR(1, "java.lang.String"), VARCHAR(12, "java.lang.String"), 
	LONGVARCHAR(-1, "java.lang.String"), DATE(91, "java.util.Date"), TIME(92, "java.util.Date"), TIMESTAMP(93, "java.util.Date"), 
	BINARY(-1, "byte[]"), VARBINARY(-1, "byte[]"), LONGVARBINARY(-1, "byte[]");
	
	BeanTypes(int key, java.lang.String value) {
		this.key = key;
		this.value = value;
	}

	private int key;
	private java.lang.String value;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public static java.lang.String getValue(int key) {
		for (BeanTypes type : BeanTypes.values()) {
			if ((type.getKey() + "").equals(key + "")) {
				return type.value;
			}
		}
		return null;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
