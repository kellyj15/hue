package UserModel;


/**
 * class for users information
 * @author dan
 */
public class UserInfo{
    
    private Integer id;
    private String username;
    private String password;
    
    /**
     * Constructor when information are not given.
     */
    public UserInfo(){}
    
    /***
     * Constructor when information are given
     * @param _id
     * @param _username
     * @param _password 
     */
    public UserInfo(int _id,String _username,String _password) { 
	this.id = _id;
	this.username = _username;
	this.password = _password;
    }
    
    



    //==========================GETTERS==========================

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //==========================SETTERS==========================

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
