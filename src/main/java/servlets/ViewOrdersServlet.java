package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;

@WebServlet("/ViewOrdersServlet")
public class ViewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	OrderDAO dao = new OrderDAO();
	
    public ViewOrdersServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			
			User user = (User) session.getAttribute("user");
			
			if(user != null) {
				
				List<Order> result = dao.userOrders(user.getId());
				
				request.setAttribute("order_list", result);
				request.getRequestDispatcher("/orders.jsp").forward(request, response);
			}else {
				if(user == null) {
					response.sendRedirect("login.jsp");
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
