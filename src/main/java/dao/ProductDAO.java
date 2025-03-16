package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;
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
}