/**
 * 
 */
package com.aswata.report.entity;


/**
 * @author Tri Wahyudi
 *
 */
public class AswataReportDesc {
	private String filename;
	private String desc;
	private boolean status_report;
	private String periode;
	private String bank;	
	
	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * @return the periode
	 */
	public String getPeriode() {
		return periode;
	}
	/**
	 * @param periode the periode to set
	 */
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the sts_display
	 */
	/**
	 * @return the status_report
	 */
	public boolean isStatus_report() {
		return status_report;
	}
	/**
	 * @param status_report the status_report to set
	 */
	public void setStatus_report(boolean status_report) {
		this.status_report = status_report;
	}
	
	
	
}
