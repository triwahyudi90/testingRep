/**
 * 
 */
package com.aswata.report.entity;

import java.util.Comparator;


/**
 * @author Tri Wahyudi
 *
 */
public class ReportEom {

	private String namefile;	
	private String description;
	
	public static class OrderByFilename implements Comparator<ReportEom>{
		public int compare(ReportEom o1, ReportEom o2) {
            return o1.namefile.compareTo(o2.namefile);
        }
	}

	/**
	 * @return the namefile
	 */
	public String getNamefile() {
		return namefile;
	}

	/**
	 * @param namefile the namefile to set
	 */
	public void setNamefile(String namefile) {
		this.namefile = namefile;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
