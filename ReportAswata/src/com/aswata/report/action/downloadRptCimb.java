/**
 * 
 */
package com.aswata.report.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.activation.MimeType;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;

/**
 * @author Tri Wahyudi
 *
 */
public class downloadRptCimb extends org.apache.struts.action.Action{
	
	private static String SUCCESS = "success";
    private static Logger log = Logger.getLogger(downloadRptCimb.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (!SUCCESS.equals("success")) { 
			return mapping.findForward(SUCCESS); 
		}
		
		try {
			String filename = request.getParameter("filename");
			String bank = (String)request.getSession(true).getAttribute("bank");
			System.out.println("bank:" + bank);
			File f = null;
			f = new File (StaticParameter.getDownloadFolder(bank) + "/" + filename);
//			f = new File (StaticParameter.DOWNLOAD_FOLDER + "/" + filename);
			System.out.println("file:" + f);
			
			if (f.exists()){
				System.out.println("masuk if");
				try{
					System.out.println("masuk try");
					int length = 0;
			        ServletOutputStream op = response.getOutputStream();
			        ServletContext context = servlet.getServletContext();
			        
			        String mimetype = context.getMimeType(StaticParameter.getDownloadFolder(bank) + "/" + filename);
			        response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
			        response.setContentLength((int) f.length());
			        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//			        response.getOutputStream().flush();
//			        response.getOutputStream().close();
			        byte[] bbuf = new byte[1024];
			        DataInputStream in = new DataInputStream(new FileInputStream(f));
			        while ((in != null) && ((length = in.read(bbuf)) != -1)) {
			            op.write(bbuf, 0, length);
			        }

			        in.close();
			        op.flush();
			        op.close();
				} catch (IOException ex) {
                    //System.out.println("error in donwload : " + ex);
                }
			}
		}catch(Exception e){
        	request.setAttribute("errpage", "Error : " + e.getMessage());
		}	   
		return mapping.findForward("success");
		
			
	        
//	        String dir =(String) request.getSession(true).getAttribute("dir");
//	        System.out.println("filename:" + filename);
//	        System.out.println("dir:" + dir);
//	        
//	        File fl = new File(dir+"/"+filename);
//	        System.out.println("fl:" + fl);
//	        if (fl.exists()) {
//                try {
//                	int length = 0;
//                    ServletOutputStream op = response.getOutputStream();
//                    response.reset();
//                    ServletContext context = servlet.getServletContext();
//                    String mimetype = context.getMimeType(StaticParameter.DOWNLOAD_FOLDER + "/" + filename);
//                    response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
//                    response.setContentLength((int) fl.length());
//                    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//                    byte[] bbuf = new byte[1024];
//                    DataInputStream in = new DataInputStream(new FileInputStream(fl));
//
//                    while ((in != null) && ((length = in.read(bbuf)) != -1)) {
//                        op.write(bbuf, 0, length);
//                    }
//                    
//                    in.close();
//                    op.flush();
//                    op.close();
//                } catch (IOException ex) {
//                    //System.out.println("error in donwload : " + ex);
//                }
//            }
		
	}

}
