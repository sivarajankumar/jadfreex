package net.jadfreex.solr.app;

import net.jadfreex.commons.connection.Connection;
import net.jadfreex.solr.dummy.DocumentDummy;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {

    private final String URL = "http://localhost:8983/solr";
    private Connection con = null;

    @Test
    public void deleteTest() {
	con = new Connection(this.URL);
	con.deleteQry("*:*");
	con.addBean(DocumentDummy.getDocument());
	con.commit();
	con.close();
    }

    @Test(expected = IllegalStateException.class)
    public void closeTest() {
	con = new Connection(this.URL);
	con.close();
	con.deleteQry("*:*");
	con.addBean(DocumentDummy.getDocument());
	con.commit();
    }

    @Test
    public void listTest() {
	con = new Connection(this.URL);
	con.listQry("*:*");
	con.close();
    }
}