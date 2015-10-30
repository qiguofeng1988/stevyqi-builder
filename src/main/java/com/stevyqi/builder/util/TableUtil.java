package com.stevyqi.builder.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.ibatis.type.JdbcType;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.stevyqi.builder.enums.BeanTypes;
import com.stevyqi.builder.model.FieldModel;
import com.stevyqi.builder.model.TableModel;
/**
 * 
 * @author Stevy Qi
 * @Date 2015年5月28日
 */
public class TableUtil {
	
	public static List<TableModel> getTables(String tableName) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException {
		return getTables(tableName,null);
	}
	
	public static List<TableModel> getTables(String tableName,String tablePrefix) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
	SQLException {
		List<TableModel> tableList = Lists.newArrayList();
		
		Class.forName(ConfigUtils.getConf().getString("db.driver")).newInstance();
		Connection conn = DriverManager.getConnection(ConfigUtils.getConf().getString("db.url"));
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet tableRet = dbmd.getTables(null, "%", tableName, new String[] { "TABLE" });
		String sqlTableName;
		String beanTableName;
		String lowerBeanTableName;
		String primaryKey = null;
		while (tableRet.next()){
			TableModel tableModel = new TableModel();
			sqlTableName = tableRet.getString("TABLE_NAME");
			ResultSet pkRSet = dbmd.getPrimaryKeys(null, null, sqlTableName); 
			while( pkRSet.next() ) { 
				if("PRIMARY".equals(pkRSet.getString("PK_NAME")) && 1 == pkRSet.getInt("KEY_SEQ")){
					primaryKey = pkRSet.getString("COLUMN_NAME");
				}
			} 
			tableModel.setTableName(sqlTableName);
			if(tablePrefix != null){
				sqlTableName = sqlTableName.replace(tablePrefix, "");
			}
			beanTableName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, sqlTableName);
			lowerBeanTableName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, sqlTableName);
			tableModel.setBeanName(beanTableName);
			tableModel.setLowerBeanName(lowerBeanTableName);
			String columnName;
			String columnType;
			String beanName;
			String suffixBeanName;
			String beanType;
			String remark;
			int datasize;
			int digits;
			int nullable;
			ResultSet colRet = dbmd.getColumns(null, "%", tableRet.getString("TABLE_NAME"), "%");
			List<FieldModel> fieldList = Lists.newArrayList();
			while (colRet.next()) {
				FieldModel fieldModel = new FieldModel();
				columnName = colRet.getString("COLUMN_NAME");//COLUMN_NAME就是字段的名字
				columnType = JdbcType.forCode(NumberUtils.toInt(colRet.getString("DATA_TYPE"))).name();//TYPE_NAME就是数据类型
				beanName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName);
				suffixBeanName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, columnName);
				beanType = BeanTypes.getValue(NumberUtils.toInt(colRet.getString("DATA_TYPE")));//TYPE_NAME来自 java.sql.Types 的 SQL 类型
				remark = colRet.getString("REMARKS");//REMARKS 描述列的注释（可为 null）
				datasize = colRet.getInt("COLUMN_SIZE");//COLUMN_SIZE返回整数，就是字段的长度
				digits = colRet.getInt("DECIMAL_DIGITS");//小数部分的位数
				nullable = colRet.getInt("NULLABLE");//最后NULLABLE，返回1就表示可以是Null,而0就表示Not Null
				fieldModel.setColumnName(columnName);
				fieldModel.setColumnType(columnType);
				fieldModel.setDatasize(datasize);
				fieldModel.setBeanName(beanName);
				fieldModel.setSuffixBeanName(suffixBeanName);
				fieldModel.setBeanType(beanType);
				fieldModel.setDigits(digits);
				fieldModel.setNullable(nullable);
				fieldModel.setRemark(remark);
				fieldList.add(fieldModel);
				if(columnName.equals(primaryKey)){
					tableModel.setPrimaryKey(fieldModel);
				}
			}
			tableModel.setFieldList(fieldList);
			tableList.add(tableModel);
		}
		return tableList;
	}
	
}
