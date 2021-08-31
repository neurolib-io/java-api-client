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

public class ListSeriesItemsBatchTest extends NeurolibTestCase {

    @Test
    public void testListSeriesItems() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new ListSeriesItems("entity_id")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(1, ((SeriesItem []) responses[0].getResponse()).length);
        assertEquals ("entity_id",((SeriesItem []) responses[0].getResponse())[0].getItemId());
        assertEquals ("item",((SeriesItem []) responses[0].getResponse())[0].getItemType());
    }
}
