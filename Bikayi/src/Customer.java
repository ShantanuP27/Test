import java.sql.*;
import java.io.*;

public class Customer {

	public static void main(String[] args)throws IOException {
		Connection con;
		Statement st;
			
		String cname,email,city;
		int mno;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Enter Customer name : ");
		cname=br.readLine();
		System.out.println("Enter Email id : ");
		email=br.readLine();		
		System.out.println("Enter Mobile number : ");
		mno=Integer.parseInt(br.readLine());		
		System.out.println("Enter City : ");
		city=br.readLine();
		
		
		String sql = "insert into customer(name,email,mobileno,city) values('"+cname+"','"+email+"',"+mno+",'"+city+"')";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","root");
			st=con.createStatement();
			st.executeUpdate(sql);
			System.out.println(" Data Added successfully. ");
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
