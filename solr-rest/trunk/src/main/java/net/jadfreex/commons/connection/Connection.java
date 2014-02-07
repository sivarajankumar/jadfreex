package net.jadfreex.commons.connection;

import java.io.IOException;
import java.util.List;

import net.jadfreex.commons.exception.AppException;
import net.jadfreex.solr.entity.Document;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connection {

    private Logger log = LoggerFactory.getLogger(Connection.class);
    private HttpSolrServer server = null;
    private String url = null;

    public Connection(String url) {
	this.server = new HttpSolrServer((this.url = url));

	server.setMaxRetries(1);
	server.setConnectionTimeout(5000);
	server.setParser(new XMLResponseParser());
	server.setSoTimeout(2000);
	server.setDefaultMaxConnectionsPerHost(100);
	server.setMaxTotalConnections(100);
	server.setFollowRedirects(false);
	server.setAllowCompression(true);

	this.log.info("OPENED");
    }

    public void addBean(Document doc) {
	try {
	    this.server.addBean(doc);
	    this.log.info("ADDED: " + doc.getName());
	} catch (IOException e) {
	    throw new AppException("Error de I/O", e);
	} catch (SolrServerException e) {
	    throw new AppException("Error de solr", e);
	}
    }

    public void deleteQry(String qry) {
	try {
	    this.server.deleteByQuery(qry);
	    this.log.info("DELETED: " + qry);
	} catch (SolrServerException e) {
	    throw new AppException("Error de solr", e);
	} catch (IOException e) {
	    throw new AppException("Error de I/O", e);
	}
    }

    public List<Document> listQry(String qry) {
	List<Document> list = null;

	SolrQuery query = new SolrQuery();
	query.setQuery(qry);
	query.addSortField("name", SolrQuery.ORDER.asc);

	try {
	    QueryResponse res = server.query(query);
	    list = res.getBeans(Document.class);

	    String msg = "";
	    for (Document document : list) {
		msg += document.getId() + ", ";
	    }
	    this.log.info("LISTED: " + msg);
	    return list;
	} catch (SolrServerException e) {
	    throw new AppException("Error de Solr", e);
	}
    }

    public void commit() {
	try {
	    this.server.commit();
	    this.log.info("COMMITED");
	} catch (SolrServerException e) {
	    throw new AppException("Error de solr", e);
	} catch (IOException e) {
	    throw new AppException("Error de I/O", e);
	}
    }

    public void close() {
	this.server.shutdown();
	log.info("CLOSED");
    }

    public HttpSolrServer getServer() {
	return server;
    }

    public void setServer(HttpSolrServer server) {
	this.server = server;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }
}
