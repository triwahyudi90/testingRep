package com.aswata.singleton;

import org.apache.log4j.Logger;

public class ParamSingleton {
	private static Logger logger = Logger.getLogger(ParamSingleton.class);
    private static ParamSingleton log = null;
    private String statusServer;
    
	public String getStatusServer() {
		return statusServer;
	}
	public void setStatusServer(String statusServer) {
		this.statusServer = statusServer;
	}

	public ParamSingleton() {
    }

    public static ParamSingleton getInstance() {
        if (log == null) {
            log = new ParamSingleton();
        }

        return log;
    }
}
