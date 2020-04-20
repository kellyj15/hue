package Model;


/**
 * This class is Twitter User information 
 * @author luod1
 */
public class TwitterUserInfo {

    private int Twitter_user_id;
    private String Twitter_screen_name;//user username
    private String Access_token;
    private String Access_token_secret;

    public TwitterUserInfo() {

    }

    public TwitterUserInfo(int _TwitterUserId, String _TwitterScreenName, String _AccessToken, String _AccessTokenSecret) {
        this.Twitter_user_id = _TwitterUserId;
        this.Twitter_screen_name = _TwitterScreenName;
        this.Access_token = _AccessToken;
        this.Access_token_secret = _AccessTokenSecret;
    }

    
    
    
//==========================GETTERS==========================
    public int getTwitter_user_id() {
        return Twitter_user_id;
    }

    public String getTwitter_screen_name() {
        return Twitter_screen_name;
    }

    public String getAccess_token() {
        return Access_token;
    }

    public String getAccess_token_secret() {
        return Access_token_secret;
    }
    
//==========================SETTERS==========================
    public void setTwitter_user_id(int _TwitterUserId) {
        this.Twitter_user_id = _TwitterUserId;
    }

    public void setTwitter_screen_name(String _TwitterScreenName) {
        this.Twitter_screen_name = _TwitterScreenName;
    }

    public void setAccess_token(String _AccessToken) {
        this.Access_token = _AccessToken;
    }

    public void setAccess_token_secret(String _AccessTokenSecret) {
        this.Access_token_secret = _AccessTokenSecret;
    }

}
