package hu.citec.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.citec.entities.Product;
import hu.citec.entities.User;

public class Repository {
	
	private final String URL = "jdbc:mysql://localhost:3306/webshop";
	private final String USERNAME = "root";
	private final String PASSWORD = "";

	private Connection con;
	private Statement stmt;
	
	private List<Product> products = new ArrayList<Product>();
	
	public Repository() {
		initDataBase();
	}

	private void initDataBase() {
		
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("Hiba a kapcsolat kiépítése közben... " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Nem sikerült zárni a kapcsolatot... " + e.getMessage());
		}
	}
	
	public List<Product> listByProduct() {
		
		String query = "SELECT * FROM product";

		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("type"), rs.getInt("price"));
				products.add(product);
			}
			
		} catch (SQLException e) {
			System.out.println("Hiba a termékek lekérdezésekor... " + e.getMessage());
		}
		return products;
	}
	
	public void addProduct(Product product) {
		
		products.add(product);
	}
}