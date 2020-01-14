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
import com.aswata.report.function.sqlFunction;

/**
 * @author Tri Wahyudi
 *
 */
public class rptBankAct extends org.apache.struts.action.Action{
	private static String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SUCCESS = isValidUser(request);
		
		if (!SUCCESS.equals("success")) { 
			return mapping.findForward(SUCCESS); 
		}
		try{
			List lph = new ArrayList(); 
			sqlFunction sql = new sqlFunction();
			String dt1 = request.getParameter("dt1");
			String dt2 = request.getParameter("dt2");
			String bank = request.getParameter("rpt");
			String dir = "";
			System.out.println("dt1: " + dt1 + "dt2:" + dt2 + "bank:" + bank);
			
			if(bank.equals("ALL BANK - CUT OFF")){
				dir = "d:\\data\\Download\\MARKETING\\ALL BANK";
			} else if (bank.equals("BCA")){
				dir = "d:\\data\\Download\\MARKETING\\BCA";
			} else if (bank.equals("BNI")){
				dir = "d:\\data\\Download\\MARKETING\\BNI";
			} else if (bank.equals("BRI")){
				dir = "d:\\data\\Download\\MARKETING\\BRI";
			} else if (bank.equals("CIMB NIAGA")){
				dir = "d:\\data\\Download\\MARKETING\\CIMBNIAGA";
			} else if (bank.equals("MAYBANK")){
				dir = "d:\\data\\Download\\MARKETING\\MAYBANK";
			} else if (bank.equals("MANDIRI")){
				dir = "d:\\data\\Download\\MARKETING\\MANDIRI";
			} else if (bank.equals("PERMATA")){
				dir = "d:\\data\\Download\\MARKETING\\PERMATA";
			} else if (bank.equals("RESUME PRODUKSI")){
				dir = "d:\\data\\Download\\MARKETING\\PRODUKSI";
			} else {
				dir = "d:\\data\\Download\\MARKETING\\UOB BUANA";
			}
			lph = sql.getReportBank(bank, dt1, dt2);
			if (lph.size() > 0){
			  request.setAttribute("fn", lph);
			  request.getSession(true).setAttribute("llsp", lph);
			  request.getSession(true).setAttribute("bank", bank);
			}
			return mapping.findForward(SUCCESS); 
		}
		catch (Exception e) {
		  request.setAttribute("errpage", "Error : " + e.getMessage()); 
		  return mapping.findForward("failed"); 
		} 
	}
	
	private String isValidUser(HttpServletRequest request) {
		int level; int validLevel = 5; 
		if(request.getSession(true).getAttribute(StaticParameter.SESSION_USER) == null) { 
			  request.getSession(true).setAttribute(StaticParameter.USER_LEVEL,validLevel); 
			  request.setAttribute("message", "Login Session Expired, silahkan login kembali!"); 
			  return "loginpage"; 
		}
		return "success";
	 }
	
	
}
