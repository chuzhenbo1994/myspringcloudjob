package com.example.demo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class Solr {
    public static void main(String[] args) throws Exception {

        SolrClient solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/chuzhenbo").build();
        System.out.println(1);

        //创建一个文档
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id",10);
        document.addField("title","测试");
        UpdateResponse add = solrClient.add(document);
        solrClient.commit();

    }
}
