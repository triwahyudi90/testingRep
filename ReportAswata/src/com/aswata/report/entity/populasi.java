package com.aswata.report.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class populasi {
	
	private String policyNo;
	private String branchId;
	private String transactionDate;
	private String cob;
	private String qqName;
	private String reqName;
	private String segment;
	private String reqType;
	private String busType;
	private String effDate;
	private String MaturityDate;
	private String share;
	private BigDecimal tsi;
	private BigDecimal premiOri;
	private String curr;
	
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getCob() {
		return cob;
	}
	public void setCob(String cob) {
		this.cob = cob;
	}
	public String getQqName() {
		return qqName;
	}
	public void setQqName(String qqName) {
		this.qqName = qqName;
	}
	public String getReqName() {
		return reqName;
	}
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getEffDate() {
		return effDate;
	}
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	public String getMaturityDate() {
		return MaturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		MaturityDate = maturityDate;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public BigDecimal getTsi() {
		return tsi;
	}
	public void setTsi(BigDecimal tsi) {
		this.tsi = tsi;
	}
	public BigDecimal getPremiOri() {
		return premiOri;
	}
	public void setPremiOri(BigDecimal premiOri) {
		this.premiOri = premiOri;
	}
	
	
}
