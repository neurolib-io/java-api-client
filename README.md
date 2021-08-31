# Neurolib API Client

A Java client (SDK) for easy use of the [Neurolib](https://www.neurolib.io) recommendation API.

If you don't have an account at Neurolib yet, you can create a free account [here](https://www.neurolib.io).

Documentation of the API can be found at [www.neurolib.io/pages/documentation](https://www.neurolib.io/pages/documentation/).

## Installation

The client is available in the [Maven Central Repository](https://mvnrepository.com/artifact/com.neurolib/api-client/), so you just need to add the following `<dependency>` entry to your project's POM:
```xml
    <dependency>
        <groupId>com.neurolib</groupId>
        <artifactId>api-client</artifactId>
        <version>3.2.0</version>
    </dependency>
```

## Examples

### Basic example

Examples are located in [src/examples](https://github.com/neurolib-io/java-api-client/tree/master/src/examples/java/com/neurolib/api_client/examples/).

```java
package com.neurolib.api_client.examples;

import com.neurolib.api_client.NeurolibClient;
import com.neurolib.api_client.api_requests.*;
import com.neurolib.api_client.bindings.RecommendationResponse;
import com.neurolib.api_client.bindings.Recommendation;
import com.neurolib.api_client.exceptions.ApiException;

import java.util.ArrayList;
import java.util.Random;

public class BasicExample {
    public static void main(String[] args) {

        NeurolibClient client = new NeurolibClient("--my-database-id--", "--db-private-token--");
        try {

            final int NUM = 100;
            // Generate some random purchases of items by users
            final double PROBABILITY_PURCHASED = 0.1;
            Random r = new Random();
            ArrayList<Request> addPurchaseRequests = new ArrayList<Request>();
            for (int i = 0; i < NUM; i++)
                for (int j = 0; j < NUM; j++)
                    if (r.nextDouble() < PROBABILITY_PURCHASED) {

                        AddPurchase request = new AddPurchase(String.format("user-%s", i),String.format("item-%s", j))
                                                    .setCascadeCreate(true); // Use cascadeCreate parameter to create
                                                                             // the yet non-existing users and items
                        addPurchaseRequests.add(request);
                    }

            System.out.println("Send purchases");
            client.send(new Batch(addPurchaseRequests)); //Use Batch for faster processing of larger data

            // Get 5 recommendations for user 'user-25'
            RecommendationResponse recommendationResponse = client.send(new RecommendItemsToUser("user-25", 5));
            System.out.println("Recommended items:");
            for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());

            // User scrolled down - get next 3 recommended items
            recommendationResponse = client.send(new RecommendNextItems(recommendationResponse.getRecommId(), 3));
            System.out.println("Next recommended items:");
            for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());

        } catch (ApiException e) {
            e.printStackTrace();
            //use fallback
        }
    }
}
```

### Using property values

```java
package com.neurolib.api_client.examples;

import com.neurolib.api_client.NeurolibClient;
import com.neurolib.api_client.api_requests.*;
import com.neurolib.api_client.bindings.RecommendationResponse;
import com.neurolib.api_client.bindings.Recommendation;
import com.neurolib.api_client.bindings.SearchResponse;
import com.neurolib.api_client.exceptions.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ItemPropertiesExample {
    public static void main(String[] args) {

        NeurolibClient client = new NeurolibClient("--my-database-id--", "--db-private-token--");

        try {
            client.send(new ResetDatabase()); // Clear everything from the database

            /*
            We will use computers as items in this example
            Computers have four properties
              - price (floating point number)
              - number of processor cores (integer number)
              - description (string)
              - image (url of computer's photo)
            */

            client.send(new AddItemProperty("price", "double"));
            client.send(new AddItemProperty("num-cores", "int"));
            client.send(new AddItemProperty("description", "string"));
            client.send(new AddItemProperty("image", "image"));

            // Prepare requests for setting a catalog of computers
            final ArrayList<Request> requests = new ArrayList<Request>();
            final int NUM = 100;
            final Random rand = new Random();

            for(int i=0; i<NUM; i++)
            {
                final String itemId = String.format("computer-%s",i);
                final SetItemValues req = new SetItemValues(
                        itemId,
                        //values:
                        new HashMap<String, Object>() {{
                            put("price", 600.0 + 400*rand.nextDouble());
                            put("num-cores", 1 + rand.nextInt(7));
                            put("description", "Great computer");
                            put("image", String.format("http://examplesite.com/products/%s.jpg", itemId));
                        }}
                ).setCascadeCreate(true);  // Use cascadeCreate for creating item
                // with given itemId, if it doesn't exist;
                requests.add(req);
            }
            client.send(new Batch(requests)); // Send catalog to the recommender system

            // Generate some random purchases of items by users
            final double PROBABILITY_PURCHASED = 0.02;
            ArrayList<Request> addPurchaseRequests = new ArrayList<Request>();
            for (int i = 0; i < NUM; i++)
                for (int j = 0; j < NUM; j++)
                    if (rand.nextDouble() < PROBABILITY_PURCHASED) {
                        AddPurchase req = new AddPurchase(String.format("user-%s", i),String.format("computer-%s", j))
                                .setCascadeCreate(true); //use cascadeCreate to create the users
                        addPurchaseRequests.add(req);
                    }
            client.send(new Batch(addPurchaseRequests)); // Send purchases to the recommender system


            // Get 5 recommendations for user-42, who is currently viewing computer-6
            // Recommend only computers that have at least 3 cores
            RecommendationResponse recommendationResponse = client.send(
                new RecommendItemsToItem("computer-6", "user-42", 5)
                    .setFilter(" 'num-cores'>=3 "));
            System.out.println("Recommended items with at least 3 processor cores:");
            for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());

            // Recommend only items that are more expensive then currently viewed item (up-sell)
            recommendationResponse = client.send(new RecommendItemsToItem("computer-6", "user-42", 5)
                    .setFilter(" 'price' > context_item[\"price\"] "));

            System.out.println("Recommended up-sell items:");
            for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());


            // Filters, boosters and other settings can be set also in the Admin UI (admin.neurolib.io)
            // when scenario is specified
            recommendationResponse = client.send(
                new RecommendItemsToItem("computer-6", "user-42", 5).setScenario("product_detail")
            );

            // Perform personalized full-text search with a user's search query (e.g. "computers")
            SearchResponse searchResponse = client.send(
              new SearchItems("user-42", "computers", 5)
              );
            System.out.println("Search matches:");
            for(Recommendation rec: searchResponse) System.out.println(rec.getId());

        } catch (ApiException e) {
            e.printStackTrace();
            //Use fallback
        }
    }
}
```

## Exception handling

Various errors can occur while processing request, for example because of adding an already existing item or submitting interaction of nonexistent user without *setCascadeCreate(true)*. These errors lead to throwing the *ResponseException* by the *send* method of the client. Another reason for throwing an exception is a timeout. *ApiException* is the base class of both *ResponseException* and *ApiTimeoutException*.

We are doing our best to provide the fastest and most reliable service, but production-level applications must implement a fallback solution since errors can always happen. The fallback might be, for example, showing the most popular items from the current category, or not displaying recommendations at all.