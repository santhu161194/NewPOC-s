package poc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

public class SolrPOC {

	public static void main(String[] args) throws SolrServerException, IOException {

		Bean bean = new Bean(String.valueOf(new Random().nextInt(500)), "Paracetamol"+new Random().nextInt(500), new Random().nextDouble());
		SolrConfig.getBatchesWriteServer().addBean(bean);

		Bean bean2 = new Bean(String.valueOf(new Random().nextInt(500)), "Aspirin"+new Random().nextInt(500), new Random().nextDouble());
		List<Bean> beans = new ArrayList<>();
		beans.add(bean);
		beans.add(bean2);
		addBeanListToSolr(SolrConfig.getBatchesWriteServer(), beans);
		readBeanfromSolr();
	}

	private static void addBeanListToSolr(HttpSolrClient httpSolrClient, List<Bean> bean) {
		if (httpSolrClient != null) {
			try {
				httpSolrClient.addBeans(bean);
				httpSolrClient.commit();
			} catch (IOException | SolrServerException e) {
				e.printStackTrace();
			}

		}
	}

	private static void readBeanfromSolr() throws SolrServerException, IOException {
		// querying
		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
		query.set("rows", 1000);
		QueryResponse response = SolrConfig.getBatchesWriteServer().query(query);
		List<Bean> docList = response.getBeans(Bean.class);
		for (Bean doc : docList) {
			System.out.println((String) doc.getName());
		}

	}

}
