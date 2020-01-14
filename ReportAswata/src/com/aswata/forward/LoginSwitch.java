package com.aswata.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;
import com.aswata.parameter.UserLevelName;

public class LoginSwitch extends org.apache.struts.action.Action{
	/* forward name="success" path="" */
	private static final String SUCCESS = "success";
	private static Logger log = Logger.getLogger(LoginSwitch.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int level = 5;
		try {
			if (request.getParameter("level") == null) {
				if (request.getSession(true).getAttribute(StaticParameter.USER_LEVEL) != null) {
	                level = Integer.valueOf(request.getSession(true).getAttribute(StaticParameter.USER_LEVEL).toString());
	            }
			} else {
				level = Integer.valueOf(request.getParameter("level"));
			}
			request.setAttribute("level", level);
			request.setAttribute("levelname", UserLevelName.getUserNameLevel(level));
		} catch (Exception ex) {
			log.error("Error_LOGIN :::  from : " + request.getRemoteAddr() + " " + ex.getMessage());
			request.setAttribute("level", "5");
		}
		return mapping.findForward(SUCCESS);
	}
	
	
	
	
}

