package ua.lviv.lgs;

public class Users {
	
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String details;
	
	
	
	public Users(String userName, String password, String firstName, String lastName) {
			
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;		
	}

	public Users(int id, String userName, String password, String firstName, String lastName, String details) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.details = details;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", details=" + details + "]";
	}

}
