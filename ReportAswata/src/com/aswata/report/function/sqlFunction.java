/**
 * 
 */
package com.aswata.report.function;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataSource;

import org.apache.log4j.Logger;

import com.aswata.report.entity.AswataReportDesc;
import com.aswata.report.entity.Branch;
import com.aswata.report.entity.Bsn;
import com.aswata.report.entity.DashBoardPremi;
import com.aswata.report.entity.DashboardRiskProfile;
import com.aswata.report.entity.DashboardTarget;
import com.aswata.report.entity.Role;
import com.aswata.report.entity.RoleMenu;
import com.aswata.report.entity.RoleSubMenu;
import com.aswata.report.entity.RptOpt;
import com.aswata.report.entity.cimbNiaga;
import com.aswata.report.entity.client;
import com.aswata.report.entity.loginReport;
import com.aswata.report.entity.loginReport2;
import com.aswata.report.entity.target;
import com.aswata.singleton.DatasourceEntry;

/**
 * @author Tri Wahyudi
 *
 */
public class sqlFunction {
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
	
	public loginReport getLogin (String user, String pass){
		System.out.println("sql user:" + user + "pass:" + pass);
		loginReport login = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		try {
			System.out.println("masuk try");
			conn = DatasourceEntry.getInstance().getOracleDS().getConnection();
			sql = "SELECT USERNAME, PASSWORD FROM M_USERS WHERE USERNAME = ?";
			System.out.println("sql:" + sql);
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.toString());
			rs = stat.executeQuery();
			
			if(rs.next()){
				login = new loginReport();
				login.setUserName(rs.getString("USERNAME"));
				login.setPassword(rs.getString("PASSWORD"));
				System.out.println("");
			}
		} catch (Exception e) {
			log.error("getLogin :" + e.getMessage());
		} finally {
			closeConnDB(conn, stat, rs);
		}
		return login;
	}
	
	public loginReport2 getLogin2 (String user){
		System.out.println("sql user:" + user);
		loginReport2 login = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DatasourceEntry.getInstance().getPostgreDS().getConnection();
			sql = "SELECT USER_ID, GROUP_ID FROM M_USERS WHERE USER_ID = ?";
			System.out.println("sql:" + sql);
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.toString());
			rs = stat.executeQuery();
			
			if(rs.next()){
				login = new loginReport2();
				login.setuserId(rs.getString("USER_ID"));
				login.setRole(rs.getString("GROUP_ID"));
			}
		} catch (Exception e) {
			log.error("getLogin2 :" + e.getMessage());
		} finally {
			closeConnDB(conn, stat, rs);
		}
		return login;
	}
	
	public loginReport2 getLogin3 (String user, String pass, String role){
		System.out.println("sql user:" + user + "pass:" + pass + "role:" + role);
		loginReport2 login = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DatasourceEntry.getInstance().getPostgreDS().getConnection();
			sql = "SELECT USER_ID, PASSWORD, GROUP_ID FROM M_USERS WHERE USER_ID = ?";
			System.out.println("sql:" + sql);
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.toString());
			rs = stat.executeQuery();
			
			if(rs.next()){
				login = new loginReport2();
				login.setuserId(rs.getString("USER_ID"));
				login.setPassword(rs.getString("PASSWORD"));
				login.setRole(rs.getString("GROUP_ID"));
			}
		} catch (Exception e) {
			log.error("getLogin3 :" + e.getMessage());
		} finally {
			closeConnDB(conn, stat, rs);
		}
		return login;
	}
	
	public boolean getMenuStatus(List argGroup, String argAction) {
		boolean menu = false;
		Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        String sql = "";
        
        System.out.println("argGroup" + argGroup);
        try {
	    	conn = DatasourceEntry.getInstance().getPostgreDS().getConnection();
			sql = "select count(*) as jumlah from access_role a,menufunc b,menuhdr c"
				+" where a.func_id = b.func_id and b.hdr_id = c.hdr_id and a.group_id in (?) and b.func_act like '%"+ argAction+"%' ";
			System.out.println("sql role :" + sql);
	        stat = conn.prepareStatement(sql);
	        
	        rs = stat.executeQuery();
	        if (rs.next()) {
	        	int total = rs.getInt("jumlah");
	        	if (total > 0){
	        		menu = true;
	        	}
	        }
        
		} catch (SQLException ex) {
	        log.error(" getMenuStatus :1: " + ex.getMessage());
	    } catch (Exception ex2) {
	        log.error(" getMenuStatus2 :2: " + ex2.getMessage());
	    } finally {
	    	closeConnDB(conn, stat, rs);
	    }
        return menu;
	}
	
	public List getRole(String role){
		System.out.println("role:" + role);
		Connection conn = null;
		PreparedStatement stat = null;
        ResultSet rs = null;
        String sql = "";
//        String subSQL = "(";
        ArrayList header = new ArrayList();
        
        try{
//        	Iterator it = role.iterator();
//        	while (it.hasNext()) {
//            	subSQL = subSQL +"'"+it.next()+"'"+",";
//        	}
//        	subSQL = subSQL.substring(0,subSQL.length()-1)  + ")";	
//        	System.out.println("subSQL=" + subSQL);
        	
        	conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "select distinct b.func_name,b.func_act, c.hdr_name, b.desc_func from access_role a,menufunc b,menuhdr c"
				+" where a.func_id = b.func_id and b.hdr_id = c.hdr_id and a.group_id in (?) order by c.hdr_name,b.desc_func";
        	
			System.out.println("sql:" + sql);
			stat = conn.prepareStatement(sql);
			stat.setString(1, role.toString());
			
			String headerName = "";
            String subHeaderName = "";
            
            Role rl = null;
            RoleMenu roleMenu = new RoleMenu();
            RoleSubMenu roleSubMenu = new RoleSubMenu();
            ArrayList subHeader = new ArrayList();
            ArrayList detail = new ArrayList();
            
            rs = stat.executeQuery();
            while (rs.next()) {
            	rl = new Role();
	            rl.setFunc_nm(rs.getString("func_name"));
	            rl.setFunc_act(rs.getString("func_act"));
	            rl.setHdr_nm(rs.getString("hdr_name"));
	            rl.setDesc_func(rs.getString("desc_func"));
	            if(!(subHeaderName.equals(rs.getString("desc_func"))) && !("".equals(subHeaderName))) {
	           	   roleSubMenu = new RoleSubMenu();
	           	   System.out.println("subHeaderName3:" + subHeaderName);
	           	   roleSubMenu.setSubMenu(subHeaderName);
	           	   roleSubMenu.setDetail(detail);
	           	   subHeader.add(roleSubMenu);
	           	   detail = new ArrayList();
	            }
	            detail.add(rl);
	               if(!(headerName.equals(rs.getString("hdr_name"))) && !("".equals(headerName))) {
	            	   roleMenu = new RoleMenu();
	            	   System.out.println("hdr_nm:" + headerName);
	            	   System.out.println("subHeaderName:" + subHeaderName);
	            	   roleMenu.setHeaderName(headerName);
	            	   roleMenu.setSubSubMenu(subHeader);
	            	   header.add(roleMenu);
	            	   subHeader = new ArrayList();
	            	   roleSubMenu = new RoleSubMenu();
	               }
	               headerName = rs.getString("hdr_name");
	               subHeaderName = rs.getString("desc_func");
            }
            if(!("".equals(headerName))){
            	roleSubMenu = new RoleSubMenu();
            	roleSubMenu.setDetail(detail);
            	roleSubMenu.setSubMenu(subHeaderName);
            	System.out.println("hdr_nm2:" + headerName);
            	System.out.println("subHeaderName2:" + subHeaderName);
            	subHeader.add(roleSubMenu);
            	roleMenu = new RoleMenu();
            	roleMenu.setHeaderName(headerName);
            	roleMenu.setSubSubMenu(subHeader);
            	header.add(roleMenu);
            }
            } catch (SQLException ex) {
                log.error(" getRole :1: " + ex.getMessage());
            } catch (Exception ex2) {
                log.error(" getRole2 :2: " + ex2.getMessage());
            } finally {
            	closeConnDB(conn, stat, rs);
            }
        return header;
	}
	
	public AswataReportDesc stsDisplay(String filename) {
		System.out.println("masuk stsdisplay:" + filename);
		AswataReportDesc rep = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = DatasourceEntry.getInstance().getPostgreDS().getConnection();
			sql = "SELECT PERIOD, FILENAME, DESCRIPTION, STATUS_REPORT  FROM ASWATA_REPORT where filename = ? and PERIOD = ?";
			System.out.println("sql stsdisplay:" + sql);
			stat = conn.prepareStatement(sql);
			stat.setString(1, filename);
			rs = stat.executeQuery();
			if (rs.next()) {
				rep= new AswataReportDesc();
				rep.setFilename(rs.getString("FILENAME"));
				rep.setDesc(rs.getString("DESCRIPTION"));
				rep.setStatus_report(rs.getBoolean("STATUS_REPORT"));
				rep.setPeriode(rs.getString("PERIOD"));
			}
		} catch (SQLException ex) {
			log.error(" stsDisplay : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		}
		return rep;
	}
	
	public List getReportBank (String bank, String dt1, String dt2){
		System.out.println("SQL dt1 -->" + dt1 + "dt2:" + dt2);
		List lbb = new ArrayList();
		AswataReportDesc rep = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT PERIOD, FILENAME, DESCRIPTION, STATUS_REPORT, STATUS FROM ASWATA_REPORT "
					+ " WHERE STATUS = ? AND PERIOD BETWEEN ? AND ? ";
			System.out.println("SQL getReportDesc -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, bank.trim());
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				rep = new AswataReportDesc();
				rep.setBank(rs.getString("STATUS"));
				rep.setPeriode(rs.getString("PERIOD"));
				rep.setFilename(rs.getString("FILENAME"));
				rep.setDesc(rs.getString("DESCRIPTION"));
				rep.setStatus_report(rs.getBoolean("STATUS_REPORT"));
				lbb.add(rep);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public int getDashoardPremi (){
		int totPremi = 0;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT (SUM(PREMI+PRM_ADJUST)/1000000) AS PREMI FROM DS_POLICY_NOTE"
					+ " WHERE TO_CHAR(TRANSACTION_DATE,'YYYY') = TO_CHAR(NOW(),'YYYY')"
					+ " AND BRANCH_ID NOT IN ('0','87','97')";
			System.out.println("SQL getDashoardPremi -->" + sql);
			
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			if (rs.next()) {
				totPremi = rs.getInt("PREMI");
				System.out.println("PREMI:" + totPremi);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeConnDB(conn, stat, rs);
		} return totPremi;
	}
	
	public BigDecimal getDashoardTarget (){
		BigDecimal totTarget = new BigDecimal(0);
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT ROUND(TOTAL / 1000000) AS TOTAL FROM DASHBOARD_TARGET WHERE BULAN = TO_CHAR(NOW(),'MM')";
			System.out.println("SQL getDashoardTarget -->" + sql);

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			if (rs.next()) {
				System.out.println("3");
				totTarget = rs.getBigDecimal("TOTAL");
				System.out.println("target:" + totTarget);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return totTarget;
	}
	
	public int getDashoardRiskProfile (){
		int totRasio = 0;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT SUM(A.CLAIM_AMT) AS CLAIM_AMT, SUM(A.EARNED_PREMIUM_NET) AS EARNED_PREMIUM_NET,"
					+ " (SUM(A.CLAIM_AMT) / SUM(A.EARNED_PREMIUM_NET)) * 100 AS RASIO"
					+ " FROM RISK_PROFILE A LEFT JOIN DS_POLICY_DETAIL B ON A.MAX_BUSREQ = B.BUSREQ_ID";
			System.out.println("SQL getDashoardRiskProfile -->" + sql);

			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			if (rs.next()) {
				totRasio = rs.getInt("RASIO");
				System.out.println("RiskProfile:" + totRasio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return totRasio;
	}
	
	public List getPolisPremi (String branch, String dt1, String dt2){
		System.out.println("getPolisPremi:" + branch + "dt1:" + dt1 + "dt2:" + dt2);
		List lbb = new ArrayList();
		DashBoardPremi premi = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT A.POLICY_SLIP_NUMBER, A.DOCUMENT_NUMBER, A.BRANCH_NAME, B.SEGMENT, B.BUSINESS_CODE, A.TRANSACTION_DATE,"
					+ " B.BUSINESS_TYPE, B.REQUESTOR_TYPE, A.PREMI, A.PRM_ADJUST, A.STMP, A.COMM, A.C_POL, A.JASA, A.PPN"
					+ " FROM DS_POLICY_NOTE A LEFT JOIN DS_POLICY_DETAIL B ON A.POLICY_SLIP_NUMBER = B.POLICY_NUMBER"
					+ " AND A.BRANCH_ID = B.BRANCH_ID WHERE";
					
			if ("101".equals(branch)){
				sql += " A.TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
			} else {
				sql += " A.BRANCH_ID = ? AND A.TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')";
			}

			sql += " ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getPolisPremi -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			
			if ("101".equals(branch)){
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			} else {
				stat.setString(i++, branch.trim());
				stat.setString(i++, dt1.trim());
				stat.setString(i++, dt2.trim());
			}
			rs = stat.executeQuery();
			while (rs.next()) {
				premi = new DashBoardPremi();
				premi.setPolicyNumber(rs.getString("POLICY_SLIP_NUMBER"));
				premi.setDocumentNo(rs.getString("DOCUMENT_NUMBER"));
				premi.setBranchName(rs.getString("BRANCH_NAME"));
				premi.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				premi.setSegment(rs.getString("SEGMENT"));
				premi.setBusinessCode(rs.getString("BUSINESS_CODE"));
				premi.setBusinessType(rs.getString("BUSINESS_TYPE"));
				premi.setReqType(rs.getString("REQUESTOR_TYPE"));
				premi.setPremi(rs.getBigDecimal("PREMI"));
				premi.setPrmAdjust(rs.getBigDecimal("PRM_ADJUST"));
				premi.setStmp(rs.getBigDecimal("STMP"));
				premi.setcPol(rs.getBigDecimal("C_POL"));
				premi.setComm(rs.getBigDecimal("COMM"));
				premi.setJasa(rs.getBigDecimal("JASA"));
				premi.setPpn(rs.getBigDecimal("PPN"));
				lbb.add(premi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getTarget (){
		List lbb = new ArrayList();
		target temPtarget = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM TARGET ORDER BY COB";
			
			System.out.println("sqlTarget:" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				temPtarget = new target();
				temPtarget.setTargetYear(rs.getString("TARGET_YEAR"));
				temPtarget.setRegionalName(rs.getString("REGIONAL_NAME"));
				temPtarget.setBranchName(rs.getString("BRANCH_NAME"));
				temPtarget.setSegment(rs.getString("SEGMENT"));
				temPtarget.setReqType(rs.getString("REQUESTOR_TYPE"));
				temPtarget.setSector(rs.getString("SECTOR"));
				temPtarget.setSalesName(rs.getString("SALES_NAME"));
				temPtarget.setCob(rs.getString("COB"));
				temPtarget.setJan(rs.getBigDecimal("JAN"));
				temPtarget.setFeb(rs.getBigDecimal("FEB"));
				temPtarget.setMar(rs.getBigDecimal("MAR"));
				temPtarget.setApr(rs.getBigDecimal("APR"));
				temPtarget.setMay(rs.getBigDecimal("MAY"));
				temPtarget.setJun(rs.getBigDecimal("JUN"));
				temPtarget.setJul(rs.getBigDecimal("JUL"));
				temPtarget.setAug(rs.getBigDecimal("AUG"));
				temPtarget.setSept(rs.getBigDecimal("SEP"));
				temPtarget.setOct(rs.getBigDecimal("OCT"));
				temPtarget.setNov(rs.getBigDecimal("NOV"));
				temPtarget.setDec(rs.getBigDecimal("DEC"));
				lbb.add(temPtarget);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getDashboardRisk(String year, String month, String bsn, String branch){
		List lbb = new ArrayList();
		DashboardRiskProfile tempRisk = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM RISK_PROFILE_AS_2019 "
					+ " WHERE ACC_YEAR = ? AND ACC_MONTH = ?";
			System.out.println("SQL getDashboardRisk -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, year.trim());
			stat.setString(i++, month.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				tempRisk = new DashboardRiskProfile();
				tempRisk.setRegional(rs.getString("REGIONAL"));
				tempRisk.setBranch(rs.getString("BRANCH"));
				tempRisk.setPolicyNo(rs.getString("POLICY_NUMBER"));
				tempRisk.setBsn(rs.getString("BSN"));
				tempRisk.setReqType(rs.getString("REQUESTOR_TYPE"));
				tempRisk.setReqName(rs.getString("REQUESTOR_NAME"));
				tempRisk.setReqParent(rs.getString("REQUESTOR_PARENT"));
				tempRisk.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				tempRisk.setStartDate(rs.getString("INSURANCE_STARTDATE"));
				tempRisk.setExpiryDate(rs.getString("INSURANCE_EXPIRYDATE"));
				tempRisk.setUrAmt(rs.getBigDecimal("UR_AMT"));
				tempRisk.setAnrAmt(rs.getBigDecimal("ANR_AMT"));
				tempRisk.setGrAmt(rs.getBigDecimal("GR_AMT"));
				tempRisk.setAccMonth(rs.getString("ACC_MONTH"));
				tempRisk.setAccYear(rs.getString("ACC_YEAR"));
				tempRisk.setBusCode(rs.getString("BUSINESS_CODE"));
				tempRisk.setInsName(rs.getString("INSURED_NAME"));
				tempRisk.setSegment(rs.getString("IS_CORPORATE"));
				tempRisk.setTsi(rs.getBigDecimal("TSI"));
				tempRisk.setPremi(rs.getBigDecimal("PREMIUM"));
				tempRisk.setPremiNett(rs.getBigDecimal("PREMIUM_NETT"));
				tempRisk.setPremiGross(rs.getBigDecimal("PREMIUM_GROSS"));
				tempRisk.setSettledAmt(rs.getBigDecimal("SETTLED_AMT"));
				tempRisk.setClaimAmt(rs.getBigDecimal("CLAIM_AMT"));
				tempRisk.setEarnedPremi(rs.getBigDecimal("EARNED_PREMIUM"));
				tempRisk.setEarnedPremiNett(rs.getBigDecimal("EARNED_PREMIUM_NETT"));
				tempRisk.setEarnedPremiGross(rs.getBigDecimal("EARNED_PREMIUM_GROSS"));
				lbb.add(tempRisk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getBsn (){
		List lbb = new ArrayList();
		Bsn cob = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getOracleDS().getConnection();
			sql = "SELECT BSN_ID, NAME, BSN_ID || ' - ' || NAME AS COB FROM M_BUSINESS ORDER BY BSN_ID";
			System.out.println("SQL getBsn -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				cob = new Bsn();
				cob.setBsnId(rs.getString("BSN_ID"));
				cob.setName(rs.getString("NAME"));
				cob.setCob(rs.getString("COB"));
				lbb.add(cob);
			}
		} catch (Exception e) {
			log.error("getBsn :" + e.getMessage());
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getbranch (){
		List lbb = new ArrayList();
		Branch branch = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getOracleDS().getConnection();
			sql = "SELECT * FROM (SELECT TO_CHAR(BRANCH_ID) AS BRANCH_ID, NAME FROM M_BRANCH "
					+ " UNION ALL SELECT '101' AS BRANCH_ID, 'ALL BRANCH' AS NAME FROM DUAL)"
					+ " WHERE BRANCH_ID NOT IN ('-1','71','72','73','74') ORDER BY NAME";
			System.out.println("SQL getbranch -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				branch = new Branch();
				branch.setBranchId(rs.getString("BRANCH_ID"));
				branch.setBranchName(rs.getString("NAME"));
				lbb.add(branch);
			}
		} catch (Exception e) {
			log.error("getbranch :" + e.getMessage());
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getClient (){
		List lbb = new ArrayList();
		client tmpClient = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getOracleDS().getConnection();
			sql = "SELECT CLIENT_ID,NAME,TYPE,PARENT_ID FROM M_CLIENT WHERE PARENT_ID IS NULL AND TYPE NOT IN ('0','7')";
			System.out.println("SQL getClient -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				tmpClient = new client();
				tmpClient.setClientId(rs.getString("CLIENT_ID"));
				tmpClient.setName(rs.getString("NAME"));
				tmpClient.setType(rs.getString("TYPE"));
				tmpClient.setParentId(rs.getString("PARENT_ID"));
				lbb.add(tmpClient);
			}
		} catch (Exception e) {
			log.error("getClient :" + e.getMessage());
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getRpt (){
		List lbb = new ArrayList();
		RptOpt rpt = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM RPT_OPT_MKT ORDER BY RPT_ID";
			System.out.println("SQL getRpt -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				rpt = new RptOpt();
				rpt.setRptId(rs.getInt("RPT_ID"));
				rpt.setRptDesc(rs.getString("RPT_DESC"));
				lbb.add(rpt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	
}
