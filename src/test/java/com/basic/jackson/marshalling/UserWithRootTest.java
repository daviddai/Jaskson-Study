package com.basic.jackson.marshalling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;

public class UserWithRootTest {

    @Test
    public void testJsonWithRoot() throws JsonProcessingException {
        UserWithRoot userWithRoot = new UserWithRoot(1, "Lolly");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = objectMapper.writeValueAsString(userWithRoot);
        Assert.assertTrue(result.equals("{\"user\":{\"id\":1,\"name\":\"Lolly\"}}"));
    }

}
