//DON'T RUN THIS WITHOUT ALTERING VALUES
package Practice;
import java.sql.*;
public class InsertData {
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtrial","root","Kumar0573@");
			if(con!=null)
			{
				System.out.println("Connection Established");
			}
			stmt=con.createStatement();
			stmt.executeUpdate("INSERT INTO `dbtrial`.`stdinfo` (`stdid`, `stdname`, `stdage`, `stddomain`) VALUES ('101', 'Lawrence', '21', 'Science')");
			System.out.println("Inserted");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
			stmt.close();
			con.close();
			}catch(Exception e) {}
		}
	}
}
