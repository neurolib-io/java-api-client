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

public class DeleteItemPropertyTest extends NeurolibTestCase {

    @Test
    public void testDeleteItemProperty() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with existing property'
        resp = this.client.send(new DeleteItemProperty("int_property"));
        try {
            this.client.send(new DeleteItemProperty("int_property"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with invalid property'
        try {
            this.client.send(new DeleteItemProperty("***not_valid$$$"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with non-existing property'
        try {
            this.client.send(new DeleteItemProperty("not_existing"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
