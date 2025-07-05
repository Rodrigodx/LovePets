package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductDAO dao = new ProductDAO();
	
    public ViewCartServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("cart_list");
		
		if(cartList == null) {
			cartList = new ArrayList<>();
		}
		
		if(cartList == null || cartList.isEmpty()) {
			response.sendRedirect("Inicial.jsp");
			return;
		}
		
		List<Cart> result = dao.getCartProducts(cartList);
		double totalPrice = dao.getAllCartPrice(cartList);
		
		request.setAttribute("cart_list", result);
		request.setAttribute("total_price", totalPrice);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
