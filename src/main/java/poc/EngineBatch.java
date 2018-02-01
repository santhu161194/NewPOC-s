/**
 * 
 */
package poc;

import java.io.Serializable;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author venkat
 *
 */
public class EngineBatch implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Field("batchId_s")
	Long batchId;
	
	@Field("storeReceiptId")
	Long storeReceiptId;
	
	@Field("productId_s")	
	String productId;
	
	@Field("batch_s")
	String batch;

	@Field("dateManufacturer_s")
	String dateManufacturer;
	
	@Field("dateExpiry_s")
	Date dateExpiry;
	
	@Field("mrp_s")
	double mrp;
	
	@Field("ptr_s")
	double ptr;
	
	@Field("pts_s")
	double pts;
	
	@Field("packsize_s")
	Integer packSize;
	
	@Field("saleunit_s")
	Integer saleUnit;
	
	@Field("barcode_s")
	Long barcode;
	
	@Field("unitprice_s")
	double unitPrice;
	
	@Field("costprice_s")
	double costPrice;
	
	@Field("costpriceExtTax")
	double costPriceExtTax;

	public Long getBatchId() {
	
		return batchId;
	}

	public void setBatchId(Long batchId) {
	
		this.batchId = batchId;
	}

	public Long getStoreReceiptId() {
	
		return storeReceiptId;
	}

	public void setStoreReceiptId(Long storeReceiptId) {
	
		this.storeReceiptId = storeReceiptId;
	}

	public String getProductId() {
	
		return productId;
	}

	public void setProductId(String productId) {
	
		this.productId = productId;
	}

	public String getBatch() {
	
		return batch;
	}

	public void setBatch(String batch) {
	
		this.batch = batch;
	}

	public String getDateManufacturer() {
	
		return dateManufacturer;
	}

	public void setDateManufacturer(String dateManufacturer) {
	
		this.dateManufacturer = dateManufacturer;
	}


	public Date getDateExpiry() {
		return dateExpiry;
	}

	public void setDateExpiry(Date dateExpiry) {
		this.dateExpiry = dateExpiry;
	}

	public Double getMrp() {
	
		return mrp;
	}

	public void setMrp(Double mrp) {
	
		this.mrp = mrp;
	}

	public Double getPtr() {
	
		return ptr;
	}

	public void setPtr(Double ptr) {
	
		this.ptr = ptr;
	}

	public Double getPts() {
	
		return pts;
	}

	public void setPts(Double pts) {
	
		this.pts = pts;
	}

	public Integer getPackSize() {
	
		return packSize;
	}

	public void setPackSize(Integer packSize) {
	
		this.packSize = packSize;
	}

	public Integer getSaleUnit() {
	
		return saleUnit;
	}

	public void setSaleUnit(Integer saleUnit) {
	
		this.saleUnit = saleUnit;
	}

	public Long getBarcode() {
	
		return barcode;
	}

	public void setBarcode(Long barcode) {
	
		this.barcode = barcode;
	}

	public Double getUnitPrice() {
	
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
	
		this.unitPrice = unitPrice;
	}

	public Double getCostPrice() {
	
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
	
		this.costPrice = costPrice;
	}

	public Double getCostPriceExtTax() {
	
		return costPriceExtTax;
	}

	public void setCostPriceExtTax(Double costPriceExtTax) {
	
		this.costPriceExtTax = costPriceExtTax;
	}
	
}