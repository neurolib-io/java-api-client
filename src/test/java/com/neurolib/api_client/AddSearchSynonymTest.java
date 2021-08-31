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

public class AddSearchSynonymTest extends NeurolibTestCase {

    @Test
    public void testAddSearchSynonym() throws ApiException {
        SearchSynonym  resp;
        Object resp2;
        // it 'adds search synonym'
        resp = this.client.send(new AddSearchSynonym("sci-fi","science fiction").setOneWay(true));
        assertEquals ("sci-fi",resp.getTerm());
        assertEquals ("science fiction",resp.getSynonym());
        try {
            this.client.send(new AddSearchSynonym("sci-fi","science fiction").setOneWay(true));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
