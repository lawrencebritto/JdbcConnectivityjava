package Practice;
import java.sql.*;
import java.io.*;
public class Connect {
	public static void main(String[] args)
	{
		Connection con=null;
		try
		{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtrial","root","Kumar0573@");
		if(con!=null)
		{
			System.out.println("Connection Established");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
		try
		{
			con.close();
			System.out.println("Now Connection Terminated");
		}catch(Exception e){}
		}
	}
}
