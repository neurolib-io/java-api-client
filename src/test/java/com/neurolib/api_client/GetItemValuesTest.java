package com.neurolib.api_client;

import com.neurolib.api_client.api_requests.GetItemValues;
import com.neurolib.api_client.exceptions.ApiException;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetItemValuesTest extends NeurolibTestCase {

    @Test
    public void testGetItemValues() throws ApiException {
        GetItemValues req;
        // it 'gets values'
        req = new GetItemValues("entity_id");
        Map<String, Object> resp = this.client.send(req);
        assertEquals (42,resp.get("int_property"));
        assertEquals ("hello",resp.get("str_property"));
    }
}
