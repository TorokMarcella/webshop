package hu.citec.entities;

public class Product {

	private int id;
	private String productName;
	private String type;
	private int price;
	
	public Product(int id, String productName, String type, int price) {
		this.id = id;
		this.productName = productName;
		this.type = type;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public boolean equals(Product p) {
		if (id != 0 ? !(id == (p.id)) : p.id != 0) {
			return false;
		}
		if (productName != null ? !productName.equals(p.productName) : p.productName != null) {
			return false;
		}

		if (type != null ? !type.equals(p.type) : p.type != null) {
			return false;
		}
		return price != 0 ? !(price == (p.price)) : p.id == 0;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", type=" + type + ", price=" + price + "]";
	}
}