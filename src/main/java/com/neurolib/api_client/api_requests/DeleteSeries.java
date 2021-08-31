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
 * Deletes the series of given `seriesId` from the database.
 * Deleting a series will only delete assignment of items to it, not the items themselves!
 */
public class DeleteSeries extends Request {

    /**
     * ID of the series to be deleted.
     */
    protected String seriesId;

    /**
     * Construct the request
     * @param seriesId ID of the series to be deleted.
     */
    public DeleteSeries (String seriesId) {
        this.seriesId = seriesId;
        this.timeout = 1000;
    }


    public String getSeriesId() {
         return this.seriesId;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.DELETE;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/series/%s", this.seriesId);
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
