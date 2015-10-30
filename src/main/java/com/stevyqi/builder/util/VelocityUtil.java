package com.stevyqi.builder.util;

import java.io.StringWriter;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.DateTool;

import com.stevyqi.builder.enums.TemplateTypes;
import com.stevyqi.builder.model.TableModel;

/**
 * 
 * @author Stevy Qi
 * @Date 2015年5月28日
 */
public class VelocityUtil {

	public static String createFileStr(TableModel tableModel, String templateName, String packageName,
			String subPackageName) throws Exception {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.setProperty("input.encoding", "UTF-8");
		ve.setProperty("output.encoding", "UTF-8");

		ve.init();
		Template t = ve.getTemplate(templateName);
		VelocityContext ctx = new VelocityContext();

		DateTool dateTool = new DateTool();
		ctx.put("tableModel", tableModel);
		ctx.put("now", dateTool.format("yyyy-M-d HH:mm:ss", new Date()));
		ctx.put("packageName", packageName);
		ctx.put("beanPackageName", packageName + "." + TemplateTypes.JAVABEAN.getPackageName());
		ctx.put("xmlPackageName", packageName + "." + TemplateTypes.MYBAITIS_XML.getPackageName());
		ctx.put("daoPackageName", packageName + "." + TemplateTypes.DAO.getPackageName());
		ctx.put("servicePackageName", packageName + "." + TemplateTypes.SERVICE.getPackageName());
		ctx.put("serviceImplPackageName", packageName + "." + TemplateTypes.SERVICE_IMPL.getPackageName());
		ctx.put("controllerPackageName", packageName + "." + TemplateTypes.CONTROLLER.getPackageName());

		StringWriter sw = new StringWriter();

		t.merge(ctx, sw);

		return sw.toString();
	}

	public static void createFile(TableModel tableModel, TemplateTypes template, String packageName, String savePath)
			throws Exception {
		String content = createFileStr(tableModel, template.getTemplateFileName(), packageName,
				template.getPackageName());
		String filePath = savePath + packageName.replaceAll("\\.", "/") + "/"
				+ template.getPackageName().replaceAll("\\.", "/") + "/" + tableModel.getBeanName()
				+ template.getExtName();
		FileUtil.saveAsFileOutputStream(filePath, content);
		System.out.println("生成文件:" + filePath);
	}

	public static void createFiles(TableModel tableModel, String packageName, String savePath) throws Exception {
		for (TemplateTypes template : TemplateTypes.values()) {
			createFile(tableModel, template, packageName, savePath);
		}
	}
}
