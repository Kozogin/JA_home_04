package ua.lviv.lgs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/registration")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 2L; 
	
	private UsersDao usersDao;
	private MagazineDao magazineDao;
	private MagazineUsersDao magazineUsersDao;
	
	public void init() {
		System.out.println("init servlet2");
		try {
			
			usersDao = new UsersDao(ConectionUtils.openConnection());
			magazineDao = new MagazineDao(ConectionUtils.openConnection());
			magazineUsersDao = new MagazineUsersDao(ConectionUtils.openConnection());
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("registration do get");
		request.getRequestDispatcher("registrationForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("regis dopost");
		String login = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		UserService userService = UserService.getUserService();
		
		
			if(!userService.boolFindUser(usersDao, login)) {
				userService.addUser(usersDao, new Users(login, password, firstName, lastName));
				request.setAttribute("login", login);			
				request.getRequestDispatcher("cabinet.jsp").forward(request, response);			
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} 		
		
	}

}
