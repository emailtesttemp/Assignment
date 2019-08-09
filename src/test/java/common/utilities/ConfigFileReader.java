package common.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "./config.properties";

	public ConfigFileReader() throws IOException {
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties = new Properties();
		properties.load(reader);
		reader.close();
	}

	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
}
