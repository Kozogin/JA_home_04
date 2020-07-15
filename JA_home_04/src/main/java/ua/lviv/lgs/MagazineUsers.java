package ua.lviv.lgs;

public class MagazineUsers {
	
	private int usersId;
	private int magazineId;
	
	public MagazineUsers(int usersId, int magazineId) {
		super();
		this.usersId = usersId;
		this.magazineId = magazineId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(int magazineId) {
		this.magazineId = magazineId;
	}

	@Override
	public String toString() {
		return "MagazineUsers [usersId=" + usersId + ", magazineId=" + magazineId + "]";
	}
	
}
