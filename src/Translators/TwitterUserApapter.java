package Translators;

/**
 * this class is translator to connect the twitter user database 
 */
import Database.DBTwitterSql;
import Model.TwitterUserInfo;
import Database.DBTwitterInterface;

/**
 *
 * @author luod1
 */
public class TwitterUserApapter implements TwitterUserInterface{
    
    DBTwitterInterface dt = new DBTwitterSql();
    
    @Override
    public TwitterUserInfo selectTwitterUser(int _twitterId) {
       return dt.selectTwitterUser(_twitterId);
    }

    @Override
    public boolean insertTwitterUser(TwitterUserInfo _user) {
        return dt.insertTwitterUser(_user);
    }

    @Override
    public boolean updateAccessToken(TwitterUserInfo _user) {
        return dt.updateAccessToken(_user);
    }
    
}
