package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {
	
	public static Magazine map(ResultSet result) throws SQLException {
		
		
		try {
		int id = result.getInt("id");
		String name = result.getString("name");
		String description = result.getString("description");
		double price = result.getDouble("price");
		String isbn = result.getString("isbn");	
		
		return new Magazine(id, name, description, price, isbn);
		} catch (java.sql.SQLException e) {
			System.out.println("no data");
		}
		
		return null;
	}

}
