package com.github.mrsuvez.json_jackson.domain;

import com.github.mrsuvez.json_jackson.dataHandler.DataHandler;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
public class SpringJunit5Test {

    @Autowired
    DataHandler dataHandler;

    @Test
    public void myTest(){
        Assert.assertEquals(dataHandler.getSpringTestThis(),dataHandler.getSpringTestThis());
    }

}
