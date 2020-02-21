package com.aswata.report.entity;

import java.math.BigDecimal;

public class merimenFee {
	
	private String branchId;
	private String branchName;
	private String lksHeaderNo;
	private String claimStatNo;
	private String policyNo;
	private String insuredName;
	private String riskName;
	private String ccy;
	private BigDecimal claimAmt;
	private String paidTo;
	private BigDecimal merimenFee;
	private String documentNo;
	private String trxDate;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getLksHeaderNo() {
		return lksHeaderNo;
	}
	public void setLksHeaderNo(String lksHeaderNo) {
		this.lksHeaderNo = lksHeaderNo;
	}
	public String getClaimStatNo() {
		return claimStatNo;
	}
	public void setClaimStatNo(String claimStatNo) {
		this.claimStatNo = claimStatNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public BigDecimal getclaimAmt() {
		return claimAmt;
	}
	public void setclaimAmt(BigDecimal claimAmt) {
		this.claimAmt = claimAmt;
	}
	public String getPaidTo() {
		return paidTo;
	}
	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}
	public BigDecimal getMerimenFee() {
		return merimenFee;
	}
	public void setMerimenFee(BigDecimal merimenFee) {
		this.merimenFee = merimenFee;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}
	
	
}
