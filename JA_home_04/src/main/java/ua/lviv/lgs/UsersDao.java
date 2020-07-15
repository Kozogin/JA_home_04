package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao implements Dao<Users, String, List<Users>>{
	
	private static String READ_ALL = "select * from users";
	private static String CREATE = "insert into users(username, password, first_name, last_name, details) values(?,?,?,?,?)";
	private static String READ_BY_USER_NAME = "select * from users where username = ?";
	private static String UPDATE_BY_USER_NAME = "update users set password = ?, first_name = ?, last_name = ?, details = ? where username = ?";
	private static String DELETE_BY_USER_NAME = "delete from users where username = ?";
	
	private Connection connection; 
	private PreparedStatement preparedStatement;
	
	public UsersDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Users users) throws SQLException {
		try {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, users.getUserName());
		preparedStatement.setString(2, users.getPassword());
		preparedStatement.setString(3, users.getFirstName());
		preparedStatement.setString(4, users.getLastName());
		preparedStatement.setString(5, users.getDetails());
		preparedStatement.executeUpdate();
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {			
		}
	}
	
	@Override
	public Users read(String users) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_USER_NAME);
		preparedStatement.setString(1, users);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return UsersMapper.map(result);		
	}
	
	@Override
	public void update(Users users) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_USER_NAME);		
		preparedStatement.setString(1, users.getPassword());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getDetails());	
		preparedStatement.setString(5, users.getUserName());
		
		preparedStatement.executeUpdate();
	}
	
	@Override
	public void delete(String users) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_USER_NAME);				
		preparedStatement.setString(1, users);
		preparedStatement.executeUpdate();
	}
	
	public List<Users> readAll() throws SQLException {
		List<Users> listUsers = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listUsers.add(UsersMapper.map(result));
		}
		return listUsers;
	}

}
