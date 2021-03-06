package com.neurolib.api_client;

import com.neurolib.api_client.api_requests.*;
import com.neurolib.api_client.bindings.*;
import com.neurolib.api_client.exceptions.ApiException;


import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GetItemValuesBatchTest extends NeurolibTestCase {

    @Test
    public void testGetItemValues() throws ApiException {
        Request[] requests = new Request[] {
            new GetItemValues("entity_id")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
                assertEquals (42,((Map<String, Object>) responses[0].getResponse()).get("int_property"));
                assertEquals ("hello",((Map<String, Object>) responses[0].getResponse()).get("str_property"));
    }
}
