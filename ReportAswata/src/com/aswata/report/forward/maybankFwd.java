/**
 * 
 */
package com.aswata.report.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;

/**
 * @author Tri Wahyudi
 *
 */
public class maybankFwd extends org.apache.struts.action.Action{
	
	private static String SUCCESS = "success";
	private static Logger log = Logger.getLogger(maybankFwd.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			if (request.getSession(true).getAttribute(StaticParameter.SESSION_USER) == null) {
	            request.setAttribute("message", "Login Session Expired, silahkan login kembali!");
	            return mapping.findForward(SUCCESS);
	        }
	        
			return mapping.findForward(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(SUCCESS);
	}
	

}
