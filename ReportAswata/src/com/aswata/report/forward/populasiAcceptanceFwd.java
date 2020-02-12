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
public class populasiAcceptanceFwd extends org.apache.struts.action.Action{
	
	private static String SUCCESS = "success";

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		SUCCESS = isValidUser(request);
		
		if (!SUCCESS.equals("success")){
			return mapping.findForward(SUCCESS);
		}
		try {

			List listBranch = new ArrayList();
			sqlFunction sql = new sqlFunction();
			listBranch = sql.getbranch();
			
			request.setAttribute("branch", listBranch);
			request.getSession(true).setAttribute("branch", listBranch);
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
