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

public class AddGroupBatchTest extends NeurolibTestCase {

    @Test
    public void testAddGroup() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new AddGroup("valid_id"),
            new AddGroup("***not_valid$$$"),
            new AddGroup("valid_id2"),
            new AddGroup("valid_id2")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals(400,responses[1].getStatusCode());
        assertEquals(201,responses[2].getStatusCode());
        assertEquals(409,responses[3].getStatusCode());
    }
}
