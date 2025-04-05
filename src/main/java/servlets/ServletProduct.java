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
import java.lang.reflect.Parameter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

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
		
		String idParam = request.getParameter("id");
		String categoryParam = request.getParameter("category");
		
		if(idParam != null && !idParam.isEmpty()) {
			int id = Integer.parseInt(idParam);
			
			Product product = productDAO.findById(id);
			
			request.setAttribute("produto", product);
			System.out.println(product);
			request.getRequestDispatcher("/produto.jsp").forward(request, response);
		}else if(categoryParam != null && !categoryParam.isEmpty()) {
			Integer category = Integer.parseInt(categoryParam);
			
			List<Product> products = productDAO.findByCategory(category);
			
			request.setAttribute("produtos", products);
			System.out.println(products);
			request.getRequestDispatcher("/category_products.jsp").forward(request, response);
		}
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
