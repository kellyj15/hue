/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translators;

import Model.UserInfo;

/**
 *
 * @author luod1
 */
public interface UserInterface {
    public boolean isExist_User(String _user, String _password);
    
    public boolean insertUser(UserInfo _user);
    
    public String findEmail (String _username);
    
    public boolean findUserName(String _username);
    
    public boolean isExistEmail (String _email);
    
    public String findPassword(String _username);
    
     public UserInfo getUser(String _username, String _password);
}
