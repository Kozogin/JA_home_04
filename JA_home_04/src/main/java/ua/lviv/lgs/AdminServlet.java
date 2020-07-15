package ua.lviv.lgs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
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
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		String isbn = request.getParameter("isbn");
		MagazineService magazineService = new MagazineService();
		
		System.out.println(name+description+price+isbn);
		System.out.println(magazineService.boolFindMagazineIsbn(magazineDao, isbn));
		
		if(!magazineService.boolFindMagazineIsbn(magazineDao, isbn)) {
			magazineService.addMagazine(magazineDao, new Magazine(name, description, price, isbn));
			
			request.setAttribute("addStatus", "add magazine successful");			
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} else {
			request.setAttribute("addStatus", "the magazine isn't added, the isbn isn't unique");			
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
	}

}
