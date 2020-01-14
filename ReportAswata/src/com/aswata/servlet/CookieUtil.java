/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aswata.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author herrysuganda
 */
public class CookieUtil {

    private static Logger log = Logger.getLogger(CookieUtil.class);

    public static void setNull2Cookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setValue(null);
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
    }
}
