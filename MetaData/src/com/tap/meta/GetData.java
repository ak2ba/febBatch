package com.tap.meta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class GetData {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet resultSet;
	private static ResultSetMetaData rsmd;
	private static PreparedStatement pstmt;
	
	private static final String INSERTDATA = "INSERT INTO `EMPLOYEE`(`ID`,`DESG`,`EMPNAME`,`SALARY`) VALUES(?,?,?,?)";
	public static void main(String[] args) {
		int sum=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HIBERNATEJEE", "root", "root");
			pstmt = con.prepareStatement(INSERTDATA);
			
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			
			for(int i=1; i<=2; i++)
			{
				System.out.print("Enter the ID : ");
				int id = sc1.nextInt();
				System.out.print("Enter the Desg : ");
				String desg = sc2.nextLine();
				System.out.print("Enter the Name : ");
				String name = sc2.nextLine();
				System.out.print("Enter the Salary : ");
				int salary = sc1.nextInt();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, desg);
				pstmt.setString(3, name);
				pstmt.setInt(4, salary);
				
				pstmt.addBatch();
				System.out.println(i+" query added to batch");
			}
			pstmt.executeBatch();
			System.out.println("Batch Executed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}










