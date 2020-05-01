package Database;
/**
 * database twitter interface
 *defines the methods that need to be implemented for any
 * @author dan
 */
import Model.TwitterUserInfo;


public interface DBTwitterInterface {
    
    public TwitterUserInfo selectTwitterUser(int _twitterId);
    
    public boolean insertTwitterUser(TwitterUserInfo _user);
    
    public boolean updateAccessToken(TwitterUserInfo _user);
    
}
