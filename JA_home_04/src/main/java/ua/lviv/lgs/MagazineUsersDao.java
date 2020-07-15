package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineUsersDao {
	
	private static String READ_ALL = "select * from magazine_users";
	private static String CREATE = "insert into magazine_users(users_id, magazine_id) values(?,?)";	
	private static String DELETE = "delete from magazine_users where users_id = ? and magazine_id = ?";
	private static String DELETE_ALL_MAGAZINE = "delete from magazine_users where magazine_id = ?";
	
	private Connection connection; 
	private PreparedStatement preparedStatement;
	
	public MagazineUsersDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(MagazineUsers magazineUsers) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		try {
		preparedStatement.setInt(1, magazineUsers.getUsersId());
		preparedStatement.setInt(2, magazineUsers.getMagazineId());				
		
		preparedStatement.executeUpdate();	
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("Data repeat");;
		}
	}	
	
	public void delete(int userId, int magazine_id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(DELETE);				
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, magazine_id);
		 
		preparedStatement.executeUpdate();		
	}
	
	public void deleteAllMagazine(int magazine_id) throws SQLException {
		
		preparedStatement = connection.prepareStatement(DELETE_ALL_MAGAZINE);
		preparedStatement.setInt(1, magazine_id);
		preparedStatement.executeUpdate();		
	}
	
	public List<MagazineUsers> readAll() throws SQLException {
		List<MagazineUsers> listMagazineUsers = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listMagazineUsers.add(MagazineUsersMapper.map(result));
		}
		return listMagazineUsers;
	}

}
