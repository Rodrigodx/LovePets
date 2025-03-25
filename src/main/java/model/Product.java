package model;

import enums.ProductCategory;

public class Product {

	private Integer id;
	private String name;
	private Double price;
	private String pathImage;
	private Integer category;
	
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, Double price, String pathImage, Integer category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.pathImage = pathImage;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	public void setCategory (ProductCategory productCategory) {
		this.category = productCategory.cod;
	}
	
	public ProductCategory getProductCategory() {
		return ProductCategory.findByCode(this.category).orElse(null);
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", pathImage=" + pathImage + "]";
	}
	
	
	
}
