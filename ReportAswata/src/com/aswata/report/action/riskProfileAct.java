/**
 * 
 */
package com.aswata.report.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;
import com.aswata.report.function.sqlFunction;
import com.aswata.report.function.sqlFunctionClaim;
/**
 * @author Tri Wahyudi
 *
 */
public class riskProfileAct extends org.apache.struts.action.Action{
	private static String SUCCESS = "success";

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
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
			String asat = request.getParameter("asat");
			String uwyear = request.getParameter("uwyear");
			String bsn = request.getParameter("bsn");
			String branch = request.getParameter("branch");
				
			String tahun = asat.substring(0, 4);
			String bulan = asat.substring(4, 6);
//			convert tgl 
//			SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
//			Date date1 = format.parse(dt1);
//			Date date2 = format.parse(dt2);
//			
//			String newDate1 = new SimpleDateFormat("dd/mm/yyyy").format(date1);
//			String newDate2 = new SimpleDateFormat("dd/mm/yyyy").format(date2);
			
			System.out.println("dt1: " + asat + "uwyear: " + uwyear + "bsn:" + bsn + "branch:" + branch + "tahun:" + tahun + "bulan:" + bulan);
			lph = sql.getDashboardRisk(tahun, bulan, bsn, branch);
			
			if (lph.size() > 0){
			  request.setAttribute("lph", lph);
			  request.getSession(true).setAttribute("llsp", lph);
			}
			return mapping.findForward(SUCCESS); 
		}
		catch (Exception e) {
		  request.setAttribute("errpage", "Error : " + e.getMessage()); 
		  return mapping.findForward("errPage"); 
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
