package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnection;
import model.User;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void insert(User user) {
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
		}
	}
	
	

}
