package com.aswata.singleton;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DatasourceEntry {

	private static Logger logger = Logger.getLogger(DatasourceEntry.class);
    private static DatasourceEntry log = null;
    private DataSource postgreDS = null;
    private DataSource oracleDS = null;
    private DataSource postgreDWHDS = null;
    
    public DatasourceEntry() {
    }

    public static DatasourceEntry getInstance() {
        if (log == null) {
            log = new DatasourceEntry();
        }

        return log;
    }
    
	public DataSource getPostgreDS() {
		return postgreDS;
	}
	public void setPostgreDS(DataSource postgreDS) {
		this.postgreDS = postgreDS;
	}
	public DataSource getOracleDS() {
		return oracleDS;
	}
	public void setOracleDS(DataSource oracleDS) {
		this.oracleDS = oracleDS;
	}

	/**
	 * @return the postgreDWHDS
	 */
	public DataSource getPostgreDWHDS() {
		return postgreDWHDS;
	}

	/**
	 * @param postgreDWHDS the postgreDWHDS to set
	 */
	public void setPostgreDWHDS(DataSource postgreDWHDS) {
		this.postgreDWHDS = postgreDWHDS;
	}
    
	
    
}
