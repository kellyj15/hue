package prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Prototype class to test twitter API integration. The goal of this
 * is to be able to post status updates (tweets) to a users twitter account
 * after logging in via a redirect to twitter.
 * @author Jesse
 * Date last updated: 3-11-2020
 */
public class TwitterPrototype {
    //Also denoted as "Consumer Key"
    private static final String APIKEY = "HrX2VEQES1kBzxAUV8eEhxK3o";
    //Also denoted as "Consumer Key Secret"
    private static final String APIKEYSECRET = "K8ynFj6H3QDXqW71rcRoQsSKcnZgY4Pjg6VTn7lvGHMZOnDPtZ";
    private static final String ACCESSTOKEN = "1229891356459274240-05uqY0tMqyCMbE7yERveatpJgkJJ7W";
    private static final String ACCESSTOKENSECRET = "a7gbhlhjZzSmG1dKdAb6AfDXKN79KdGnRBq1Q2eUJe5nm";
    private static final String HOSTURL = "https://api.twitter.com/1.1/statuses/update.json";

    public static void main(String[] args) throws TwitterException, IOException {
        //postFromDev("Test Tweet 2");
        //postFromUser("User Login Test Post");


    }

    public static void postFromUser(String _tweet) {
        //May no longer work on desktop applications. 
//        //Attempt to allow a user to login and post to their account
//        ConfigurationBuilder userCB = new ConfigurationBuilder();
//        userCB.setDebugEnabled(true);
//        userCB.setOAuthConsumerKey(APIKEY);
//        userCB.setOAuthConsumerSecret(APIKEYSECRET);
//
//        //---- TRY HERE ----
//        TwitterFactory fact = new TwitterFactory(userCB.build());
//        Twitter twit = fact.getInstance();
//        //----NESTED TRY HERE----
//        System.out.println("**Marker 1**");
//        RequestToken requestToken = twit.getOAuthRequestToken();
//        System.out.println("Request token received: " + requestToken.getToken());
//        System.out.println("RT Secret: " + requestToken.getTokenSecret());
//
//        AccessToken accessToken = null;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //--WHILE LOOP UNTILL SUCCSS---
//        while(accessToken == null) {
//            System.out.println("Auth URL:");
//            System.out.println(requestToken.getAuthorizationURL());
//            //GET PIN
//            System.out.print("Enter PIN: ");
//            String pin = br.readLine();
//            twit.getOAuthAccessToken(requestToken);
//            /**
//            try {
//                accessToken = twit.getOAuthAccessToken(requestToken);
//            } catch (TwitterException te) {
//                if (401 == te.getStatusCode()) {
//                    System.out.println("Unable to get access Token.");
//                } else {
//                    te.printStackTrace();
//                }
//            }
//            */
//        }
//
//
//        System.out.println("Got Access Token: " + accessToken.getToken());
//        System.out.println("Token Sec: " + accessToken.getTokenSecret());
//        System.out.println("Twitter Handle: @" + twit.getScreenName());
//        twit.updateStatus("Test tweet from Login");
//        System.out.println("SUCCESS!");
    }
    public static void postFromDev(String _tweet) throws TwitterException {
        //Create a configuration builder to set properties related to authentication.
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        //Set the consumer key and secret - this will change based on who is logged in. Key used is for the test twitter account.
        cb.setOAuthConsumerKey(APIKEY);
        cb.setOAuthConsumerSecret(APIKEYSECRET);
        //Set the access token for the twitter API
        cb.setOAuthAccessToken(ACCESSTOKEN);
        cb.setOAuthAccessTokenSecret(ACCESSTOKENSECRET);
        //Create the twitter object that can be used to interact with the twitter api based on the selected params
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        //Get the twitter handle of the currently logged in user.
        System.out.println("@" + twitter.getScreenName());
        twitter.updateStatus(_tweet);
        System.out.println("Sent tweet succesfully!");
    }
}