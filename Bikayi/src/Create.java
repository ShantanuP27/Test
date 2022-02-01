import java.sql.*;
import java.io.*;

public class Create {

	public static void main(String[] args)throws IOException {
		Connection con;
		Statement st;

		String sql1 = "create table customer(cid int primary key auto_increment,name varchar(40),email varchar(30),mobileno int,city varchar(20))";
		String sql2 = "create table purchase(cid int,pid int primary key auto_increment,pname varchar(40),quantity int,pricing int,MRP int)";
		String sql3 = "create table shipping(cid int,pid int,address varchar(50),city varchar(20),pincode int)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","root");
			st=con.createStatement();
	
			st.execute(sql1);
			System.out.println(" Table created successfully. ");
			st.execute(sql2);
			System.out.println(" Table created successfully. ");
			st.execute(sql3);
			System.out.println(" Table created successfully. ");
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
