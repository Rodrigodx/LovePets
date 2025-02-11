package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.sql.SQLException;

import dao.UserDAO;

@WebServlet("/register")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO userDAO = new UserDAO();

    public ServletRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		User user = new User();
		
		if(password.equals(password2)) {
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			
			try {
				userDAO.insert(user);
				response.sendRedirect("login.jsp");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Senha: " + password);
			System.out.println("Senha2: " + password2);
			System.out.println("Senhas nao correspondem.");
			System.out.println(user.toString());
		}
	}

}
