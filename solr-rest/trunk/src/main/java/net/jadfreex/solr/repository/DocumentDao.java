package net.jadfreex.solr.repository;

import java.util.List;

import net.jadfreex.solr.entity.Document;

public interface DocumentDao {

    List<Document> getAll();

}