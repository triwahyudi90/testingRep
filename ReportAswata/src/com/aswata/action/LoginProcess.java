package com.aswata.action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.aswata.parameter.StaticParameter;
import com.aswata.report.entity.RoleMenu;
import com.aswata.report.entity.loginReport;
import com.aswata.report.entity.loginReport2;
import com.aswata.report.function.sqlFunction;


public class LoginProcess extends Action{
	private static Logger log = Logger.getLogger(LoginProcess.class);
    /* forward name="success" path="" */
    private static String SUCCESS = "success";
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html");  
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("user:" + username + "pass:" + password);
        
        sqlFunction sql = new sqlFunction();
        loginReport2 login = sql.getLogin2(username);
        
        String role = login.getRole();
        System.out.println("role:" + login.getRole());
        
        loginReport2 myLogin = sql.getLogin3(username, password, role);
        int Premi = 0;
        int rasio = 0;
        BigDecimal target = new BigDecimal(0);
        
        if (myLogin != null){
        	List<RoleMenu> lrolesHeader = sql.getRole(role);
            request.getSession(true).setAttribute("lrolesHeader", lrolesHeader);RoleMenu header = new RoleMenu();
    		  for (int i = 0; i < lrolesHeader.size(); i++){
    			header = (RoleMenu)lrolesHeader.get(i);
    			 System.out.println("header:" + header.getHeaderName());
    		  }
    		  
    		Premi = sql.getDashoardPremi();
    		target = sql.getDashoardTarget();
//    		rasio = sql.getDashoardRiskProfile();
    		
    		BigDecimal tempPremi = new BigDecimal(Premi);
    		DecimalFormat df = new DecimalFormat("#,###");
    		DecimalFormat df1 = new DecimalFormat("#");
    		String totalPremi = df.format(tempPremi);
    		String totalTarget = df.format(target);
//    		String totalRasio = df1.format(rasio);
    		System.out.println("totalPremi:" + totalPremi);
    		System.out.println("totalTarget:" + totalTarget);
//    		System.out.println("totalRasio:" + totalRasio);
    		
    		request.getSession(true).setAttribute(StaticParameter.MENU_STATUS, role);
            request.getSession(true).setAttribute(StaticParameter.SESSION_USER, username.toUpperCase());
            request.getSession(true).setAttribute("TotPremi", totalPremi);
            request.getSession(true).setAttribute("TotTarget", totalTarget);
//            request.getSession(true).setAttribute("TotRasio", totalRasio);
            request.getSession(true).setAttribute("user", username);
            request.getSession(true).setAttribute("password", password);
            request.getSession(true).setAttribute("role", role);
        	SUCCESS = "success";
        }else{
        	System.out.println("else");
        	request.setAttribute("message", "Login gagal !");
            SUCCESS = "failed";
        }
        return mapping.findForward(SUCCESS);
	}
    
}
