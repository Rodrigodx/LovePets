package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;

import java.io.IOException;
import java.util.List;


@WebServlet("/QuantityItemServlet")
public class QuantityItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QuantityItemServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<Cart> cartList = (List<Cart>) request.getSession().getAttribute("cart_list");
		
		if(action != null & id > 1) {
			if(action.equals("inc")) {
				for(Cart c:cartList) {
					if(c.getId() == id) {
						int quant = c.getQuantity();
						quant++;
						c.setQuantity(quant);
						response.sendRedirect("ViewCartServlet?id=" + c.getId());
					}
				}
			}else if(action.equals("dec")) {
				for(Cart c: cartList) {
					if(c.getId() == id) {
						int quant = c.getQuantity();
						quant--;
						c.setQuantity(quant);
						response.sendRedirect("ViewCartServlet?id=" + c.getId());
					}
				}
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
