package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao implements Dao<Magazine, Integer, List<Magazine>>{
	
	private static String READ_ALL_LIMIT = "select * from magazine limit ?, ?";
	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(name, description, price, isbn) values(?,?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id = ?";
	private static String READ_BY_ISBN = "select * from magazine where isbn = ?";	
	private static String UPDATE_BY_ID = "update magazine set name = ?, description = ?, price = ?, isbn = ? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id = ?";
	private static String COUNT_ALL = "select count(*) as countSumm from magazine";
	
	private Connection connection; 
	private PreparedStatement preparedStatement;
	
	public MagazineDao(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Magazine magazine) throws SQLException {
		try {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, magazine.getName());
		preparedStatement.setString(2, magazine.getDescription());
		preparedStatement.setDouble(3, magazine.getPrice());
		preparedStatement.setString(4, magazine.getIsbn());		
		
		preparedStatement.executeUpdate();
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			
		}
	}
	
	@Override
	public Magazine read(Integer id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MagazineMapper.map(result);		
	}
	
	public Magazine readIsbn(String isbn) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ISBN);
		preparedStatement.setString(1, isbn);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MagazineMapper.map(result);		
	}
	
	@Override
	public void update(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, magazine.getName());
		preparedStatement.setString(2, magazine.getDescription());
		preparedStatement.setDouble(3, magazine.getPrice());
		preparedStatement.setString(4, magazine.getIsbn());	
		preparedStatement.setInt(5, magazine.getId());
		
		preparedStatement.executeUpdate();
	}
	
	@Override
	public void delete(Integer id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);				
		preparedStatement.setInt(1, id);
		try {
			preparedStatement.executeUpdate();
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			
		}
	}
	
	@Override
	public List<Magazine> readAll() throws SQLException {
		List<Magazine> listMagazine = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listMagazine.add(MagazineMapper.map(result));
		}
		return listMagazine;
	}
	
	
	public List<Magazine> readAll(Integer num, Integer all) throws SQLException {
		List<Magazine> listMagazine = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL_LIMIT);
		
		preparedStatement.setInt(1, num);
		preparedStatement.setInt(2, all);		
		
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listMagazine.add(MagazineMapper.map(result));
		}
		return listMagazine;
	}
	
	public int countAllMagazine() throws SQLException {
		preparedStatement = connection.prepareStatement(COUNT_ALL);
		ResultSet result = preparedStatement.executeQuery();
		
		result.next();		
		int count = result.getInt("countSumm");
		return count;		
	}
	

}
