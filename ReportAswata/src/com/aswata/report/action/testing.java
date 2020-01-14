/**
 * 
 */
package com.aswata.report.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * @author Tri Wahyudi
 *
 */
public class testing {

//	public void writing(){
//		try {
//            //Whatever the file path is.
//            File statText = new File("D:/data/Download/MARKETING/CIMBNIAGA/LAPORAN_CIMB_NIAGA_201910.xls");
//            FileOutputStream is = new FileOutputStream(statText);
//            OutputStreamWriter osw = new OutputStreamWriter(is);    
//            Writer w = new BufferedWriter(osw);
//            w.write("POTATO!!!");
//            w.close();
//        } catch (IOException e) {
//            System.err.println("Problem writing to the file statsTest.txt");
//        }
//	}
	
	public static void main(String args[]) throws Exception{
//		int i = 2500000;
//		BigDecimal a = new BigDecimal(i);
//		DecimalFormat df = new DecimalFormat("#,###");
//		String output = df.format(a);
//		System.out.println("a:" + a);
//		System.out.println("output:" + output);
		
//		
//			SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
//			String date1 = "12/01/2019";
//			Date date = format.parse(date1);
//			String newDate = new SimpleDateFormat("dd/mm/yyyy").format(date);
//			System.out.println(newDate);
//            System.out.println(format.format(date));
//            
            
        String tgl = "201910";
        String year = tgl.substring(0, 4);
        String bulan = tgl.substring(4, 6);
        System.out.println("year:" + year);
        System.out.println("bulan:" + bulan);
			
//		testing write = new testing();
//        write.writing();
	}
}
