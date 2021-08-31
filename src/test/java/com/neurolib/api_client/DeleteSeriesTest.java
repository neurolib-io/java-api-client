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

public class DeleteSeriesTest extends NeurolibTestCase {

    @Test
    public void testDeleteSeries() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with existing entity id'
        resp = this.client.send(new DeleteSeries("entity_id"));
        try {
            this.client.send(new DeleteSeries("entity_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with invalid entity id'
        try {
            this.client.send(new DeleteSeries("***not_valid$$$"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with non-existing entity'
        try {
            this.client.send(new DeleteSeries("valid_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
