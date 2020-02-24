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
public class regCsFwd extends org.apache.struts.action.Action{
	
	private static String SUCCESS = "success";

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("1");
		SUCCESS = isValidUser(request);
		
		if (!SUCCESS.equals("success")){
			return mapping.findForward(SUCCESS);
		}
		try {

			List listBsn = new ArrayList();
			List listBranch = new ArrayList();
			List listClient = new ArrayList();
			sqlFunction sql = new sqlFunction();
			listBsn = sql.getBsn();
			listBranch = sql.getbranch();
			listClient = sql.getClient();
			
			request.setAttribute("bsn", listBsn);
			request.setAttribute("branch", listBranch);
			request.setAttribute("client", listClient);
			request.getSession(true).setAttribute("bsn", listBsn);
			request.getSession(true).setAttribute("branch", listBranch);
			request.getSession(true).setAttribute("client", listClient);
			return mapping.findForward(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
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
