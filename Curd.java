//Don't run
package Practice;
import java.sql.*;
public class Curd {
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
		/*stmt.execute("CREATE TABLE `dbtrial`.`std` (\r\n"
		+ "  `idstd` INT NOT NULL,\r\n"
		+ "  `stdcol` VARCHAR(45) NOT NULL,\r\n"
		+ "  `stdnam` VARCHAR(45) NOT NULL,\r\n"
		+ "  PRIMARY KEY (`idstd`));");*/
		stmt.executeUpdate("UPDATE `dbtrial`.`stdinfo` SET `stdage` = '22' WHERE (`stdid` = '101')");
		System.out.println("Updated row 1 age = 22");
		stmt.executeUpdate("DELETE FROM `dbtrial`.`stdinfo` WHERE (`stdid` = '102')");
		System.out.println("Row 2 Deleted");
		stmt.executeUpdate("INSERT INTO `dbtrial`.`stdinfo` (`stdid`, `stdname`, `stdage`, `stddomain`) VALUES ('103', 'Yuvi', '21', 'English')");
		System.out.println("Row 3 Inserted");
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
