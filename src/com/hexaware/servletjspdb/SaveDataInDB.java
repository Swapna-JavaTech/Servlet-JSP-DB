package com.hexaware.servletjspdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexaware.servletjspdb.helper.DBConnection;

/**
 * Servlet implementation class SaveDataInDB
 */
@WebServlet("/SaveDataInDB")
public class SaveDataInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			conn = DBConnection.getDBConnection();
			try {
				PrintWriter pw = resp.getWriter();
				resp.setContentType("text/html");
				if(conn==null) {
					pw.println("no connection established..");
				}
				pstmt= conn.prepareStatement("insert into student values(?,?,?)");
				
				int stdid =  Integer.parseInt(req.getParameter("sid"));
				String stdname = req.getParameter("sname");
				int stdage =  Integer.parseInt(req.getParameter("sage"));
				pstmt.setInt(1, stdid);
				pstmt.setString(2, stdname);
				pstmt.setInt(3, stdage);
				int i = pstmt.executeUpdate();
				if(i!=0) {
					pw.println("student added successfully....");
				}else {
					pw.println("student not added due to error...");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

}
