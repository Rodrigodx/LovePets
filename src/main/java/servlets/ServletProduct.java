package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Product;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;

import org.apache.commons.compress.utils.IOUtils;

import dao.ProductDAO;

@MultipartConfig
@WebServlet("/ServletProduct")
public class ServletProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDAO productDAO = new ProductDAO();

	public ServletProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			Product product = new Product();
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			
			double price1 = Double.parseDouble(price);
			
			
			Part part = request.getPart("image");
			byte[] foto = IOUtils.toByteArray(part.getInputStream());
			String imageBase64 = Base64.getEncoder().encodeToString(foto);
			System.out.println(imageBase64);
				
			product.setName(name);
			product.setPrice(price1);
			product.setPathImage(imageBase64);
		
			productDAO.saveProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * private String getFileName(Part part) { String contentDisp =
	 * part.getHeader("content-disposition"); String[] items =
	 * contentDisp.split(";"); for (String s : items) { if
	 * (s.trim().startsWith("filename")) { return s.substring(s.indexOf("=") + 2,
	 * s.length() - 1); } } return ""; }
	 */

}
