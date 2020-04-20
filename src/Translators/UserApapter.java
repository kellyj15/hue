/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translators;

import Database.DBUserSql;
import Model.UserInfo;
import Database.DBUserInterface;

/**
 *
 * @author luod1
 */
public class UserApapter implements UserInterface{
    
    DBUserInterface ts = new DBUserSql();
    
    @Override
    public boolean isExist_User(String _user, String _password) {
       return ts.isExist_User(_user, _password);
    }

    @Override
    public boolean insertUser(UserInfo _user) {
       return ts.insertUser(_user);
    }

    @Override
    public String findEmail(String _username) {
        return ts.findEmail(_username);
    }

    @Override
    public boolean findUserName(String _username) {
       return ts.findUserName(_username);
    }

    @Override
    public String findPassword(String _username) {
       return ts.findPassword(_username);
    }

    @Override
    public boolean isExistEmail(String _email) {
       return ts.isExistEmail(_email);
    }

    @Override
    public UserInfo getUser(String _username, String _password) {
        return ts.getUser(_username, _password);
    }
    
    
}
