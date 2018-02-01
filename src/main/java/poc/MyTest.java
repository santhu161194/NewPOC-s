package poc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.springframework.context.annotation.PropertySource;

import com.medplus.solr.MedplusSolr;
import com.medplus.solr.core.SolrCoreHelper;
import com.medplus.solr.core.pojo.EngineBatch;
import com.medplus.solr.core.util.CoreUtilities;
import com.medplus.solr.exception.MedplusSolrException;

@PropertySource("classpath:solrCore.properties")
public class MyTest {
	
	
	private EngineBatch prepareEngineBatch(Long id) throws ParseException{
		EngineBatch engineBatch = new EngineBatch();
		engineBatch.setBarcode(id);
		engineBatch.setBatch("Batch1");
		engineBatch.setBatchId(id);
		engineBatch.setCostPrice(0.2);
		engineBatch.setCostPriceExtTax(0.2);
		engineBatch.setDateExpiry(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-12"));
		engineBatch.setDateManufacturer("2018-02-01");
		engineBatch.setMrp(0.2);
		engineBatch.setPackSize(1);
		engineBatch.setProductId("7_LA0001");
		engineBatch.setPtr(0.2);
		engineBatch.setPts(0.2);
		engineBatch.setSaleUnit(1);
		engineBatch.setStoreReceiptId(101l);
		engineBatch.setUnitPrice(0.2);
		return engineBatch; 
			
		
	}

	@Test
	public void createIndex() throws IOException, SolrServerException, ParseException {
		boolean done = false;
		EngineBatch batch = new EngineBatch();
		batch.setBatch("13B41A0439");
		batch.setPackSize(15);
		batch.setBatchId(1013167278l);
		batch.setProductId("ASPIRIN220");
		
		HttpSolrServer server = MedplusSolr.getBatchesWriteServer();
		UpdateResponse r=server.addBean(prepareEngineBatch(1000000003l));
		server.commit();
		assertEquals(0, r.getStatus());
	}
	
	//@Test
	public void createIndexForListOfPOJO() throws MedplusSolrException, ParseException
			{
		boolean done = false;
		EngineBatch batch = prepareEngineBatch(1000000004l);
		
		List<Object> pojoObjList=new ArrayList<Object>();
		pojoObjList.add(batch);
		BatchCoreHelper bch= new BatchCoreHelper();
		assertTrue(bch.createIndexForListOfPOJO(pojoObjList));
		
	}
	
	
	@Test
	public  void query() {
		SolrQuery query = new SolrQuery();
		query.set("q", "barcode_s:1013817238");
		query.set("rows", 1000);
		QueryResponse response = null;
		try {
			response = MedplusSolr.getBatchesReadServer().query(query);
		} catch (SolrServerException e) {
		}

		if (response == null)

		assertNotNull(response.getBeans(EngineBatch.class));
		System.out.println(response);
		assertEquals("PREG0018", response.getBeans(EngineBatch.class).iterator().next().getDateExpiry());

	}
	
	
}
