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

public class GetItemPropertyInfoTest extends NeurolibTestCase {

    @Test
    public void testGetItemPropertyInfo() throws ApiException {
        PropertyInfo  resp;
        Object resp2;
        // it 'does not fail with existing properties'
        resp = this.client.send(new GetItemPropertyInfo("int_property"));
        assertEquals ("int",resp.getType());
        resp = this.client.send(new GetItemPropertyInfo("str_property"));
        assertEquals ("string",resp.getType());
    }
}
