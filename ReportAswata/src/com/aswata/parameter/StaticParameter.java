package com.aswata.parameter;

public class StaticParameter {

	  public static int TIMEOUT = 10;
	  public static String MENU_STATUS = "menu";
	  public static String SESSION_USER = "userlogin";
	  public static String USER_LEVEL = "userlevel";
	  public static String USER_PASSWORD = "userpassword";
	  public static String USER_ENTITY = "userentity";
//	  public static String DOWNLOAD_FOLDER = "d:\\data\\Download\\MARKETING\\CIMBNIAGA";
//    public static String DOWNLOAD_FOLDER = "/data/app_data/mfep/download";    
	  
	  public static String getDownloadFolder(String folder){
		  System.out.println("folder:" + folder);
		  if (folder.equals("ALL BANK")){
			  return "d:\\data\\Download\\MARKETING\\ALL BANK";
		  } else if (folder.equals("BCA")) {
			  return "d:\\data\\Download\\MARKETING\\BCA";
		  } else if (folder.equals("BNI")) {
			  return "d:\\data\\Download\\MARKETING\\BNI";
		  } else if (folder.equals("BRI")) {
			  return "d:\\data\\Download\\MARKETING\\BRI";
		  } else if (folder.equals("CIMB NIAGA")) {
			  return "d:\\data\\Download\\MARKETING\\CIMBNIAGA";
		  } else if (folder.equals("MANDIRI")) {
			  return "d:\\data\\Download\\MARKETING\\MANDIRI";
		  } else if (folder.equals("MAYBANK")) {
			  return "d:\\data\\Download\\MARKETING\\MAYBANK";
		  } else if (folder.equals("PERMATA")) {
			  return "d:\\data\\Download\\MARKETING\\PERMATA";
		  } else if (folder.equals("PRODUKSI")) {
			  return "d:\\data\\Download\\MARKETING\\PRODUKSI";
		  } else {
			  return "d:\\data\\Download\\MARKETING\\UOB"; 
		  }
	  }
}
