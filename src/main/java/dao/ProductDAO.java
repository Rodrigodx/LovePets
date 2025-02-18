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
			String sql = "insert into love_pets.products (id, name, price, pathImage) values(?, ?, ?, ?, ?)";
			
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setInt(1, product.getId());
			insert.setString(2, product.getName());
			insert.setDouble(3, product.getPrice());
			insert.setString(4, product.getPathImage());
			
			insert.execute();
			connection.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			connection.rollback();
		}
		
	}
}