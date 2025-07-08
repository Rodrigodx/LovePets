package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveFromCartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);

		try {
			if (idParam != null) {
				List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cart_list");
				if (cartList != null) {
					for (Cart c : cartList) {
						if (c.getId() == id) {
							cartList.remove(c);
							break;
						}
					}
				}

				response.sendRedirect("ViewCartServlet?id=" + id--);

			} else {

				response.sendRedirect("ViewCartServlet?id=" + id);
				System.out.println("Erro ao deletar item do carrinho.");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
