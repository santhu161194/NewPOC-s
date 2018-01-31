package poc;

import org.apache.solr.client.solrj.beans.Field;

public class Bean{
	@Field("id")
	private String id;
	@Field("name")
	private String name;
	@Field("price")
	private double price;
	
	public Bean() {

	}
	
	public Bean(String id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
	
}
