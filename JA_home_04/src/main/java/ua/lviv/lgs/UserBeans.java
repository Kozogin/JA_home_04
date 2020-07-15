package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBeans {
	
	UserService userService;
	UsersDao usersDao;
	MagazineDao magazineDao;
	MagazineUsersDao magazineUsersDao;	
	private List<Magazine> users;
	
	public UserBeans() {
		this.userService = UserService.getUserService();;
		try {
			this.usersDao = new UsersDao(ConectionUtils.openConnection());
			this.magazineDao = new MagazineDao(ConectionUtils.openConnection());
			this.magazineUsersDao = new MagazineUsersDao(ConectionUtils.openConnection());			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		users = new ArrayList<>();
		
	}
	
	
	
	
	

}
