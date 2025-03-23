package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import jakarta.servlet.Servlet;
import model.Product;

public class ProductDAO {
	
	private Connection connection;
	
	public ProductDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveProduct (Product product) throws SQLException {
		
		try {			
			String sql = "insert into love_pets.products (name, price, name_image) values(?, ?, ?)";
			
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, product.getName());
			insert.setDouble(2, product.getPrice());
			insert.setString(3, product.getPathImage());
			
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
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
}