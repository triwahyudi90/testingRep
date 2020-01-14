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

import com.aswata.report.function.sqlFunction;

/**
 * @author Tri Wahyudi
 *
 */
public class EomCimbAct extends org.apache.struts.action.Action{
	private static String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!SUCCESS.equals("success")) { 
			return mapping.findForward(SUCCESS); 
		}
		try{
			List lph = new ArrayList(); 
			sqlFunction sql = new sqlFunction();
			String dt1 = request.getParameter("dt1");
			String dt2 = request.getParameter("dt2");
			String bank = request.getParameter("bank");
			String dir = "d:\\data\\Download\\MARKETING\\CIMBNIAGA";
			System.out.println("dt1: " + dt1 + "dt2:" + dt2);
			lph = sql.getReportBank(bank, dt1, dt2);
			if (lph.size() > 0){
			  request.setAttribute("fn", lph);
//			  request.getSession(true).setAttribute("newDate", newDate);
			  request.getSession(true).setAttribute("llsp", lph);
			  request.getSession(true).setAttribute("dir", dir);
			}
			return mapping.findForward(SUCCESS); 
		}
		catch (Exception e) {
		  request.setAttribute("errpage", "Error : " + e.getMessage()); 
		  return mapping.findForward("failed"); 
		} 
	}
	
	
}
