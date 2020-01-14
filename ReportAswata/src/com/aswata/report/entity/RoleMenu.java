/**
 * 
 */
package com.aswata.report.entity;

import java.util.ArrayList;

/**
 * @author Tri Wahyudi
 *
 */
public class RoleMenu {
	private String HeaderName;
	private ArrayList subSubMenu;
	/**
	 * @return the headerName
	 */
	public String getHeaderName() {
		return HeaderName;
	}
	/**
	 * @param headerName the headerName to set
	 */
	public void setHeaderName(String headerName) {
		HeaderName = headerName;
	}
	/**
	 * @return the subSubMenu
	 */
	public ArrayList getSubSubMenu() {
		return subSubMenu;
	}
	/**
	 * @param subSubMenu the subSubMenu to set
	 */
	public void setSubSubMenu(ArrayList subSubMenu) {
		this.subSubMenu = subSubMenu;
	}
	
}
