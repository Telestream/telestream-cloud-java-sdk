/*
 * Notifications API
 * Notifications API
 *
 * OpenAPI spec version: 2.0.0
 * Contact: cloudsupport@telestream.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.telestream.cloud.notifications;

import net.telestream.cloud.notifications.ApiException;
import net.telestream.cloud.notifications.Subscription;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NotificationsApi
 */
@Ignore
public class NotificationsApiTest {

    private final NotificationsApi api = new NotificationsApi();

    
    /**
     * Create a new subscription
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createSubscriptionTest() throws ApiException {
        Subscription subscription = null;
        api.createSubscription(subscription);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteSubscriptionTest() throws ApiException {
        String id = null;
        api.deleteSubscription(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listSubscriptionsTest() throws ApiException {
        List<Subscription> response = api.listSubscriptions();

        // TODO: test validations
    }
    
}
