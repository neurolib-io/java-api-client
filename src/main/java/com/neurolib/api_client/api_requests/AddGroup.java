package com.neurolib.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.neurolib.api_client.bindings.Logic;
import com.neurolib.api_client.util.HTTPMethod;

/**
 * Creates new group in the database.
 */
public class AddGroup extends Request {

    /**
     * ID of the group to be created.
     */
    protected String groupId;

    /**
     * Construct the request
     * @param groupId ID of the group to be created.
     */
    public AddGroup (String groupId) {
        this.groupId = groupId;
        this.timeout = 1000;
    }


    public String getGroupId() {
         return this.groupId;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.PUT;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/groups/%s", this.groupId);
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        return params;
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        return params;
    }

}
