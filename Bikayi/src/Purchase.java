import java.sql.*;
import java.io.*;

public class Purchase {

	public static void main(String[] args)throws IOException {
		Connection con;
		Statement st;	
		
		String pname;
		int pricing,mrp,quantity,cid;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Enter Product name : ");
		pname=br.readLine();
		System.out.println("Enter Pricing : ");
		pricing=Integer.parseInt(br.readLine());		
		System.out.println("Enter MRP : ");
		mrp=Integer.parseInt(br.readLine());		
		System.out.println("Enter Quantity : ");
		quantity=Integer.parseInt(br.readLine());
		System.out.println("Enter Customer id : ");
		cid=Integer.parseInt(br.readLine());
		
		
		String sql = "insert into purchase(cid,pname,pricing,mrp,quantity) values("+cid+"'"+pname+"',"+pricing+","+mrp+","+quantity+")";
		if(pricing<mrp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/orders","root","shantanu");
			st=con.createStatement();
			boolean f=st.execute("select cid from customer");
			if(f==true) {
				st.executeUpdate(sql);
				System.out.println(" Data Added successfully. ");
			}else {
				System.out.println(" Customer not found ");
			}	
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}else {
			System.out.println(" Please enter princing value lower than MRP ");
		}
	}
}


