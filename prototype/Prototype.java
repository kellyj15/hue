package prototype;
/*
 * A class for prototyping facebook integration.
 * Tests the "post to wall" functionality for the habit tracker application.
 * Date last edited: 2-18-2020
 * @author Jesse Carter
 */

import com.restfb.*;
import com.restfb.types.User;
import com.restfb.types.FacebookType;

public class Prototype {

    // The application ID number is created by facebook and does not change.
    private static String appID = "174020750705484";
    // The access token is created by facebook and is unique to a user. This changes over time.
    private static String accessToken = "EAACeRV0Hg0wBABZBC7ZAUJ7uvikCbGjPzhNJ4tMnq4ZAPZCl9Vu3FudfBp3moFEkMd1hKOjh3NCxcfe1pfaTOSpgQAnZCw1RufqSUZCBNVPHU2qI4MVV1VFUrTgWdTZBfL8HpplJ6JYwaJ75HdXg4BwE2HGF0RqdlCrTkdqowZC00ZBAu7Q35FbUXnfTxT3lZCio0ZD";
    private static String appSecret = "b098e235d848f263962c709b91340102";
    private static String clientToken = "58a0b0d59e6b04e52891e5fb1ab8b426";
    private static String authURL = " ";



    public static void main (String[] args) {
        // Create a facebook client to interact with
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.LATEST);
        //Instantiate the user related to the accesstoken.
        User me = fbClient.fetchObject("me", User.class);
        //Print Users name
        System.out.println("User name: " + me.getName());
        //Attempt to post a text-only status to the user's feed.
        //FacebookType response = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", "Public API test post!"));
        //System.out.println("fb.com/" + response.getId());
    }
}
