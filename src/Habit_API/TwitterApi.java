package Habit_API;

/**
 * Class is TwitterApi, to connect Twitter and get authorization from user
 *
 * @author luod1
 */
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApi implements TwitterInterface {

    //Also denoted as "Consumer Key"
    private static final String APIKEY = "vi3H0nrlnxG4zVUbbI3pFFVt2";
    //Also denoted as "Consumer Key Secret"
    private static final String APIKEYSECRET = "l2xGFfN6OMMC595uxgVPsnUKEPUXR5SzMtgCWbfpBEbzycoa5E";

    Twitter twitter = null;

    //public static String pin ="";
    @Override
    public Twitter connectTwitter() {
        //Create a configuration builder to set properties related to authentication.
        ConfigurationBuilder builder = new ConfigurationBuilder();

        //Set the consumer key and secret - this will change based on who is logged in. Key used is for the test twitter account.
        builder.setOAuthConsumerKey(APIKEY); //consumer_key  
        builder.setOAuthConsumerSecret(APIKEYSECRET); //consumer_secret  

        //Create the twitter object that can be used to interact with the twitter api based on the selected params
        Configuration conf = builder.build();
        TwitterFactory tf = new TwitterFactory(conf);

        Twitter twitter = tf.getInstance();

        return twitter;
    }

    /**
     * *
     * get user's access token
     *
     * @return
     */
    @Override
    public AccessToken getAccessToken() {
        this.twitter = connectTwitter();
        this.twitter.setOAuthAccessToken(null);
        AccessToken accessToken = null;

        try {
            RequestToken requestToken = this.twitter.getOAuthRequestToken();

            System.out.println(requestToken.getAuthorizationURL());
            try {
                // open the request web
                Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
            } catch (UnsupportedOperationException | IOException ignore) {
            } catch (URISyntaxException e) {
                throw new AssertionError(e);
            }
            // get authorization pin from user
            String pin = JOptionPane.showInputDialog(null,
                    "Do you want to authorization?",
                    "Enter authorization pin:",
                    JOptionPane.QUESTION_MESSAGE);
            if (pin == null || pin.equals("")) {
                System.out.println("Unable to get the access token.");
                return null;
            } else {
                try {
                    if (pin.length() > 0) {
                        accessToken = this.twitter.getOAuthAccessToken(requestToken, pin);
                    } else {
                        accessToken = this.twitter.getOAuthAccessToken(requestToken);
                    }
                } catch (TwitterException te) {
                    if (401 == te.getStatusCode()) {
                        System.out.println("Unable to get the access token.");
                    } else {
                        System.out.println("Unable to get the access token.");
                    }
                }

                System.out.println("Got access token.");
                System.out.println("Access token: " + accessToken.getToken());
                System.out.println("Access token secret: " + accessToken.getTokenSecret());

                return accessToken;
            }
        } catch (TwitterException te) {
            //te.printStackTrace();
            System.out.println("Failed to get accessToken: " + te.getMessage());
        }

        return accessToken;
    }

}
