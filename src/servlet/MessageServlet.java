package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.net.httpserver.HttpServer;
import facilitate.DBhelper;

//参数接受DoctorId(登录时获取保存)
public class MessageServlet extends BackServlet {
	public void Cheek(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/doctor?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		final String USER="root";
		final String PASS="123456";
		Connection conn =null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("loding...........");
			conn=DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Success");
			stmt=conn.createStatement();
			String sql = "SELECT * FROM leavingmessage WHERE DoctorId = 2019";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String message = rs.getString(4);
				PrintWriter out = response.getWriter();
			      out.println("<h1>" + message + "</h1>");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//参数拟定患者ID
	public String[] TreatMent(){
		final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/doctor?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		final String USER="root";
		final String PASS="123456";
		Connection conn =null;
		Statement stmt = null; 
		String []arr =new String[2];
		try{
			int max=10;
			Random random = new Random();
			int s=random.nextInt(max);
			Class.forName(JDBC_DRIVER);
			System.out.println("loding...........");
			conn=DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Success");
			stmt=conn.createStatement();
			String sql = "SELECT * FROM treatment WHERE treatId = s";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String Name =rs.getString(1);
				String Price =rs.getString(2);
				arr [0]=Name;
				arr [1]=Price;
			}
			
	}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return arr;
	}
}
