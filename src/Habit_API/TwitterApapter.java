package Habit_API;
/**
 *This translator class connector for twitter API
 * @author luod1
 */
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;


public class TwitterApapter implements TwitterInterface{
    
    TwitterInterface twf = new TwitterApi();
    
    @Override
    public Twitter connectTwitter() {
       return twf.connectTwitter();
    }

    @Override
    public AccessToken getAccessToken() {
        return twf.getAccessToken();
    }
    
}
