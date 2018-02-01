package poc;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;

public class SolrPOCOldSolr {
	public static void main(String[] args) throws IOException, SolrServerException {
		EngineBatch batch = new EngineBatch();
		batch.setBatch("13B41A0439");
		batch.setPackSize(15);
		batch.setBatchId(1013167278l);
		batch.setProductId("CROC150");
		commonCreateIndexByPOJO(batch, SolrConfigOldSolr.getProductsReadServer());
		//System.out.println(deleteById("f2e45d1d-05e0-4f0e-a981-5dec3551c5d0", SolrConfigOldSolr.getProductsReadServer()));
		List<EngineBatch> beans = query(SolrConfigOldSolr.getProductsReadServer());
		beans.forEach(bean->System.out.println(bean.getBatchId()));
	}

	private static boolean commonCreateIndexByPOJO(Object obj, HttpSolrServer server)
			throws IOException, SolrServerException {
		boolean done = false;
		server.addBean(obj);
		server.commit();
		done = true;
		return done;
	}

	private static List<EngineBatch> query(HttpSolrServer server) {
		SolrQuery query = new SolrQuery();
		query.set("q", "batchId_s:1013167278");
		query.set("rows", 1000);
		QueryResponse response = null;
		try {
			response = SolrConfigOldSolr.getProductsReadServer().query(query);
		} catch (SolrServerException e) {
		}

		if (response == null)
			return Collections.emptyList();

		return response.getBeans(EngineBatch.class);

	}
	
	
	private static int deleteById(String id,HttpSolrServer server) throws SolrServerException, IOException {
		UpdateResponse b = server.deleteByQuery("batchId_s:1013167278");
		server.commit();
		return b.getStatus();
		
	}

}
