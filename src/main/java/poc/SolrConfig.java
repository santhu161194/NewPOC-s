package poc;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.solr.client.solrj.impl.HttpSolrClient;


public class SolrConfig {
	private SolrConfig() {

	}
	
	private static HttpSolrClient batcheswSolrServer;
	
	
	public static HttpSolrClient getBatchesWriteServer() throws IOException {
		if (null == batcheswSolrServer) {
			batcheswSolrServer=new HttpSolrClient.Builder("http://localhost:8983/solr/newbatch").withHttpClient(returnBaseClient()).withConnectionTimeout(6000).build();
		}
		if(batcheswSolrServer != null)
			batcheswSolrServer.close();
		return batcheswSolrServer;
	}
	
	
	
	public static HttpSolrClient getProductsWriteServer() throws IOException {
		if (null == batcheswSolrServer) {
			batcheswSolrServer=new HttpSolrClient.Builder("http://192.168.1.194:8088/medplussolrengine/products").withHttpClient(returnBaseClient()).withConnectionTimeout(6000).build();
		}
		if(batcheswSolrServer != null)
			batcheswSolrServer.close();
		return batcheswSolrServer;
	}
	
	public static HttpSolrClient getLocalProductsWriteServer() throws IOException {
		if (null == batcheswSolrServer) {
			batcheswSolrServer=new HttpSolrClient.Builder("http://localhost:9999/solr/collection1").withHttpClient(returnBaseClient()).withConnectionTimeout(6000).build();
		}
		if(batcheswSolrServer != null)
			batcheswSolrServer.close();
		return batcheswSolrServer;
	}
	private static HttpClient returnBaseClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		return HttpClients.custom()
		        .setConnectionManager(cm)
		        .build();
	}
}
