package com.stevyqi.builder;

import java.util.List;

import com.stevyqi.builder.model.TableModel;
import com.stevyqi.builder.util.TableUtil;
import com.stevyqi.builder.util.VelocityUtil;

public class App {

	public static void main(String[] args) throws Exception {

		String tableName = "%";
		String tablePrefix = "gogoup_";
		String packageName = "com.zcool.gogoup";
		String savePath = App.class.getClassLoader().getResource("").getPath() + "/out/";
		List<TableModel> tables = TableUtil.getTables(tableName, tablePrefix);
		for (TableModel tableModel : tables) {
			System.out.println(tableModel);
			VelocityUtil.createFiles(tableModel, packageName, savePath);
		}
	}

}
