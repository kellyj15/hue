package Database;

import Model.TwitterUserInfo;

/**
 * database twitter interface
 *defines the methods that need to be implemented for any
 * @author luod1
 */
public interface DBTwitterInterface {
    
    public TwitterUserInfo selectTwitterUser(int _twitterId);
    
    public boolean insertTwitterUser(TwitterUserInfo _user);
    
    public boolean updateAccessToken(TwitterUserInfo _user);
    
}
