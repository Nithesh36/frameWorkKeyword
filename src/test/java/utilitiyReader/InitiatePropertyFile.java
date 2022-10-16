package utilitiyReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitiatePropertyFile {

	public static Properties properties;
	private final static String propertyFilePath= "C:\\Users\\nithesh\\Desktop\\Framework_QA\\keywordDriven\\src\\test\\resources\\utilityFiles\\Constants.properties";


	public static void ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}	

	}


}
