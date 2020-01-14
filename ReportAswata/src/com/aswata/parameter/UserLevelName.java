package com.aswata.parameter;

public class UserLevelName {

	public static String getUserNameLevel(int level){
        if (level == 1) {
            return "Auditor";
        } else if (level == 2) {
            return "Marketing";
        }else if (level == 3) {
            return "Supervisor";
        }else if (level == 4) {
            return "Back Office";
        }else if (level == 5) {
            return "Admin";
        }else if (level == 6) {
            return "Customer Service";
        } else if (level == 7) {
            return "VBO";
        }
        return null;
    }
}
