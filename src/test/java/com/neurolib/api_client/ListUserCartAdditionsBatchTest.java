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

public class ListUserCartAdditionsBatchTest extends InteractionsTestCase {

    @Test
    public void testListUserCartAdditions() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new ListUserCartAdditions("user")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(1, ((CartAddition []) responses[0].getResponse()).length);
        assertEquals ("item",((CartAddition []) responses[0].getResponse())[0].getItemId());
        assertEquals ("user",((CartAddition []) responses[0].getResponse())[0].getUserId());
    }
}
