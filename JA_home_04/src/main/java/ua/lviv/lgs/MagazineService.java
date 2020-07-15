package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.List;

public class MagazineService {
	
	public void addMagazine(MagazineDao magazineDao, Magazine magazine){
		try {
			magazineDao.insert(magazine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean boolFindMagazineIsbn(MagazineDao magazineDao, String isbn) {
		try {
			if(isbn != "") {
				return magazineDao.readIsbn(isbn) != null;
			}
		} catch (SQLException e) {
			return false;			
		} catch (NullPointerException e) {
			return false;
		}
		return false;
	}
	
	public List<Magazine> getMagazine(MagazineDao magazineDao, int num, int allVizible) throws SQLException {		
		return magazineDao.readAll(num, allVizible);		
	}
	
	public int countAllMagazine(MagazineDao magazineDao) {
		try {
			return magazineDao.countAllMagazine();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
