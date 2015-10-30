package com.stevyqi.builder.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigUtils {

	private static Configuration conf;
	static {
		try {
			conf = new PropertiesConfiguration("properties/db.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static Configuration getConf() {
		return conf;
	}

	public static void setConf(Configuration conf) {
		ConfigUtils.conf = conf;
	}

}
