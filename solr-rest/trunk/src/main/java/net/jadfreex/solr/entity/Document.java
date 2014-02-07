package net.jadfreex.solr.entity;

import java.util.List;

import javax.persistence.Entity;

import org.apache.solr.client.solrj.beans.Field;

@Entity
public class Document {

    @Field
    private String id;

    @Field
    private String name;

    @Field
    private List<String> features;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<String> getFeatures() {
	return features;
    }

    public void setFeatures(List<String> features) {
	this.features = features;
    }
}