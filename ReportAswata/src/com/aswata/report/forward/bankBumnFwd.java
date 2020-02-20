/**
 * 
 */
package com.aswata.report.forward;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;



/**
 * @author Tri Wahyudi
 *
 */
public class bankBumnFwd extends org.apache.struts.action.Action{
	
	private static String SUCCESS = "success";

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getSession(true).getAttribute(StaticParameter.SESSION_USER) == null) {
            request.setAttribute("message", "Login Session Expired, silahkan login kembali!");
            return mapping.findForward(SUCCESS);
        }
        
		return mapping.findForward(SUCCESS);
	}
	
}
