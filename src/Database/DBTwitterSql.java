package Database;

/**
 * this class is for the twitter database modify
 * @author dan
 */
import Model.TwitterUserInfo;
import java.sql.ResultSet;


public class DBTwitterSql extends DatabaseConnect implements DBTwitterInterface {

    /***
     * use id to find twitter user at database 
     * @param _twitterId
     * @return 
     */
    @Override
    public TwitterUserInfo selectTwitterUser(int _twitterId) {
        System.out.println("connect to Twitter user");
        String sql = "select * from twitter_user where twitter_user_id=?";

        Object[] obj = {_twitterId};
        TwitterUserInfo user = null;
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                user.setTwitter_user_id(rs.getInt("twitter_user_id"));
                user.setTwitter_screen_name(rs.getString("screen_name"));
                user.setAccess_token(rs.getString("access_token"));
                user.setAccess_token_secret(rs.getString("access_token_secret"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return user;
    }

    /***
     * insert new twitter user  
     * @param _user
     * @return 
     */
    @Override
    public boolean insertTwitterUser(TwitterUserInfo _user) {
        System.out.println("connect to Insert TwitterUser");
        String sql = "INSERT into twitter_user (twitter_user_id,screen_name,access_token,access_token_secret) VALUES (?,?,?,?)";
        Object[] obj = {
            _user.getTwitter_user_id(), _user.getTwitter_screen_name(),
            _user.getAccess_token(), _user.getAccess_token_secret()
        };
        boolean insert = this.executeUpdate(sql, obj);
        return insert;
    }
    
    /**
     * update the access token 
     * @param _user
     * @return 
     */
    @Override
    public boolean updateAccessToken(TwitterUserInfo _user) {
        System.out.println("connect to update Twitter accessToken");
        String sql = "UPDATE twitter_user set access_token=?,access_token_secret=? where twitter_user_id =?";
        Object[] obj ={
                _user.getAccess_token(), _user.getAccess_token_secret(), _user.getTwitter_user_id()
        };
        
        boolean update = this.executeUpdate(sql, obj);
        return update;
    }

}
