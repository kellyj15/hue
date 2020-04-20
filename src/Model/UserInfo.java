package Model;

import java.util.UUID;


/**
 * class for users information
 * @author dan
 */
public class UserInfo {
    
    private String uuid;
    
    private String username;
    private String password;
    private String email;
    
    /**
     * Constructor when information are not given.
     */
    public UserInfo() {}
    
    /***
     * Constructor when information are given
     * @param _id     
     * @param _username
     * @param _password 
     * @param _email 
     */
    public UserInfo(String _id, String _username,String _password,String _email) { 
	this.uuid = _id;
       
	this.username = _username;
	this.password = _password;
        this.email = _email;
    }
    
    
    //==========================GETTERS==========================

    public String getId() {
        return this.uuid;
    }
    
    
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public String getEmail() {
        return this.email;
    }
    //==========================SETTERS==========================

    public void setId(String _id) {
        
        this.uuid =_id;
    }
    
    
    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }
    
    public void setEmail(String _email){
        this.email = _email;
    }
    
     
}
