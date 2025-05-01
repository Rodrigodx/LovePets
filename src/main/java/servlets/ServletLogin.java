package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO dao = new UserDAO();

	public ServletLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Map<String, String> messages = new HashMap<String, String>();
		
		
		if (email == null || email.isEmpty()) {
			messages.put("email", "Please enter your email");
		}
		
		if (password == null || password.isEmpty()) {
			messages.put("password", "Please enter your password");
		}
		
		if(messages.isEmpty()) {
			User user = dao.findUserByEmail(email);
			
			if(user != null && password.equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/Inicial.jsp");
				return;
			}else {
				messages.put("login", "Email or password incorret");
			}
			
		} 
			
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		

		/*if (email != null && password != null) {
			
			User user = dao.findUserByEmail(email);
			
			if(user != null && password.equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("Inicial.jsp");
				System.out.println("Feito o login");
			}else {
				System.out.println("Erro ao logar");
			}
			
		} else {
			System.out.println("Error nas credenciais");
		}*/
	}

}
