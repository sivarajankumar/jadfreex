package net.jadfreex.test.domain;

import javax.validation.Validator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioTest {

    private static Logger log = LoggerFactory.getLogger(UsuarioTest.class);

    @Autowired
    private Validator validator;

    @Test
    public void test() {
    }

}