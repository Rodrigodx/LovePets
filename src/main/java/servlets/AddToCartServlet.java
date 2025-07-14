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


@WebServlet("/CartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddToCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String idParam = request.getParameter("id");
			int id = Integer.parseInt(idParam);
			
			Cart cart = new Cart();			
			
			cart.setId(id);
			cart.setQuantity(1);

			HttpSession session = request.getSession();
			List<Cart> cartList = (List<Cart>) session.getAttribute("cart_list");
			
			if (cartList == null) {
				cartList = new ArrayList();
				cartList.add(cart);
				session.setAttribute("cart_list", cartList);
				System.out.println("Session created and added the list");
			} else {

				boolean exist = cartList.stream().anyMatch(c -> c.getId() == id);
				
				if(!exist) {
					cartList.add(cart);
					System.out.println("Produto Adicionado");
				}else {
					System.out.println("produto existe");
				}
			}
			
			response.sendRedirect("ViewCartServlet?id=" + id);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
