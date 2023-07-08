package dao;

import model.Login;
import java.sql.*;
import connectionManager.ConnectionManager;
public class LoginDAO {
	
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		//user input
		String username = login.getUsername();
		String password = login.getPassword();
		
		//connect user input
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		//Statement class --> create, update,delete,get
		Statement st = con.createStatement();
		
		//ResultSet class ---> (default predefined created)
		ResultSet rs = st.executeQuery("select * from login");
		
		//check username and password
		while(rs.next())
		{
		if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
				{
			conm.closeConnection();
		       	return true;
			
				}
		}
		//else
		{
			conm.closeConnection();
			return false;
		}
		
				
	}

}
