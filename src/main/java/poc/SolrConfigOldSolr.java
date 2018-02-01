package poc;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.solr.client.solrj.impl.HttpSolrServer;



public class SolrConfigOldSolr {
	
	private static HttpSolrServer prSolrServer;
	private static DefaultHttpClient returnBaseClient() {
		PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
		DefaultHttpClient client = new DefaultHttpClient(cm);
		try {
			client.getConnectionManager().getSchemeRegistry()
					.unregister("https");
			return client;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public static HttpSolrServer getProductsReadServer() {
		if (null == prSolrServer) {
			try {
				prSolrServer = new HttpSolrServer("http://192.168.1.196:8983/solr/batches", returnBaseClient());
				prSolrServer.setConnectionTimeout(60000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(prSolrServer != null)
			prSolrServer.getHttpClient().getConnectionManager().closeExpiredConnections();
		return prSolrServer;
	}
	
}
