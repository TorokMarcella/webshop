package hu.citec.service;

import hu.citec.entities.Product;
import hu.citec.repository.Repository;

public class ProductService {
	
	private Repository repo;
	
	public void addProduct(String id, String productName, String type, String price) {
		
		repo.addProduct(new Product(Integer.parseInt(id), productName, type, Integer.parseInt(price)));
	}
}