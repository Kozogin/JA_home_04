package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineUsersMapper {
	
	public static MagazineUsers map(ResultSet result) throws SQLException {
		int usersId = result.getInt("users_id");
		int magazineId = result.getInt("magazine_id");
		
		return new MagazineUsers(usersId, magazineId);		
	}

}
