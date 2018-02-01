package poc;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author ShivaGanesh
 * 
 */
public class EngineProduct {

	@Field("id_s")
	private String id;

	@Field("name_s")
	private String productName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EngineProduct() {
	}

	public EngineProduct(String id,  String productName) {
		super();
		this.id = id;
		
		this.productName = productName;
	}





	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}