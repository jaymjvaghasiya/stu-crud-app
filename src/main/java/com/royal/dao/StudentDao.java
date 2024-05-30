package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao {
	
	public int insertQry(StudentBean sbean) {
		
		int rowsAffected = 0;
		String qry = "INSERT INTO STUDENTS2(NAME, MARKS, STD) VALUES ('"+sbean.getName()+"', "+sbean.getMarks()+", "+sbean.getStd()+")";
		Connection conn = DBConnection.getDBConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(qry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public int deleteQry(int id) {
		
		int rowsAffected = 0;
		String qry = "DELETE FROM STUDENTS2 WHERE ID = " + id;
		Connection conn = DBConnection.getDBConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(qry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public int updateQry(StudentBean sbean) {
		
		int rowsAffected = 0;
		String qry = "UPDATE STUDENTS2 SET name='"+sbean.getName()+"', marks="+sbean.getMarks()+", std="+sbean.getStd()+" where id="+sbean.getId();
		Connection conn = DBConnection.getDBConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(qry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public ArrayList<StudentBean> displayAllStudents() {
		ArrayList<StudentBean> slist = new ArrayList<StudentBean>();
		String qry = "SELECT * FROM STUDENTS2";
		Connection conn = DBConnection.getDBConnection();
		Statement stmt = null;
		ResultSet r = null;
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(qry);
			
			while(r.next()) {
				int id = r.getInt(1);
				String name = r.getString(2);
				int marks = r.getInt(3);
				int std = r.getInt(4);
				
				StudentBean sbean = new StudentBean(id, marks, std, name);
				slist.add(sbean);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return slist;
	}
	
	public StudentBean displayOneStudent(int id) {
		StudentBean sbean = null;
		String qry = "SELECT * FROM STUDENTS2 WHERE ID = " + id;
		Connection conn = DBConnection.getDBConnection();
		Statement stmt = null;
		ResultSet r = null;
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(qry);
			r.next();
			
			int rno = r.getInt(1);
			String name = r.getString(2);
			int marks = r.getInt(3);
			int std = r.getInt(4);
			
			sbean = new StudentBean(id, marks, std, name);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sbean;
	}
	
}
