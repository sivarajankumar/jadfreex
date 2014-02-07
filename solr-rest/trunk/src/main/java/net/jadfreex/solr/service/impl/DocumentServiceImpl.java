package net.jadfreex.solr.service.impl;

import java.util.List;

import net.jadfreex.solr.entity.Document;
import net.jadfreex.solr.repository.DocumentDao;
import net.jadfreex.solr.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public List<Document> getAll() {
	return this.documentDao.getAll();
    }
}