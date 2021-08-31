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

public class ListUserDetailViewsTest extends InteractionsTestCase {

    @Test
    public void testListUserDetailViews() throws ApiException {
        DetailView [] resp;
        Object resp2;
        // it 'lists user interactions'
        resp = this.client.send(new ListUserDetailViews("user"));
        assertEquals(1, resp.length);
        assertEquals ("item",resp[0].getItemId());
        assertEquals ("user",resp[0].getUserId());
    }
}
