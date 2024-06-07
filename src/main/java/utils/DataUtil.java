package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class DataUtil {
	public static String readLoginTestData(String key) throws IOException {
		FileInputStream f = new FileInputStream(FileConstants.Login_TestData_FilePath);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	
	}
}
