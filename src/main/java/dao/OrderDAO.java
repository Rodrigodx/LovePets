package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.Order;
import model.Product;

public class OrderDAO {
	
	private Connection connection;
	
	public OrderDAO () {
		connection = SingleConnection.getConnection();
	}
	
	public boolean insertOrder(Order model) {
		
		boolean result = false;
		
		try {
			String sql = "insert into love_pets.orders (p_id, u_id, o_quantity, o_date) values(?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setInt(1, model.getId());
			insert.setInt(2, model.getUid());
			insert.setInt(3, model.getQuantity());
			insert.setString(4, model.getDate());
			insert.execute();
			connection.commit();
			result = true;
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Order> userOrders(int id){
		
		List<Order> list = new ArrayList<Order>();
		try {
			
			String sql = "select * from love_pets.orders where u_id = ? order by orders.o_id desc";
			PreparedStatement select = connection.prepareStatement(sql);
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				ProductDAO pDao = new ProductDAO();
				int pId = rs.getInt("p_id");
				Product product = pDao.findById(pId);
				order.setOrderId(rs.getInt("o_id"));
				order.setId(pId);
				order.setName(product.getName());
				order.setCategory(product.getProductCategory());
				order.setPrice(product.getPrice());
				order.setPathImage(product.getPathImage());
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void cancelOrder(int id) {
		try {
			String sql = "delete from orders where o_id = ?";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.setInt(1, id);
			delete.execute();
			connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
