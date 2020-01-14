/**
 * 
 */
package com.aswata.report.action;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;
import com.aswata.report.function.sqlFunction;
import com.aswata.report.function.sqlFunctionMarketing;
import com.sun.tools.xjc.api.Mapping;

/**
 * @author Tri Wahyudi
 *
 */
public class mandiriAct extends org.apache.struts.action.Action{

	private static String SUCCESS = "success";
	private static Logger log = Logger.getLogger(mandiriAct.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SUCCESS = isValidUser(request);
		if (!SUCCESS.equals("success")) { 
			return mapping.findForward(SUCCESS); 
		}
		try {
			List lph = new ArrayList(); 
			sqlFunctionMarketing sql = new sqlFunctionMarketing();
			String dt1 = request.getParameter("dt1");
			String dt2 = request.getParameter("dt2");
			System.out.println("dt1:" + dt1 + "dt2:" + dt2);
			
			lph = sql.getMandiri(dt1, dt2);
			if (lph.size() > 0){
				request.setAttribute("lph", lph);
				request.getSession(true).setAttribute("llsp", lph);
			}
			return mapping.findForward(SUCCESS); 
			
		} catch (Exception e) {
			e.printStackTrace();
			  return mapping.findForward("failed"); 
		}
	}
	/**
	 * @param request
	 * @return
	 */
	private String isValidUser(HttpServletRequest request) {
        int validLevel = 5;
        if (request.getSession(true).getAttribute(StaticParameter.SESSION_USER) == null) {
            request.getSession(true).setAttribute(StaticParameter.USER_LEVEL, validLevel);
            request.setAttribute("message", "Login Session Expired, silahkan login kembali!");
            return "loginpage";
        }
        return "success";
	}
	
	
}
