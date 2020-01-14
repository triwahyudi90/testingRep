/**
 * 
 */
package com.aswata.report.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Tri Wahyudi
 *
 */
public class bri {

	private String policyNo;
	private String bsnId;
	private String branch;
	private String segment;
	private String busCode;
	private String busType;
	private String reqName;
	private String insName;
	private String qqName;
	private Date trDate;
	private String startDate;
	private String expiryDate;
	private BigDecimal premiGross;
	private BigDecimal premiAdjust;
	private BigDecimal stmp;
	private BigDecimal cPol;
	private BigDecimal jasa;
	private BigDecimal premiNett;
	private BigDecimal ppn;
	private BigDecimal pph;
	private BigDecimal tsi;
	private BigDecimal comm;
	private BigDecimal os;
	private String status;
	/**
	 * @return the policyNo
	 */
	
	
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * @return the jasa
	 */
	public BigDecimal getJasa() {
		return jasa;
	}
	/**
	 * @param jasa the jasa to set
	 */
	public void setJasa(BigDecimal jasa) {
		this.jasa = jasa;
	}
	/**
	 * @return the comm
	 */
	public BigDecimal getComm() {
		return comm;
	}
	/**
	 * @param comm the comm to set
	 */
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * @return the bsnId
	 */
	public String getBsnId() {
		return bsnId;
	}
	/**
	 * @param bsnId the bsnId to set
	 */
	public void setBsnId(String bsnId) {
		this.bsnId = bsnId;
	}
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the segment
	 */
	public String getSegment() {
		return segment;
	}
	/**
	 * @param segment the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
	/**
	 * @return the busCode
	 */
	public String getBusCode() {
		return busCode;
	}
	/**
	 * @param busCode the busCode to set
	 */
	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}
	/**
	 * @return the busType
	 */
	public String getBusType() {
		return busType;
	}
	/**
	 * @param busType the busType to set
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}
	/**
	 * @return the reqName
	 */
	public String getReqName() {
		return reqName;
	}
	/**
	 * @param reqName the reqName to set
	 */
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	/**
	 * @return the insName
	 */
	public String getInsName() {
		return insName;
	}
	/**
	 * @param insName the insName to set
	 */
	public void setInsName(String insName) {
		this.insName = insName;
	}
	/**
	 * @return the qqName
	 */
	public String getQqName() {
		return qqName;
	}
	/**
	 * @param qqName the qqName to set
	 */
	public void setQqName(String qqName) {
		this.qqName = qqName;
	}
	/**
	 * @return the trDate
	 */
	public Date getTrDate() {
		return trDate;
	}
	/**
	 * @param trDate the trDate to set
	 */
	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the premiGross
	 */
	public BigDecimal getPremiGross() {
		return premiGross;
	}
	/**
	 * @param premiGross the premiGross to set
	 */
	public void setPremiGross(BigDecimal premiGross) {
		this.premiGross = premiGross;
	}
	/**
	 * @return the premiAdjust
	 */
	public BigDecimal getPremiAdjust() {
		return premiAdjust;
	}
	/**
	 * @param premiAdjust the premiAdjust to set
	 */
	public void setPremiAdjust(BigDecimal premiAdjust) {
		this.premiAdjust = premiAdjust;
	}
	/**
	 * @return the stmp
	 */
	public BigDecimal getStmp() {
		return stmp;
	}
	/**
	 * @param stmp the stmp to set
	 */
	public void setStmp(BigDecimal stmp) {
		this.stmp = stmp;
	}
	/**
	 * @return the cPol
	 */
	public BigDecimal getcPol() {
		return cPol;
	}
	/**
	 * @param cPol the cPol to set
	 */
	public void setcPol(BigDecimal cPol) {
		this.cPol = cPol;
	}
	/**
	 * @return the premiNett
	 */
	public BigDecimal getPremiNett() {
		return premiNett;
	}
	/**
	 * @param premiNett the premiNett to set
	 */
	public void setPremiNett(BigDecimal premiNett) {
		this.premiNett = premiNett;
	}
	/**
	 * @return the ppn
	 */
	public BigDecimal getPpn() {
		return ppn;
	}
	/**
	 * @param ppn the ppn to set
	 */
	public void setPpn(BigDecimal ppn) {
		this.ppn = ppn;
	}
	/**
	 * @return the pph
	 */
	public BigDecimal getPph() {
		return pph;
	}
	/**
	 * @param pph the pph to set
	 */
	public void setPph(BigDecimal pph) {
		this.pph = pph;
	}
	/**
	 * @return the tsi
	 */
	public BigDecimal getTsi() {
		return tsi;
	}
	/**
	 * @param tsi the tsi to set
	 */
	public void setTsi(BigDecimal tsi) {
		this.tsi = tsi;
	}
	/**
	 * @return the os
	 */
	public BigDecimal getOs() {
		return os;
	}
	/**
	 * @param os the os to set
	 */
	public void setOs(BigDecimal os) {
		this.os = os;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
