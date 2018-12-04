package net.bnjjong.sample.properties;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * Created by bnjjong on 2018-12-03.
 */
final public class PropertyHandler {
	private Configuration properties = null;

	// 외부에서 객체 생성할 수 없다.
	private PropertyHandler() {
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder;
		builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
				.configure(params.properties()
						.setFileName("properties/sample.properties"));
		try {
			this.properties = builder.getConfiguration();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}


	}

	// 싱글톤 객체
	private static class Singlton {
		private static final PropertyHandler INSTANCE = new PropertyHandler();
	}


	//
	final public static PropertyHandler getInstance() {
		return Singlton.INSTANCE;
	}

	final public Configuration getProperties(){
		return this.properties;
	}


}
