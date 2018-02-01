package poc;

import org.apache.solr.client.solrj.beans.Field;

public class Bean {
	@Field("id")
	private String id;
	@Field("name")
	private String name;
	@Field("price")
	private double price;
	@Field("qty")
	private int qty;
	
	

	public Bean() {

	}

	public Bean(String id, String name, double price,int qty) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
