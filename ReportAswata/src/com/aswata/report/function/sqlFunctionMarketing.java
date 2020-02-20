/**
 * 
 */
package com.aswata.report.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.aswata.report.entity.Tender;
import com.aswata.report.entity.bankBumn;
import com.aswata.report.entity.bni;
import com.aswata.report.entity.bri;
import com.aswata.report.entity.cimbNiaga;
import com.aswata.report.entity.mandiri;
import com.aswata.report.entity.maybank;
import com.aswata.report.entity.maybankCetak;
import com.aswata.report.entity.uob;
import com.aswata.singleton.DatasourceEntry;
/**
 * @author Tri Wahyudi
 *
 */
public class sqlFunctionMarketing {
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
	
	public List getCimb (String dt1, String dt2){
		List lbb = new ArrayList();
		cimbNiaga cimb = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM CIMB_NIAGA "
					+ " WHERE TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getCimb -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				cimb = new cimbNiaga();
				cimb.setPeriode(rs.getString("PERIODE"));
				cimb.setBusreq(rs.getString("BUSREQ_ID"));
				cimb.setPolicyNumber(rs.getString("POLICY_NUMBER"));
				cimb.setNamaTertanggung(rs.getString("NAMA_TERTANGGUNG"));
				cimb.setQqName(rs.getString("QQ_NAME"));
				cimb.setCabang(rs.getString("CABANG_CIMB"));
				cimb.setKota(rs.getString("KOTA"));
				cimb.setJenisPertanggungan(rs.getString("JENIS_PERTANGGUNGAN"));
				cimb.setTglEfektif(rs.getString("INSURANCE_STARTDATE"));
				cimb.setTglJatuhTempo(rs.getString("INSURANCE_EXPIRYDATE"));
				cimb.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				cimb.setPremiGross(rs.getBigDecimal("PREMI_GROSS"));
				cimb.setKomisi(rs.getBigDecimal("KOMISI"));
				cimb.setKomisiBank(rs.getBigDecimal("BANKS_COMM"));
				cimb.setDiskon(rs.getBigDecimal("DISKON"));
				cimb.setPpn(rs.getBigDecimal("PPN"));
				lbb.add(cimb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getMaybankDwnld (String dt1, String dt2){
		List lbb = new ArrayList();
		maybankCetak bii = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM MAYBANK "
					+ " WHERE TRANSACTION_DATE >= ? AND TRANSACTION_DATE <=? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getMaybank -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				bii = new maybankCetak();
				bii.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				bii.setPolicyNo(rs.getString("POLICY_SLIP_NUMBER"));
				bii.setBranch(rs.getString("BRANCH_NAME"));
				bii.setCob(rs.getString("BSN_NAME"));
				bii.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				bii.setEndDate(rs.getString("INSURANCE_EXPIRYDATE"));
				bii.setReqName(rs.getString("REQ_NAME"));
				bii.setInsuredName(rs.getString("INSURED_NAME"));
				bii.setQq(rs.getString("QQ_1"));
				bii.setpremiGross(rs.getBigDecimal("PREMI"));
				bii.setStmp(rs.getBigDecimal("STMP"));
				bii.setComm(rs.getBigDecimal("COMM"));
				bii.setJasa(rs.getBigDecimal("JASA"));
				bii.setcPol(rs.getBigDecimal("C_POL"));
				bii.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				bii.setTahun(rs.getString("TAHUN"));
				bii.setBulan(rs.getString("BULAN"));
				lbb.add(bii);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getMaybank (String dt1, String dt2){
		List lbb = new ArrayList();
		maybank bii = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM MAYBANK "
					+ " WHERE TRANSACTION_DATE >= ? AND TRANSACTION_DATE <=? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getMaybank -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				bii = new maybank();
				bii.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				bii.setPolicyNo(rs.getString("POLICY_SLIP_NUMBER"));
				bii.setBranch(rs.getString("BRANCH_NAME"));
				bii.setCob(rs.getString("BSN_NAME"));
				bii.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				bii.setEndDate(rs.getString("INSURANCE_EXPIRYDATE"));
				bii.setReqName(rs.getString("REQ_NAME"));
				bii.setInsuredName(rs.getString("INSURED_NAME"));
				bii.setQq(rs.getString("QQ_1"));
				bii.setpremiGross(rs.getBigDecimal("PREMI"));
				bii.setStmp(rs.getBigDecimal("STMP"));
				bii.setComm(rs.getBigDecimal("COMM"));
				bii.setJasa(rs.getBigDecimal("JASA"));
				bii.setcPol(rs.getBigDecimal("C_POL"));
				bii.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				bii.setTahun(rs.getString("TAHUN"));
				bii.setBulan(rs.getString("BULAN"));
				lbb.add(bii);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getBankBumn (String dt1, String dt2, String bank){
		List lbb = new ArrayList();
		bankBumn tempBumn = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM PRODUKSI_MARKETING_BANK_BUMN WHERE";
					
					if ("BNI".equals(bank)){
						sql += " TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND DESC_BANK = 'BNI' ";
					} else if ("BRI".equals(bank)){
						sql += " TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND DESC_BANK = 'BRI' ";
					} else if ("MANDIRI".equals(bank)){
						sql += " TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND DESC_BANK = 'MANDIRI' ";
					} else {
						sql += " TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
					}
					sql += "ORDER BY TRANSACTION_DATE";
			
			System.out.println("SQL getBankBumn -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			if ("BNI".equals(bank)){
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			} else if ("BRI".equals(bank)){
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			} else if ("MANDIRI".equals(bank)){
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			} else {
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			}
			
			rs = stat.executeQuery();
			while (rs.next()) {
				tempBumn = new bankBumn();
				tempBumn.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempBumn.setBsnId(rs.getString("COB"));
				tempBumn.setBranch(rs.getString("BRANCH_NAME"));
				tempBumn.setSegment(rs.getString("SEGMEN"));
				tempBumn.setBusCode(rs.getString("BUSINESS_CODE"));
				tempBumn.setBusType(rs.getString("BUSINESS_TYPE"));
				tempBumn.setReqName(rs.getString("REQUESTOR_NAME"));
				tempBumn.setInsName(rs.getString("INSURED_NAME"));
				tempBumn.setQqName(rs.getString("QQ_NAME"));
				tempBumn.setTrDate(rs.getDate("TRANSACTION_DATE"));
				tempBumn.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tempBumn.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tempBumn.setPremiGross(rs.getBigDecimal("PREMI"));
				tempBumn.setPremiAdjust(rs.getBigDecimal("PRM_ADJUST"));
				tempBumn.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				tempBumn.setStmp(rs.getBigDecimal("STMP"));
				tempBumn.setcPol(rs.getBigDecimal("C_POL"));
				tempBumn.setJasa(rs.getBigDecimal("JASA"));
				tempBumn.setComm(rs.getBigDecimal("COMM"));
				tempBumn.setPpn(rs.getBigDecimal("PPN"));
				tempBumn.setPph(rs.getBigDecimal("PPH"));
				tempBumn.setOs(rs.getBigDecimal("OSTD_IDR_PERPOLIS"));
				tempBumn.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				tempBumn.setStatus(rs.getString("STATUS_OSTD_IDR_PERPOLIS"));
				tempBumn.setBankerClause(rs.getString("CLAUSE_BANK"));
				tempBumn.setDescBank(rs.getString("DESC_BANK"));
				lbb.add(tempBumn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getBni (String dt1, String dt2){
		List lbb = new ArrayList();
		bni tempBni = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM BNI "
					+ " WHERE TO_CHAR(TRANSACTION_DATE,'DD/MM/YYYY') >= ? AND TO_CHAR(TRANSACTION_DATE,'DD/MM/YYYY') <=? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getBni -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				tempBni = new bni();
				tempBni.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempBni.setBsnId(rs.getString("BSN_ID"));
				tempBni.setBranch(rs.getString("BRANCH_NAME"));
				tempBni.setSegment(rs.getString("SEGMEN"));
				tempBni.setBusCode(rs.getString("BUSINESS_CODE"));
				tempBni.setBusType(rs.getString("BUSINESS_TYPE"));
				tempBni.setReqName(rs.getString("REQUESTOR_NAME"));
				tempBni.setInsName(rs.getString("INSURED_NAME"));
				tempBni.setQqName(rs.getString("QQ_NAME"));
				tempBni.setTrDate(rs.getDate("TRANSACTION_DATE"));
				tempBni.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tempBni.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tempBni.setPremiGross(rs.getBigDecimal("PREMI"));
				tempBni.setPremiAdjust(rs.getBigDecimal("PRM_ADJUST"));
				tempBni.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				tempBni.setStmp(rs.getBigDecimal("STMP"));
				tempBni.setcPol(rs.getBigDecimal("C_POL"));
				tempBni.setJasa(rs.getBigDecimal("JASA"));
				tempBni.setComm(rs.getBigDecimal("COMM"));
				tempBni.setPpn(rs.getBigDecimal("PPN"));
				tempBni.setPph(rs.getBigDecimal("PPH"));
				tempBni.setOs(rs.getBigDecimal("OSTD_IDR_PERPOLIS"));
				tempBni.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				tempBni.setStatus(rs.getString("STATUS_OSTD_IDR_PERPOLIS"));
				lbb.add(tempBni);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getBri (String dt1, String dt2){
		List lbb = new ArrayList();
		bri tempBri = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM BRI "
					+ " WHERE TO_CHAR(TRANSACTION_DATE,'DD/MM/YYYY') >= ? AND TO_CHAR(TRANSACTION_DATE,'DD/MM/YYYY') <=? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getBri -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				tempBri = new bri();
				tempBri.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempBri.setBsnId(rs.getString("BSN_ID"));
				tempBri.setBranch(rs.getString("BRANCH_NAME"));
				tempBri.setSegment(rs.getString("SEGMEN"));
				tempBri.setBusCode(rs.getString("BUSINESS_CODE"));
				tempBri.setBusType(rs.getString("BUSINESS_TYPE"));
				tempBri.setReqName(rs.getString("REQUESTOR_NAME"));
				tempBri.setInsName(rs.getString("INSURED_NAME"));
				tempBri.setQqName(rs.getString("QQ_NAME"));
				tempBri.setTrDate(rs.getDate("TRANSACTION_DATE"));
				tempBri.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tempBri.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tempBri.setPremiGross(rs.getBigDecimal("PREMI"));
				tempBri.setPremiAdjust(rs.getBigDecimal("PRM_ADJUST"));
				tempBri.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				tempBri.setStmp(rs.getBigDecimal("STMP"));
				tempBri.setcPol(rs.getBigDecimal("C_POL"));
				tempBri.setJasa(rs.getBigDecimal("JASA"));
				tempBri.setComm(rs.getBigDecimal("COMM"));
				tempBri.setPpn(rs.getBigDecimal("PPN"));
				tempBri.setPph(rs.getBigDecimal("PPH"));
				tempBri.setOs(rs.getBigDecimal("OSTD_IDR_PERPOLIS"));
				tempBri.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				tempBri.setStatus(rs.getString("STATUS_OSTD_IDR_PERPOLIS"));
				lbb.add(tempBri);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getMandiri (String dt1, String dt2){
		List lbb = new ArrayList();
		mandiri tempMdr = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM BRI "
					+ " WHERE TO_CHAR(TRANSACTION_DATE,'DD/MM/YYYY') >= ? AND TO_CHAR(TRANSACTION_DATE,'DD/MM/YYYY') <=? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getBri -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				tempMdr = new mandiri();
				tempMdr.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempMdr.setBsnId(rs.getString("BSN_ID"));
				tempMdr.setBranch(rs.getString("BRANCH_NAME"));
				tempMdr.setSegment(rs.getString("SEGMEN"));
				tempMdr.setBusCode(rs.getString("BUSINESS_CODE"));
				tempMdr.setBusType(rs.getString("BUSINESS_TYPE"));
				tempMdr.setReqName(rs.getString("REQUESTOR_NAME"));
				tempMdr.setInsName(rs.getString("INSURED_NAME"));
				tempMdr.setQqName(rs.getString("QQ_NAME"));
				tempMdr.setTrDate(rs.getDate("TRANSACTION_DATE"));
				tempMdr.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tempMdr.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tempMdr.setPremiGross(rs.getBigDecimal("PREMI"));
				tempMdr.setPremiAdjust(rs.getBigDecimal("PRM_ADJUST"));
				tempMdr.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				tempMdr.setStmp(rs.getBigDecimal("STMP"));
				tempMdr.setcPol(rs.getBigDecimal("C_POL"));
				tempMdr.setJasa(rs.getBigDecimal("JASA"));
				tempMdr.setComm(rs.getBigDecimal("COMM"));
				tempMdr.setPpn(rs.getBigDecimal("PPN"));
				tempMdr.setPph(rs.getBigDecimal("PPH"));
				tempMdr.setOs(rs.getBigDecimal("OSTD_IDR_PERPOLIS"));
				tempMdr.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				tempMdr.setStatus(rs.getString("STATUS_OSTD_IDR_PERPOLIS"));
				lbb.add(tempMdr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getUob (String dt1, String dt2, String status){
		List lbb = new ArrayList();
		uob tempUob = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM UOB WHERE ";
			
			if ("1".equals(status)){
				sql += " TRANSACTION_DATE >= ? AND TRANSACTION_DATE <= ? ";
			} else if  ("2".equals(status)){
				sql += " TRANSACTION_DATE >= ? AND TRANSACTION_DATE <= ? AND STATUS = 'KURANG DARI 1 TAHUN'";
			} else {
				sql += " TRANSACTION_DATE >= ? AND TRANSACTION_DATE <= ? AND STATUS = 'LEBIH DARI 1 TAHUN'";
			}
			
			sql += " ORDER BY TRANSACTION_DATE";
					
			System.out.println("SQL Uob -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			
			if ("1".equals(status)){
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			} else if ("2".equals(status)){
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			} else {
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			}
			
			rs = stat.executeQuery();
			while (rs.next()) {
				tempUob = new uob();
				tempUob.setPolicyNo(rs.getString("POLICY_SLIP_NUMBER"));
				tempUob.setBsnName(rs.getString("BSN_NAME"));
				tempUob.setBranch(rs.getString("BRANCH_NAME"));
				tempUob.setReqId(rs.getString("REQUESTOR_ID"));
				tempUob.setReqName(rs.getString("REQ_NAME"));
				tempUob.setInsuredName(rs.getString("INSURED_NAME"));
				tempUob.setQq(rs.getString("QQ_1"));
				tempUob.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				tempUob.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tempUob.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tempUob.setPremiGross(rs.getBigDecimal("PREMI"));
				tempUob.setPremiAdj(rs.getBigDecimal("PRM_ADJUST"));
				tempUob.setStmp(rs.getBigDecimal("STMP"));
				tempUob.setcPol(rs.getBigDecimal("C_POL"));
				tempUob.setJasa(rs.getBigDecimal("JASA"));
				tempUob.setComm(rs.getBigDecimal("COMM"));
				tempUob.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				tempUob.setTsi(rs.getBigDecimal("SUM_INSURED_IDR"));
				tempUob.setOs(rs.getBigDecimal("OSTD_IDR_PERPOLIS"));
				tempUob.setStatusOs(rs.getString("STATUS_OSTD_IDR_PERPOLIS"));
				tempUob.setOccupationId(rs.getString("OCCUPATION_ID"));
				tempUob.setJenisResiko(rs.getString("JENIS_RISIKO"));
				tempUob.setPertanggungan(rs.getString("STATUS"));
				lbb.add(tempUob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getTender (String dt1, String dt2, String branch, String cob){
		System.out.println("dt1:" + dt1 + "dt2:" + dt2 + "branch:" + branch + "cob:" + cob);
		List lbb = new ArrayList();
		Tender tmpTender = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM TENDER WHERE";
			
			if (!"".equals(dt1) && !"".equals(dt2)){
				System.out.println("masuk sql");
				if (("101".equals(branch) && ("0".equals(cob)))){
					System.out.println("masuk if");
					sql += " INSURANCE_STARTDATE >=? AND INSURANCE_STARTDATE <=?";
				} else if (("101".equals(branch)) && (!"".equals(cob))) {
					System.out.println("masuk else if");
					sql += " INSURANCE_STARTDATE >=? AND INSURANCE_STARTDATE <=? AND BSN_ID = ?";
				} else {
					System.out.println("masuk else");
					sql += " INSURANCE_STARTDATE >=? AND INSURANCE_STARTDATE <=? AND BSN_ID = ? AND BRANCH_ID = ?";
				}
			} 
			
			sql += " ORDER BY INSURANCE_STARTDATE";
			System.out.println("SQL getTender -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			if (!"".equals(dt1) && !"".equals(dt2)){
				if (("101".equals(branch)) && ("0".equals(cob))){
					stat.setString(i++, dt1.trim());
					stat.setString(i++, dt2.trim());
				} else if (("101".equals(branch)) && (!"".equals(cob))){
					stat.setString(i++, dt1.trim());
					stat.setString(i++, dt2.trim());
					stat.setString(i++, cob.trim());
				} else {
					stat.setString(i++, dt1.trim());
					stat.setString(i++, dt2.trim());
					stat.setString(i++, cob.trim());
					stat.setString(i++, branch.trim());
				}
			}
						
			rs = stat.executeQuery();
			while (rs.next()) {
				tmpTender = new Tender();
				tmpTender.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tmpTender.setBranchId(rs.getString("BRANCH_NAME"));
				tmpTender.setReqType(rs.getString("REQUESTOR_TYPE"));
				tmpTender.setReqName(rs.getString("REQUESTOR_NAME"));
				tmpTender.setInsuredName(rs.getString("INSURED_NAME"));
				tmpTender.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tmpTender.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tmpTender.setShareAswata(rs.getString("SHARE_ASWATA"));
				tmpTender.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				tmpTender.setPremiNett(rs.getBigDecimal("PREMI_NET"));
				tmpTender.setPremiGross(rs.getBigDecimal("PREMI_GROSS"));
				lbb.add(tmpTender);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
}
