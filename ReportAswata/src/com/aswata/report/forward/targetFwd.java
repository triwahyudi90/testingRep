/**
 * 
 */
package com.aswata.report.forward;

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
public class targetFwd extends org.apache.struts.action.Action{
	
	private static String SUCCESS = "success";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SUCCESS = isValidUser(request);
		
		if (!SUCCESS.equals("success")){
			return mapping.findForward(SUCCESS);
		}
		try {

			List temPtarget = new ArrayList();
			sqlFunction sql = new sqlFunction();
			temPtarget = sql.getTarget();
			if (temPtarget.size() > 0 ) {
				request.setAttribute("temp", temPtarget);
				request.getSession(true).setAttribute("temp", temPtarget);
			} 
			return mapping.findForward(SUCCESS);
		} catch (Exception e) {
			System.out.println("error");
			request.setAttribute("errpage", "Error : " + e.getMessage());
			return mapping.findForward("failed");
		}
	}
	
	
	private String isValidUser(HttpServletRequest request) {
        if (request.getSession(true).getAttribute(StaticParameter.SESSION_USER) == null) {
            request.setAttribute("message", "Login Session Expired, silahkan login kembali!");
            return "loginpage";
        }
       
        return SUCCESS;
	}
}
