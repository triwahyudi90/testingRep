/**
 * 
 */
package com.aswata.report.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.report.function.FileFunction;
import com.aswata.report.function.sqlFunction;

/**
 * @author Tri Wahyudi
 *
 */
public class viewRepCimbAct extends org.apache.struts.action.Action {
	
	private static String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!SUCCESS.equals("success")) { 
			return mapping.findForward(SUCCESS); 
		}
		try {
			List lph = new ArrayList();
			sqlFunction sql = new sqlFunction();
			FileFunction ff = new FileFunction();
			String dt1 = request.getParameter("dt1");
			
			String dir = "d:\\data\\Download\\MARKETING\\CIMBNIAGA";
			System.out.println("dir: " + dir);
			boolean isdirectory = new File (dir).getCanonicalFile().isDirectory();
			if (isdirectory){
				List fn = ff.getFileExcel(dir, dt1);
				if (fn.size()>0){
					request.setAttribute("fn", fn);
		        	request.setAttribute("eodReport", "viewdata");
		        	request.getSession(true).setAttribute("dir", dir);
		        	request.getSession(true).setAttribute("dt1", dt1);
				} else {
	        	request.setAttribute("respon", "<br><br><b>Data Report Tidak Tersedia</b></br></br>");
	        	request.setAttribute("eodReport", "notok");
				}
	        } else {
	        	request.setAttribute("respon", "<br><br><b>Data Report Tidak Tersedia</b></br></br>");
	        	request.setAttribute("eodReport", "notok");
	        }
			return mapping.findForward(SUCCESS);
		} catch (Exception e) {
			request.setAttribute("errpage", "Error : " + e.getMessage());
            return mapping.findForward("failed");
		}
	}
}
