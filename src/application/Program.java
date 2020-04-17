package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			int rows1 = st.executeUpdate("update seller set BaseSalary = 2090 where DepartmentId = 1");
					
			int rows2 = st.executeUpdate("update seller set BaseSalary = 3090 where DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("rows1 =" + rows1);
			System.out.println("rows2 =" + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by :" + e.getMessage());
				
			} catch (SQLException e1) {
				
				throw new DbException("Error try to rollback! Caused by " + e.getMessage());
			}
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
