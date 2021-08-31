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

public class DeleteAllSearchSynonymsBatchTest extends NeurolibTestCase {

    @Test
    public void testDeleteAllSearchSynonyms() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new DeleteAllSearchSynonyms()
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
    }
}
