package com.neurolib.api_client;
/*
 This file is auto-generated, do not edit
*/


import com.neurolib.api_client.api_requests.*;
import com.neurolib.api_client.bindings.*;
import com.neurolib.api_client.exceptions.ApiException;
import com.neurolib.api_client.exceptions.ResponseException;

import java.util.HashMap;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class AddItemPropertyTest extends NeurolibTestCase {

    @Test
    public void testAddItemProperty() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with valid name and type'
        resp = this.client.send(new AddItemProperty("number","int"));
        resp = this.client.send(new AddItemProperty("str","string"));
        // it 'fails with invalid type'
        try {
            this.client.send(new AddItemProperty("prop","integer"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'really stores property to the system'
        resp = this.client.send(new AddItemProperty("number2","int"));
        try {
            this.client.send(new AddItemProperty("number2","int"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
