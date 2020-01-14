/**
 * 
 */
package com.aswata.report.function;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aswata.report.entity.AswataReportDesc;
import com.aswata.report.entity.ReportEom;

/**
 * @author Tri Wahyudi
 *
 */
public class FileFunction {

	private static Logger log = Logger.getLogger(sqlFunction.class);
	public void closeConnDB (Connection conn, PreparedStatement stat, ResultSet rs){
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				log.error("closeConnDb 1 : " + e.getMessage()); 
			}
		}
		if (rs != null){
			try {
				rs.close();
				rs = null;
			} catch (Exception e) {
				log.error("closeConnDb 2 : " + e.getMessage()); 
			}
		}
		if (stat != null){
			try {
				stat.close();
				stat = null;
			} catch (Exception e) {
				log.error("closeConnDb 3 : " + e.getMessage()); 
			}
		}
	}
	
	public List getFileExcel (String src, String dt1){
		System.out.println("src:" + src);
		List lfl = new ArrayList();
        File folder = new File(src);
        System.out.println("folder:" + folder);
        File[] listOfFiles = folder.listFiles();
        System.out.println("listOfFiles:" + listOfFiles);
        if (listOfFiles.length > 0) {
        	ReportEom re = null; 
        	sqlFunction lf = new sqlFunction();
            for (int i = 0; i < listOfFiles.length; i++) {
                String flnm = listOfFiles[i].getName();
                System.out.println("filename:" + flnm);
                System.out.println("filename:" + flnm.substring(0, flnm.length() - 15));
                try {
                    boolean isdirectory = new File(src + "/" + flnm).getCanonicalFile().isDirectory();
                    if (!isdirectory) {
                    	AswataReportDesc rpt = lf.stsDisplay(flnm);
                    	if (rpt != null){          
                    		re = new ReportEom(); 	
                    		re.setNamefile(flnm); 
                    		re.setDescription(rpt.getDesc());
	                        lfl.add(re);  
                    	}
                    }

                } catch (IOException e) {
                    //System.out.println("Error :: " + e.getMessage());
                }
            }
        }
        return lfl;
		
	}
	
	
	
	

	
}
