package ua.lviv.lgs;

import java.sql.SQLException;

public class UserService {
	
	private static UserService userService;
	private UsersDao usersDao;
	//private static MagazineDao magazineDao;
	
	//MagazineUsersDao magazineUsersDao = new MagazineUsersDao(ConectionUtils.openConnection());
	
	private UserService() {		
	}
	
	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();			
		}
		return userService;
	}
	
	public void addUser(UsersDao usersDao, Users user) {		
			try {
				usersDao.insert(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	public Users findUser(UsersDao usersDao, String userName) {
		try {
			if(userName != "") {
				return usersDao.read(userName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean boolFindUser(UsersDao usersDao, String userName) {
		try {
			if(userName != "") {
				return usersDao.read(userName).getUserName().equals(userName);
			}
		} catch (SQLException e) {
			return false;			
		} catch (java.lang.NullPointerException e) {
			return false;
		}
		return false;
	}	
	
	
	public boolean boolUserPassword(UsersDao usersDao, String userName, String password) {
		try {
			if(boolFindUser(usersDao, userName)) {
				return usersDao.read(userName).getPassword().equals(password);
			}
		} catch (SQLException e) {
			return false;
		} catch (java.lang.NullPointerException e) {
			return false;
		}
		
		return false;
	}
	
	
}
