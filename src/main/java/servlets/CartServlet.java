package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import dao.ProductDAO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDAO dao = new ProductDAO();
	
	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Cart> cartList = new ArrayList<Cart>();

			String idParam = request.getParameter("id");
			
			Cart cart = new Cart();
			
			int id = Integer.parseInt(idParam);
			
			Product product = dao.findById(id);
			
			cart.setId(id);
			cart.setName(product.getName());
			cart.setPrice(product.getPrice());
			cart.setPathImage(product.getPathImage());
			cart.setQuantity(1);

			HttpSession session = request.getSession();
			List<Cart> cart_list = (List<Cart>) session.getAttribute("cart_list");

			if (cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart_list", cartList);
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
			
			request.setAttribute("cart_list", cartList);
			request.getRequestDispatcher("/cart.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
