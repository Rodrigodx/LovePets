package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import enums.ProductCategory;
import model.Cart;
import model.Product;

public class ProductDAO {
	
	private Connection connection;
	
	public ProductDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveProduct (Product product) throws SQLException {
		
		try {			
			String sql = "insert into love_pets.products (name, price, name_image, category) values(?, ?, ?, ?)";
			
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, product.getName());
			insert.setDouble(2, product.getPrice());
			insert.setString(3, product.getPathImage());
			insert.setInt(4, product.getProductCategory().cod);
			
			insert.execute();
			connection.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			connection.rollback();
		}
		
	}
	
	public Product findById(int id){
		Product product = new Product();
		try { 
			String sql = "select *from love_pets.products where id = ?";
			
			PreparedStatement select = connection.prepareStatement(sql);
			select.setInt(1, id);
			
			ResultSet result = select.executeQuery();
			
			while(result.next()) {
				product.setId(result.getInt("id"));
				product.setName(result.getString("name"));
				product.setPrice(result.getDouble("price"));
				product.setPathImage(result.getString("name_image"));
				Integer cat = result.getInt("category");
				ProductCategory productCategory = ProductCategory.findByCode(cat).orElse(null);
				product.setCategory(productCategory);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public List<Product> findByCategory (Integer category){
		
		List<Product> listProducts = new ArrayList<Product>();
		
		try {
			String sql = "select * from love_pets.products where category = ?";
			
			PreparedStatement select = connection.prepareStatement(sql);
			select.setInt(1, category);
			
			ResultSet result = select.executeQuery();
			
			while(result.next()) {
				Product product = new Product();
				
				product.setId(result.getInt("id"));
				product.setName(result.getString("name"));
				product.setPrice(result.getDouble("price"));
				product.setPathImage(result.getString("name_image"));
				Integer cat = result.getInt("category");
				ProductCategory productCategory = ProductCategory.findByCode(cat).orElse(null);
				product.setCategory(productCategory);
				
				listProducts.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listProducts;
	}
	
	public List<Cart> getCartProducts (ArrayList<Cart> cartList){
		List <Cart> products = new ArrayList<Cart>();
		
		try {
			if(cartList.size() > 0) {
				for(Cart item:cartList) {
					String sql = "select * from love_pets.products where id = ?";
					PreparedStatement select = connection.prepareStatement(sql);
					select.setInt(1, item.getId());
					
					ResultSet result = select.executeQuery();
					
					while(result.next()) {
						Cart cart = new Cart();
						
						cart.setId(result.getInt("id"));
						cart.setName(result.getString("name"));
						cart.setPrice(result.getDouble("price")*item.getQuantity());
						cart.setPathImage(result.getString("name_image"));
						cart.setQuantity(item.getQuantity());
						
						products.add(cart);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
		
	}
} 