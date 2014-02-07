package net.jadfreex.solr.dummy;

import java.util.ArrayList;
import java.util.List;

import net.jadfreex.solr.entity.Document;

public class DocumentDummy {

    public static Document getDocument() {
	// Features
	List<String> l = new ArrayList<String>();
	l.add("jaja");
	l.add("jeje");
	l.add("jiji");
	l.add("jojo");
	l.add("juju");

	// Document
	Document doc = new Document();
	doc.setId("JADFREEX");
	doc.setName("THANFREEX");
	doc.setFeatures(l);

	// return
	return doc;
    }

}
