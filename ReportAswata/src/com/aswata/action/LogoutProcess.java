/**
 * 
 */
package com.aswata.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.servlet.CookieUtil;


/**
 * @author Tri Wahyudi
 *
 */
public class LogoutProcess extends org.apache.struts.action.Action{
	
	private static Logger log = Logger.getLogger(LogoutProcess.class);
	private static String SUCCESS = "success";
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		CookieUtil.setNull2Cookies(request, response);
		return mapping.findForward(SUCCESS);
	} 
	
	

}
