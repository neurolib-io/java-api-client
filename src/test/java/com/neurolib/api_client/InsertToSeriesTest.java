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

public class InsertToSeriesTest extends NeurolibTestCase {

    @Test
    public void testInsertToSeries() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail when inserting existing item into existing set'
        resp2 = this.client.send(new AddItem("new_item"));
        resp = this.client.send(new InsertToSeries("entity_id","item","new_item",3));
        // it 'does not fail when cascadeCreate is used'
        resp = this.client.send(new InsertToSeries("new_set","item","new_item2",1).setCascadeCreate(true));
        // it 'really inserts item to the set'
        resp2 = this.client.send(new AddItem("new_item3"));
        resp = this.client.send(new InsertToSeries("entity_id","item","new_item3",2));
        try {
            this.client.send(new InsertToSeries("entity_id","item","new_item3",2));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
