package ua.lviv.lgs;

public class Magazine {
	
	private int id;
	private String name;
	private String description;
	private double price;
	private String isbn;
	
	public Magazine(int id, String name, String description, double price, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
	}
	public Magazine(String name, String description, double price, String isbn) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Magazine [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", isbn="
				+ isbn + "]";
	}
	
	

}
