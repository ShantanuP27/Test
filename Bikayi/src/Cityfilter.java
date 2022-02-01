import java.sql.*;
import java.io.*;

public class Cityfilter {

	public static void main(String[] args)throws IOException {
		Connection con;
		Statement st;
		ResultSet rs; 
		
		String city;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Enter City name : ");
		city=br.readLine();

		
		String sql = "select * from shipping where city = ' "+city+ " ' ";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","shantanu");
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
			}
			rs.close();
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
