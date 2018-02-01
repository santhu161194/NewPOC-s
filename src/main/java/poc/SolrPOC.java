package poc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;

public class SolrPOC {

	public static void main(String[] args) throws SolrServerException, IOException {
		SolrPOC sNew= new SolrPOC();
		Bean bean = new Bean(String.valueOf(new Random().nextInt(500)), "Paracetamol"+new Random().nextInt(500), new Random().nextDouble(),new Random().nextInt(500));
		//SolrConfig.getBatchesWriteServer().addBean(bean);

		Bean bean2 = new Bean(String.valueOf(new Random().nextInt(500)), "Aspirin"+new Random().nextInt(500), new Random().nextDouble(), new Random().nextInt(500));
		List<Bean> beans = new ArrayList<>();
		beans.add(bean);
		beans.add(bean2);
		
		EngineProduct product=new EngineProduct(String.valueOf(new Random().nextInt()), "PARACETAMOL");
		EngineProduct product2=new EngineProduct(String.valueOf(new Random().nextInt()),  "ASPIRIN");
		List<EngineProduct> products=new ArrayList<>(Arrays.asList(product,product2));
		//addBeanListToSolr(SolrConfigOldSolr.getProductsReadServer(), products);
		//addSolrDocument(SolrConfig.getProductsWriteServer());
		//addSolrDocumentToLocalOldSolr(SolrConfigOldSolr.getProductsReadServer());
		
		
		//addBeanListToSolr(SolrConfig.getBatchesWriteServer(), beans);
		sNew.readOpticalBeansfromSolr();
	}

	

	private static void addBeanListToSolr(HttpSolrClient httpSolrServer, List bean) {
		if (httpSolrServer != null) {
			try {
				httpSolrServer.addBeans(bean);
				httpSolrServer.commit();
			} catch (IOException | SolrServerException e) {
				e.printStackTrace();
			}

		}
	}
	
	
	private static void addSolrDocument(HttpSolrClient httpSolrClient) throws SolrServerException, IOException {
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id_s", "552199");
		document.addField("name_s", "Gouda cheese wheel");
		System.out.println(httpSolrClient.add(document,2));
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
	
	private  void readOpticalBeansfromSolr() throws SolrServerException, IOException {
		// querying
		SolrQuery query = new SolrQuery();
		query.set("q", "id_s:552199");
		query.set("rows", 1000);
		QueryResponse response = SolrConfig.getBatchesWriteServer().query(query);
		List<EngineProduct> docList = response.getBeans(EngineProduct.class);
		for (EngineProduct doc : docList) {
			System.out.println(doc.getProductName());
		}

	}	
	
	

}
