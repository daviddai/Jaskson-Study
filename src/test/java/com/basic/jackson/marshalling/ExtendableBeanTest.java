package com.basic.jackson.marshalling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExtendableBeanTest {

    private ExtendableBean extendableBean;

    @Before
    public void init() {
        extendableBean = new ExtendableBean("My Extendable Bean");
        extendableBean.addKeyValue("dependency", "Jackson");
        extendableBean.addKeyValue("version", "2.96");
    }


    @Test
    public void testJsonAnyGetter() throws JsonProcessingException {
        String result = new ObjectMapper().writeValueAsString(extendableBean);
        Assert.assertTrue("The marshalling string should contain \"dependency\":\"Jackson\"",
                result.contains("\"dependency\":\"Jackson\""));
        Assert.assertTrue("The marshalling string should contain \"version\":\"2.96\"",
                result.contains("\"version\":\"2.96\""));
    }

    @Test
    public void testJsonGetter() throws JsonProcessingException {
        String result = new ObjectMapper().writeValueAsString(extendableBean);
        Assert.assertTrue("The marshalling string should contain \"beanName\":\"My Extendable Bean\"",
                result.contains("\"beanName\":\"My Extendable Bean\""));
    }

    @Test
    public void testJsonPropertyOrder() throws JsonProcessingException {
        String result = new ObjectMapper().writeValueAsString(extendableBean);
        int indexOfFirstProperty = result.indexOf("properties");
        int indexOfName = result.indexOf("beanName");
        Assert.assertTrue("Properties should have a smaller index", indexOfFirstProperty < indexOfName);
    }
}
