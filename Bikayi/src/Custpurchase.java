import java.sql.*;
import java.io.*;

public class Custpurchase {

	public static void main(String[] args)throws IOException {
		Connection con;
		Statement st;
		ResultSet rs; 
		
		String sql = "select * from customer left outer join purchase on customer.cid = purchase.cid ";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","shantanu");
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getString(8)+" "+rs.getInt(9)+" "+rs.getInt(10)+" "+rs.getInt(11));
			}
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
