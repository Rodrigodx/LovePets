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
import enums.ProductCategory;

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
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		Product product = productDAO.findById(id);
		
		
		request.setAttribute("produto", product);
		System.out.println(product);
		request.getRequestDispatcher("/produto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			Product product = new Product();
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			
			double price1 = Double.parseDouble(price);
			ProductCategory cat = ProductCategory.valueOf(category);
			
			
			Part part = request.getPart("image");
			byte[] foto = IOUtils.toByteArray(part.getInputStream());
			String imageBase64 = Base64.getEncoder().encodeToString(foto);
			String image = "data:" + part.getContentType() + ";base64," + imageBase64;	
			System.out.println(image);

			
			product.setName(name);
			product.setPrice(price1);
			product.setPathImage(image);
			product.setCategory(cat);
		
			productDAO.saveProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
