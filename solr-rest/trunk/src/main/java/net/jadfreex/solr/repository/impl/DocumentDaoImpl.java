package net.jadfreex.solr.repository.impl;

import java.util.List;

import net.jadfreex.commons.connection.Connection;
import net.jadfreex.solr.entity.Document;
import net.jadfreex.solr.repository.DocumentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    @Autowired
    private Connection connection;

    @Override
    public List<Document> getAll() {
	return this.connection.listQry("*:*");
    }

}