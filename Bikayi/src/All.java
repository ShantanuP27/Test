import java.sql.*;
import java.io.*;

public class All {

	public static void main(String[] args)throws IOException {
		Connection con;
		Statement st;
		ResultSet rs; 
		
		String sql = "select * from customer,purchase,shipping ";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","shantanu");
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getString(8)+" "+rs.getInt(9)+" "+rs.getInt(10)+" "+rs.getInt(11)+" "+rs.getInt(12)+" "+rs.getInt(13)+" "+rs.getString(14)+" "+rs.getString(15)+" "+rs.getInt(16));
			}
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
