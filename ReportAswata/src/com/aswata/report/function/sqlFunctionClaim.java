/**
 * 
 */
package com.aswata.report.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aswata.report.entity.agentRetailClaim;
import com.aswata.report.entity.agentRetailProd;
import com.aswata.report.entity.djarumCs;
import com.aswata.report.entity.regLks;
import com.aswata.singleton.DatasourceEntry;

/**
 * @author Tri Wahyudi
 *
 */
public class sqlFunctionClaim {

	private static Logger log = Logger.getLogger(sqlFunction.class);
	public void closeConnDB (Connection conn, PreparedStatement stat, ResultSet rs){
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				log.error("closeConnDb 1 : " + e.getMessage()); 
			}
		}
		if (rs != null){
			try {
				rs.close();
				rs = null;
			} catch (Exception e) {
				log.error("closeConnDb 2 : " + e.getMessage()); 
			}
		}
		if (stat != null){
			try {
				stat.close();
				stat = null;
			} catch (Exception e) {
				log.error("closeConnDb 3 : " + e.getMessage()); 
			}
		}
	}
	
	public List getProdAgentRetail (String dt1, String dt2, String bsn){
		List lbb = new ArrayList();
		agentRetailProd prod = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM CLAIM_PRODUKSI "
					+ " WHERE TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND BSN_ID = ? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getProdAgentRetail -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			stat.setString(i++, bsn.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				prod = new agentRetailProd();
				prod.setPolicyNo(rs.getString("POLICY_NUMBER"));
				prod.setRegName(rs.getString("REGIONAL_NAME"));
				prod.setBranchName(rs.getString("BRANCH_NAME"));
				prod.setReqType(rs.getString("REQUESTOR_TYPE"));
				prod.setBusType(rs.getString("BUSINESS_TYPE"));
				prod.setBusCode(rs.getString("BUSINESS_CODE"));
				prod.setSegment(rs.getString("IS_CORPORATE"));
				prod.setReqName(rs.getString("REQUESTOR_NAME"));
				prod.setInsName(rs.getString("INSURED_NAME"));
				prod.setTrDate(rs.getString("TRANSACTION_DATE"));
				prod.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				prod.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				prod.setShareAswata(rs.getString("SHARE_ASWATA"));
				prod.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				prod.setPremiNett(rs.getBigDecimal("PREMIUM"));
				prod.setStamp(rs.getBigDecimal("STAMP"));
				prod.setDisc(rs.getBigDecimal("DISCOUNT"));
				prod.setAdm(rs.getBigDecimal("ADM_FEE"));
				prod.setComm(rs.getBigDecimal("COMMISION"));
				prod.setPremiMarketing(rs.getBigDecimal("MARKETING_PREMIUM"));
				lbb.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getClaimAgentRetail (String dt1, String dt2, String bsn){
		List lbb = new ArrayList();
		agentRetailClaim claim = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM CLAIM_LOSS_PROFILE WHERE ";
			
			if ((!"".equals(dt1)) && (!"".equals(dt2))){
				if (!"".equals(bsn)){
					System.out.println("if");
					sql += "DATE_OF_LOSS BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND BSN_ID = ? ORDER BY DATE_OF_LOSS";
				} 
				else if ("0".equals(bsn)) {
					System.out.println("else if");
					sql += "DATE_OF_LOSS BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') ORDER BY DATE_OF_LOSS";
				} else {
					System.out.println("else");
					sql += "DATE_OF_LOSS BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') ORDER BY DATE_OF_LOSS";
				}
			}
			System.out.println("SQL getClaimAgentRetail -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			
			if ((!"".equals(dt1)) && (!"".equals(dt2))){
				if (!"".equals(bsn)){
					stat.setString(i++, dt1.trim());
					stat.setString(i++, dt2.trim());
					stat.setString(i++, bsn.trim());
				}
				else if ("0".equals(bsn)) {
					stat.setString(i++, dt1.trim());
					stat.setString(i++, dt2.trim());
				} else {
					stat.setString(i++, dt1.trim());
					stat.setString(i++, dt2.trim());
				}
			} 
			rs = stat.executeQuery();
			while (rs.next()) {
				claim = new agentRetailClaim();
				claim.setPolicyNo(rs.getString("POLICY_NUMBER"));
				claim.setRegional(rs.getString("REGIONAL"));
				claim.setBranch(rs.getString("BRANCH"));
				claim.setBsn(rs.getString("BSN_ID"));
				claim.setReqType(rs.getString("REQUESTOR_TYPE"));
				claim.setReqName(rs.getString("REQUESTOR_NAME"));
				claim.setLksNo(rs.getString("LKS_NO"));
				claim.setInsuredName(rs.getString("INSURED_NAME"));
				claim.setDol(rs.getDate("DATE_OF_LOSS"));
				claim.setClaimOs(rs.getBigDecimal("CLAIM_OSTD"));
				claim.setClaimPaid(rs.getBigDecimal("CLAIM_PAID"));
				claim.setClaimAmt(rs.getBigDecimal("CLAIM_AMT"));
				lbb.add(claim);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getClaimDjarumCs (String dt1, String dt2, String bsn, String branch){
		List lbb = new ArrayList();
		djarumCs tempDjarum = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM DJARUM_CS WHERE ";
			
			if ((!"".equals(dt1)) && (!"".equals(dt2))){
				if ("101".equals(branch)){
					if ("0".equals(bsn)){
						sql += " CS_DATE >= ? AND CS_DATE <= ? ORDER BY CS_DATE";
					} else {
						sql += " CS_DATE >= ? AND CS_DATE <= ? AND BSN_ID = ? ORDER BY CS_DATE";
					}
				} else {
					if ("0".equals(bsn)){
						sql += " CS_DATE >= ? AND CS_DATE <= ? AND BRANCH_ID = ? ORDER BY CS_DATE";
					} else {
						sql += " CS_DATE >= ? AND CS_DATE <= ? AND BSN_ID = ? AND BRANCH_ID = ? ORDER BY CS_DATE";
					}
				}
			} 
			System.out.println("SQL getClaimDjarumCs -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			
			if ((!"".equals(dt1)) && (!"".equals(dt2))){
				if ("101".equals(branch)){
					if ("0".equals(bsn)){
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
					} else {
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
						stat.setString(i++, bsn.trim());
					}
				} else {
					if ("0".equals(bsn)){
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
						stat.setString(i++, branch.trim());
					} else {
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
						stat.setString(i++, bsn.trim());
						stat.setString(i++, branch.trim());
					}
				}
			} else {
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			}
			rs = stat.executeQuery();
			while (rs.next()) {
				tempDjarum = new djarumCs();
				tempDjarum.setPeriod(rs.getString("POLICY_PERIOD"));
				tempDjarum.setUwYear(rs.getString("UW_YEAR"));
				tempDjarum.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempDjarum.setBsn(rs.getString("BSN_ID"));
				tempDjarum.setBranch(rs.getString("BRANCH_ID"));
				tempDjarum.setReqId(rs.getString("REQUESTOR_ID"));
				tempDjarum.setReqName(rs.getString("REQUESTOR_NAME"));
				tempDjarum.setCsNo(rs.getString("CS_NUMBER"));
				tempDjarum.setCsDate(rs.getString("CS_DATE"));
				tempDjarum.setLksNo(rs.getString("LKS_NUMBER"));
				tempDjarum.setLksDate(rs.getString("LKS_DATE"));
				tempDjarum.setLossDate(rs.getString("LOSS_DATE"));
				tempDjarum.setInsuredName(rs.getString("INSURED_NAME"));
				tempDjarum.setCcy(rs.getString("SI_CURR"));
				tempDjarum.setTsi(rs.getString("SUM_INSURED"));
				tempDjarum.setPaidAmt(rs.getBigDecimal("PAID_AMT"));
				tempDjarum.setCascoAmt(rs.getBigDecimal("CASCO_AMT"));
				tempDjarum.setTplAmt(rs.getBigDecimal("TPL_AMT"));
				tempDjarum.setDeductible(rs.getBigDecimal("DEDUCTIBLE"));
				tempDjarum.setShareAswataAmt(rs.getBigDecimal("ASWT_SHARE_AMT"));
				tempDjarum.setShareAswata(rs.getString("ASWT_SHARE_PCT"));
				tempDjarum.setNoteNo(rs.getString("NOTE_NUMBER"));
				tempDjarum.setStatus(rs.getString("PAID_STATUS"));
				tempDjarum.setType(rs.getString("TYPE_OF_LOSS"));
				lbb.add(tempDjarum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getClaimRegLks (String dt1, String dt2, String bsn, String branch, int client){
		List lbb = new ArrayList();
		regLks tempLks = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM CLAIM_LKS WHERE ";
			
			if ((!"".equals(dt1)) && (!"".equals(dt2))){
				if ("101".equals(branch)){
					if ("0".equals(bsn)){
						sql += " LKS_DATE >= ? AND LKS_DATE <= ? ORDER BY CS_DATE";
					} else {
						sql += " LKS_DATE >= ? AND LKS_DATE <= ? AND BSN_ID = ? ORDER BY CS_DATE";
					}
				} else {
					if ("0".equals(bsn)){
						sql += " LKS_DATE >= ? AND LKS_DATE <= ? AND BRANCH_ID = ? AND PARENT_ID = ? ORDER BY CS_DATE";
					} else {
						sql += " LKS_DATE >= ? AND LKS_DATE <= ? AND BSN_ID = ? AND BRANCH_ID = ? AND PARENT_ID = ? ORDER BY LKS_DATE";
					}
				}
			} 
			System.out.println("SQL getClaimDjarumLks -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			
			if ((!"".equals(dt1)) && (!"".equals(dt2))){
				if ("101".equals(branch)){
					if ("0".equals(bsn)){
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
					} else {
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
						stat.setString(i++, bsn.trim());
					}
				} else {
					if ("0".equals(bsn)){
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
						stat.setString(i++, branch.trim());
						stat.setInt(i++, client);
					} else {
						stat.setString(i++, dt1.trim());
						stat.setString(i++, dt2.trim());
						stat.setString(i++, bsn.trim());
						stat.setString(i++, branch.trim());
						stat.setInt(i++, client);
					}
				}
			} else {
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			}
			rs = stat.executeQuery();
			while (rs.next()) {
				tempLks = new regLks();
				tempLks.setPeriod(rs.getString("POLICY_PERIOD"));
				tempLks.setUwYear(rs.getString("UW_YEAR"));
				tempLks.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempLks.setBsn(rs.getString("BSN_ID"));
				tempLks.setBranch(rs.getString("BRANCH_ID"));
				tempLks.setReqId(rs.getString("REQUESTOR_ID"));
				tempLks.setReqName(rs.getString("REQUESTOR_NAME"));
				tempLks.setLksNo(rs.getString("LKS_NUMBER"));
				tempLks.setLksDate(rs.getString("LKS_DATE"));
				tempLks.setLossDate(rs.getString("LOSS_DATE"));
				tempLks.setInsuredName(rs.getString("INSURED_NAME"));
				tempLks.setSiCcy(rs.getString("SI_CURR"));
				tempLks.setTsi(rs.getString("SUM_INSURED"));
				tempLks.setLossEstimation(rs.getBigDecimal("LOSS_ESTIMATION"));
				tempLks.setType(rs.getString("TYPE_OF_LOSS"));
				lbb.add(tempLks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
}
