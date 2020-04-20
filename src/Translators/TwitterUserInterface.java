/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translators;

import Model.TwitterUserInfo;

/**
 *
 * @author luod1
 */
public interface TwitterUserInterface {

    public TwitterUserInfo selectTwitterUser(int _twitterId);

    public boolean insertTwitterUser(TwitterUserInfo _user);

    public boolean updateAccessToken(TwitterUserInfo _user);
}
