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
import com.aswata.report.entity.cancelPolicy;
import com.aswata.report.entity.cimbNiaga;
import com.aswata.report.entity.loginReport;
import com.aswata.report.entity.loginReport2;
import com.aswata.report.entity.populasi;
import com.aswata.report.entity.target;
import com.aswata.singleton.DatasourceEntry;

/**
 * @author Tri Wahyudi
 *
 */
public class sqlFunctionAudit {
	private static Logger log = Logger.getLogger(sqlFunctionAudit.class);
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
	
	public List getPopulasiAcc (String dt1, String dt2, String branch){
		System.out.println("dt1:" + dt1 + "dt2:" + dt2 + "branch:" + branch);
		List lbb = new ArrayList();
		populasi TempPop = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM REQUESTOR_HAHP WHERE TRANSACTION_DATE >= ? AND TRANSACTION_DATE <=? AND BRANCH_ID = ? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getPopulasiAcc -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			stat.setString(i++, branch.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				TempPop = new populasi();
				TempPop.setTransactionDate(rs.getString("TRANSACTION_DATE"));
				TempPop.setPolicyNo(rs.getString("NOMOR_POLIS"));
				TempPop.setBranchId(rs.getString("BRANCH_ID"));
				TempPop.setCob(rs.getString("COB"));
				TempPop.setQqName(rs.getString("NAMA_TERTANGGUNG"));
				TempPop.setReqName(rs.getString("REQUESTOR_NAME"));
				TempPop.setSegment(rs.getString("CORPORATE_RETAIL"));
				TempPop.setReqType(rs.getString("ACC_TYPE"));
				TempPop.setBusType(rs.getString("BUSINESS_TYPE"));
				TempPop.setEffDate(rs.getString("EFFECTIVE_DATE"));
				TempPop.setMaturityDate(rs.getString("MATURITY_DATE"));
				TempPop.setShare(rs.getString("SHARE_PCT"));
				TempPop.setCurr(rs.getString("CURRENCY_CODE"));
				TempPop.setTsi(rs.getBigDecimal("TSI"));
				TempPop.setPremiOri(rs.getBigDecimal("PREMI_ORIGINAL"));
				lbb.add(TempPop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	public List getCancelPolicy (String dt1, String dt2, String branch){
		System.out.println("dt1:" + dt1 + "dt2:" + dt2 + "branch:" + branch);
		List lbb = new ArrayList();
		cancelPolicy TempCancel = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			conn = DatasourceEntry.getInstance().getPostgreDWHDS().getConnection();
			sql = "SELECT * FROM POLICY_CANCEL WHERE TRANSACTION_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND BRANCH_ID = ? ORDER BY TRANSACTION_DATE";
			System.out.println("SQL getCancelPolicy -->" + sql);
			int i = 1;
			stat = conn.prepareStatement(sql);
			stat.setString(i++, dt1.trim());
			stat.setString(i++, dt2.trim());
			stat.setString(i++, branch.trim());
			rs = stat.executeQuery();
			while (rs.next()) {
				TempCancel = new cancelPolicy();
				TempCancel.setTrnDate(rs.getString("TRANSACTION_DATE"));
				TempCancel.setPolicyNo(rs.getString("POLICY_SLIP_NUMBER"));
				TempCancel.setDocNumber(rs.getString("DOCUMENT_NUMBER"));
				TempCancel.setBranch(rs.getString("BRANCH_ID"));
				TempCancel.setCob(rs.getString("COB"));
				TempCancel.setReqName(rs.getString("REQUESTOR_NAME"));
				TempCancel.setInsuredName(rs.getString("INSURED_NAME"));
				TempCancel.setBusType(rs.getString("BUSINESS_TYPE"));
				TempCancel.setEffectiveDate(rs.getString("EFFECTIVE_DATE"));
				TempCancel.setExpiredDate(rs.getString("EXPIRED_DATE"));
				TempCancel.setEndorseCreatedDate(rs.getString("ENDORSE_CREATED_DATE"));
				TempCancel.setEffectiveEndorseDate(rs.getString("EFFECTIVE_ENDORSE_DATE"));
				TempCancel.setShare(rs.getString("SHARE_PCT"));
				TempCancel.setCcy(rs.getString("CURRENCY_CODE"));
				TempCancel.setTsi(rs.getBigDecimal("TSI_IN_IDR"));
				TempCancel.setAmtOri(rs.getBigDecimal("AMOUNT_ORIGINAL"));
				TempCancel.setAmtBase(rs.getBigDecimal("AMOUNT_BASE"));
				lbb.add(TempCancel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnDB(conn, stat, rs);
		} return lbb;
	}
	
	
}
