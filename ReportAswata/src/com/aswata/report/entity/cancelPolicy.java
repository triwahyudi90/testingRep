package com.aswata.report.entity;

import java.math.BigDecimal;

public class cancelPolicy {
	
	private String branch;
	private String insuredName;
	private String policyNo;
	private String effectiveDate;
	private String expiredDate;
	private String effectiveEndorseDate;
	private String EndorseCreatedDate;
	private String ccy;
	private BigDecimal tsi;
	private String cob;
	private String reqName;
	private String busType;
	private String share;
	private String docNumber;
	private String trnDate;
	private BigDecimal amtOri;
	private BigDecimal amtBase;
	
	
	public String getEffectiveEndorseDate() {
		return effectiveEndorseDate;
	}
	public void setEffectiveEndorseDate(String effectiveEndorseDate) {
		this.effectiveEndorseDate = effectiveEndorseDate;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	
	public String getEndorseCreatedDate() {
		return EndorseCreatedDate;
	}
	public void setEndorseCreatedDate(String endorseCreatedDate) {
		EndorseCreatedDate = endorseCreatedDate;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public BigDecimal getTsi() {
		return tsi;
	}
	public void setTsi(BigDecimal tsi) {
		this.tsi = tsi;
	}
	public String getCob() {
		return cob;
	}
	public void setCob(String cob) {
		this.cob = cob;
	}
	public String getReqName() {
		return reqName;
	}
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public String getTrnDate() {
		return trnDate;
	}
	public void setTrnDate(String trnDate) {
		this.trnDate = trnDate;
	}
	public BigDecimal getAmtOri() {
		return amtOri;
	}
	public void setAmtOri(BigDecimal amtOri) {
		this.amtOri = amtOri;
	}
	public BigDecimal getAmtBase() {
		return amtBase;
	}
	public void setAmtBase(BigDecimal amtBase) {
		this.amtBase = amtBase;
	}
	
	
}
