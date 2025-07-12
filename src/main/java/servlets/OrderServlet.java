package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.Order;
import model.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.OrderDAO;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			List<Cart> cart_list = (List<Cart>) request.getSession().getAttribute("cart_list");
			User user = (User) request.getSession().getAttribute("user");
			
			if(cart_list != null && user != null) {
				
				for(Cart c: cart_list) {
					
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(user.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					OrderDAO oDao = new OrderDAO();
					boolean result = oDao.insertOrder(order);
					if(!result) break;
				}
				cart_list.clear();
				response.sendRedirect("ViewOrdersServlet");
				
			}else {
				if(user == null) {
					response.sendRedirect("login.jsp");
				}
				
				response.sendRedirect("ViewCartServlet?id=" + cart_list.size());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
