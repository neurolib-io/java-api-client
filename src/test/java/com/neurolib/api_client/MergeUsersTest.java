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

public class MergeUsersTest extends NeurolibTestCase {

    @Test
    public void testMergeUsers() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with existing users'
        resp2 = this.client.send(new AddUser("target"));
        resp = this.client.send(new MergeUsers("target","entity_id"));
        // it 'fails with nonexisting user'
        try {
            this.client.send(new MergeUsers("nonex_id","entity_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
