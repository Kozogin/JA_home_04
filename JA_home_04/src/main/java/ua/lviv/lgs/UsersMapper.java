package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper {
	
	public static Users map(ResultSet result) throws SQLException {
		
		int id = 0;
		String userName = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String details = null;	
		
		try {
		 id = result.getInt("id");
		 userName = result.getString("username");
		 password = result.getString("password");
		 firstName = result.getString("first_name");
		 lastName = result.getString("last_name");
		 details = result.getString("details");
		} catch (java.sql.SQLException e) {
			System.out.println("no data");
		}
		return new Users(id, userName, password, firstName, lastName, details);	
		
	}

}
