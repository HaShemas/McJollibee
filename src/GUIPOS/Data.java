package GUIPOS;

public class Data {
	String product, buy;
	double price;
	String position;
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
	public double getPrice() {
		return this.price;
	}
	public String getProduct() {
		return this.product;
	}
	
	
	public void setPos(String position) {
		this.position = position;
	}
	
	
	public String getPos() {
		return this.position;
	}
}
