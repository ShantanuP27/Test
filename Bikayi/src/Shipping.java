import java.sql.*;
import java.io.*;

public class Shipping {

	public static void main(String[] args)throws IOException {
		Connection con;
		PreparedStatement st;
		Statement stt;
		ResultSet rs;
		
		String address;
		int pincode,pid;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Enter Address : ");
		address=br.readLine();
		System.out.println("Enter Pincode : ");
		pincode=Integer.parseInt(br.readLine());		
		System.out.println("Enter Product ID : ");
		pid=Integer.parseInt(br.readLine());		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","root");
			
			stt=con.createStatement();
			rs = stt.executeQuery( " select cid from purchase where pid = " + pid );
			int cid = rs.getInt(1);
			rs = stt.executeQuery( " select city from customer where cid= " + cid );
			String city = rs.getString(1);
			
			st=con.prepareStatement("insert into shipping(pid,address,pincode,cid,city) values(?,?,?,?,?)");
			
			boolean f=st.execute("select pid from purchase");
			if(f==true) {
	
				st.setInt(1,pid);
				st.setString(2,address);
				st.setInt(3,pincode);
				st.setInt(4,cid);
				st.setString(5,city);
				
				st.executeUpdate();
				System.out.println(" Data Added successfully. ");
			}else {
				System.out.println(" Purchase not found ");
			}	
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

