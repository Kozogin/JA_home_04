package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.List;

public class MagazineUserServise {
		
	public void addSubscriptionMagazine(MagazineUsersDao magazineUsersDao, int userId, int magazineId) {
		try {
			magazineUsersDao.insert(new MagazineUsers(userId, magazineId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeSubscriptionMagazine(int userId, List<Magazine> magazineList, MagazineUsersDao magazineUsersDao) {
		for (Magazine magazine : magazineList) {
			try {
				magazineUsersDao.delete(userId, magazine.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
