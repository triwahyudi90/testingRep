package com.aswata.database.process;

public interface ProcessOnDatabase {
	public String login2Mcb(String username, String password, int level);
    public String getAllowedRoles(int level) ;

}
