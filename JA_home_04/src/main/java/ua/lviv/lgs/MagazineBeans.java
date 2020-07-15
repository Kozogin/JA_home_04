package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineBeans {
	
	private MagazineService magazineService;
	private UsersDao usersDao;
	private MagazineDao magazineDao;
	private MagazineUsersDao magazineUsersDao;	
	private UserLogInServlet userLogInServlet;
	
	private List<Magazine> magazine;
	
	public MagazineBeans() {
		super();
		this.magazineService = new MagazineService();;
		try {
			this.usersDao = new UsersDao(ConectionUtils.openConnection());
			this.magazineDao = new MagazineDao(ConectionUtils.openConnection());
			this.magazineUsersDao = new MagazineUsersDao(ConectionUtils.openConnection());
			userLogInServlet = new UserLogInServlet();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		magazine = new ArrayList<>();
		
	}	
	
	public void readLimitMagazine(int num, int allVizible) {
		
			try {
				magazine = magazineService.getMagazine(magazineDao, num, allVizible);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
	}
	
	public String readNameMagazine(int num) {		
		try {
			return magazine.get(num).getName();	
		} catch (java.lang.IndexOutOfBoundsException e) {			
		}
		return null;
	}
	
	public String readIsbnMagazine(int num) {		
		try {
			return magazine.get(num).getIsbn();	
		} catch (java.lang.IndexOutOfBoundsException e) {			
		}
		return null;
	}
	
	public String readDescriptionMagazine(int num) {		
		try {
			return magazine.get(num).getDescription();	
		} catch (java.lang.IndexOutOfBoundsException e) {			
		}
		return null;
	}	
	
	public String readPriceMagazine(int num) {		
		try {
			return Double.toString(magazine.get(num).getPrice());	
		} catch (java.lang.IndexOutOfBoundsException e) {			
		}
		return null;
	}	
	
	public int countAllMagazine() throws SQLException {
		return magazineService.countAllMagazine(magazineDao);
	}
	
	public boolean visibleCheckBox() {		
		return userLogInServlet.isBoolUserLogIn();
	}

	
		
	
	
}
