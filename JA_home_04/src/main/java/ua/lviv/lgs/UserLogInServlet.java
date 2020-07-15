package ua.lviv.lgs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	private UsersDao usersDao;
	private MagazineDao magazineDao;
	private MagazineUsersDao magazineUsersDao;
	private static boolean boolUserLogIn;
	
	public void init() {
		System.out.println("init servlet");
		try {
			
			usersDao = new UsersDao(ConectionUtils.openConnection());
			magazineDao = new MagazineDao(ConectionUtils.openConnection());
			magazineUsersDao = new MagazineUsersDao(ConectionUtils.openConnection());
			boolUserLogIn = false;
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		String login = request.getParameter("userName");
		String password = request.getParameter("password");
		
		UserService userService = UserService.getUserService();		
		
		if(userService.boolUserPassword(usersDao, login, password)) {
			if(login.equals("admin")){
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			} else {
				boolUserLogIn = true;
				request.setAttribute("login", login);			
				request.getRequestDispatcher("cabinet.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("wrongInput", "incorrect login or password");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public boolean isBoolUserLogIn() {
		return boolUserLogIn;
	}	
	
	

}
