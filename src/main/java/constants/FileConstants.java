package constants;

import utils.CommonUtil;

public class FileConstants {
	
	public static final String Login_TestData_FilePath=
			System.getProperty("user.dir")+"\\src\\main\\java\\testData\\loginDetail.properties"; 
	public static final String Screenshots_FolderPath = 
			System.getProperty("user.dir")+"\\src\\main\\java\\reports\\"+CommonUtil.getTimeStamp()+".PNG";
	public static final String Report_Path=
			System.getProperty("user.dir")+"\\src\\main\\java\\reports\\"+CommonUtil.getTimeStamp()+".html";
	public static final String FILE_PATH = 
			System.getProperty("user.dir")+"/src/main/resources//dataset/Read.xlsx";
	public static final String IMAGE_PATH = 
			System.getProperty("user.dir")+"/src/main/resources/images/flower.jpg";	
	
}
