package net.bnjjong.sample.properties;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;


/**
 * Created by bnjjong on 2018-07-24.
 * 프로퍼티 utils
 *
 * 관련 사이트
 * https://commons.apache.org/proper/commons-configuration/index.html
 */
public class PropertiesSample {

	public static void main(String[] args) throws ConfigurationException {
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder;
		builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
					.configure(params.properties()
						.setFileName("properties/sample.properties"));

		Configuration config = builder.getConfiguration();

		System.out.println(config.getString("test.value"));
		System.out.println(config.getString("test.value2"));


	}
}
