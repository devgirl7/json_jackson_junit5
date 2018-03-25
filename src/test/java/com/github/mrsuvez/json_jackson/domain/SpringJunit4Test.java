package com.github.mrsuvez.json_jackson.domain;

import com.github.mrsuvez.json_jackson.dataHandler.DataHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJunit4Test {

    @Autowired
    private DataHandler dataHandler;

    @Test
    public void myTest(){
        Assert.assertTrue(true);
    }

    @Test
    public void autoWired(){
        Assert.assertEquals(dataHandler.getSpringTestThis(),"springTestThis");
    }

}
