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

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Cart> cartList = new ArrayList<Cart>();

			int id = Integer.parseInt(request.getParameter("id"));
			Cart cart = new Cart();
			cart.setId(id);
			cart.setQuantity(1);

			HttpSession session = request.getSession();
			List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart-list", cartList);
				System.out.println("Session created and added the list");
			} else {

				cartList = cart_list;
				boolean exist = false;

				for (Cart c : cartList) {
					if (c.getId() == id) {
						exist = true;
						System.out.println("produto existe");
						break;
					}
				}

				if (!exist) {
					cartList.add(cart);
					System.out.println("produto adicionado");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
