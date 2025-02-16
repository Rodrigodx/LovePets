package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import model.User;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void insert(User user) throws SQLException {
		try {	
			String sql = "insert into love_pets.users (name, email, password) values(?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, user.getName());
			insert.setString(2, user.getEmail());
			insert.setString(3, user.getPassword());
			
			insert.execute();
			connection.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			connection.rollback();
		}
	}
	
	public User findUserByEmail(String email) {
		
		User user = new User();
		
		try {
			
			String sql = "select email, password from love_pets.users where email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

}
