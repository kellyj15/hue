package Database;


/**
 * database user interface 
 * defines the methods that need to be implemented for any
 * @author luod1
 */
import Model.UserInfo;


public interface DBUserInterface {
    
    public boolean isExist_User(String _username, String _password);
    
    public UserInfo getUser(String _username, String _password);
    
    public boolean insertUser(UserInfo _user);
    
    public String findEmail (String _username);
    
    public boolean findUserName(String _username);
    
    public boolean isExistEmail (String _email);
    
    public String findPassword(String _username);
}
