package com.fuel.Util.Employee;

public class CommonCustConstant {
	//table name
		public static String TBL_CUSTOMER ="customers";
				
		//colume names 
		public static String CLM_EMPID = "empID";
		
		public static String CLM_FNAME= "fname";
		
		public static String CLM_LNAME= "lname";
		
		public static String CLM_PHONE = "phone";
		
		public static String CLM_ADDRESS = "address";
		
		public static String CLM_EMAIL = "email";

		
		public static String createCusTable= "CREATE TABLE IF NOT EXISTS "+TBL_CUSTOMER+"( " + 
				CLM_EMPID  + " int NOT NULL AUTO_INCREMENT," + 
				CLM_FNAME  + " varchar(255) NOT NULL," + 
				CLM_LNAME  + " varchar(255) NOT NULL," + 
				CLM_PHONE + " int," + 
				CLM_ADDRESS +" varchar(255) NOT NULL," + 
				CLM_EMAIL + " varchar(255) NOT NULL," +
				" PRIMARY KEY ("+CLM_EMPID+"))";
		
		public static String getCustomerDetails= "SELECT * FROM "+TBL_CUSTOMER;
		
		public static String insertCustomerDetails = "INSERT INTO "+TBL_CUSTOMER+"("+CLM_FNAME+","+CLM_LNAME+", "+CLM_PHONE+", "+CLM_ADDRESS+","+CLM_EMAIL+") VALUES (?,?,?,?,?)";

		public static String getCustomerDetailsByID ="SELECT * FROM "+TBL_CUSTOMER+" WHERE "+CLM_EMPID+"=?";
		
		public static String getCustomerDetailsByEmail ="SELECT * FROM "+TBL_CUSTOMER+" WHERE "+CLM_EMAIL+"=?";
		
		public static String updateCustomerDetails = "UPDATE "+TBL_CUSTOMER+" SET "+CLM_FNAME+"= ?, "+CLM_LNAME+"= ?, "+CLM_PHONE+"=?,"+CLM_ADDRESS+"=?,"+CLM_EMAIL+"=? WHERE "+CLM_EMPID+"=?;";

		public static String deleteCustomerDetails = "DELETE FROM "+TBL_CUSTOMER+" WHERE "+CLM_EMPID+"=? ";
		


}
