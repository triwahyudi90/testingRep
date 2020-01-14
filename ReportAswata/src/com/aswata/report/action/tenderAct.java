/**
 * 
 */
package com.aswata.report.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;
import com.aswata.report.function.sqlFunctionMarketing;

/**
 * @author Tri Wahyudi
 *
 */
public class tenderAct extends org.apache.struts.action.Action{
	private static String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SUCCESS = isValidUser(request);
		
		if (!SUCCESS.equals("success")) { 
			return mapping.findForward(SUCCESS); 
		}
		try{
			List tempTender = new ArrayList(); 
			sqlFunctionMarketing sql = new sqlFunctionMarketing();
			String dt1 = request.getParameter("dt1");
			String dt2 = request.getParameter("dt2");
			String branch = request.getParameter("branch");
			String cob = request.getParameter("cob");
			System.out.println("dt1: " + dt1 + "dt2: " + dt2 + "branch:" + branch + "cob:" + cob);
			tempTender = sql.getTender(dt1, dt2, branch, cob);
			
			if (tempTender.size() > 0){
			  request.setAttribute("lph", tempTender);
			  request.getSession(true).setAttribute("llsp", tempTender);
			}
			return mapping.findForward(SUCCESS); 
		}
		catch (Exception e) {
		  request.setAttribute("errpage", "Error : " + e.getMessage()); 
		  return mapping.findForward("failed"); 
		} 
	}

	/**
	 * @param request
	 * @return
	 */
	private String isValidUser(HttpServletRequest request) {
		int validLevel = 5; 
		if(request.getSession(true).getAttribute(StaticParameter.SESSION_USER) == null) { 
			  request.getSession(true).setAttribute(StaticParameter.USER_LEVEL,validLevel); 
			  request.setAttribute("message", "Login Session Expired, silahkan login kembali!"); 
			  return "loginpage"; }
		  
		return "success";
	}
	

}
