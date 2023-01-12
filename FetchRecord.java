package Practice;
import java.sql.*;
public class FetchRecord {
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtrial","root","Kumar0573@");
		if(con!=null)
		{
			System.out.println("Connection Established");
		}
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM dbtrial.stdinfo");
		while(rs.next())
		{
			Integer stdid=rs.getInt(1);
			String stdname=rs.getString(2);
			Integer stdage=rs.getInt(3);
			String stddomain=rs.getString(4);
			System.out.println(stdid+" "+stdname+" "+stdage+" "+stddomain);
		}
		rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				stmt.close();
				con.close();
				System.out.print("Connection Terminated");
			}catch(Exception e)
			{}
		}
	}
}
