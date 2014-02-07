package net.jadfreex.solr.controller;

import java.util.List;

import javax.ws.rs.GET;

import net.jadfreex.solr.entity.Document;
import net.jadfreex.solr.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("list")
    @ResponseBody
    @GET
    public List<Document> list() {
	return this.documentService.getAll();
    }
}