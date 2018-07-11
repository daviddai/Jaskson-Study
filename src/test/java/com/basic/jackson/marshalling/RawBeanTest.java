package com.basic.jackson.marshalling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class RawBeanTest {

    @Test
    public void testJsonRawValue() throws JsonProcessingException {
        RawBean rawBean = new RawBean("Raw Bean", "{\"attr\": false}");
        String result = new ObjectMapper().writeValueAsString(rawBean);
        Assert.assertTrue("Property name should exist", result.contains("\"name\":\"Raw Bean\""));
        Assert.assertTrue("Property json should exist", result.contains("\"json\":{\"attr\": false}"));
    }

}
