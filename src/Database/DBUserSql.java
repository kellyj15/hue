package Database;

/**
 * this class is for the habit user database modify
 *
 * @author luod1
 */
import Model.UserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUserSql extends DatabaseConnect implements DBUserInterface {

    /**
     * *
     * find user is exist or not
     *
     * @param _username
     * @param _password
     * @return
     */
    @Override
    public boolean isExist_User(String _username, String _password) {
        String sql = "select * from user";
        ResultSet rs = this.executeQuery(sql);
        try {
            while (rs.next()) {
                if (rs.getString("username").equals(_username)
                        && rs.getString("password").equals(_password)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println("find user sql faild");
        }

        return false;
    }

    /**
     * *
     * insert the new user
     *
     * @param _user
     * @return
     */
    @Override
    public boolean insertUser(UserInfo _user) {
        System.out.println("connect to Insert User");
        String sql = "INSERT into user (uuid, username,password,email) VALUES (?,?,?,?)";
        Object[] obj = {
            _user.getId(), _user.getUsername(), _user.getPassword(), _user.getEmail()
        };
        boolean insert = this.executeUpdate(sql, obj);
        return insert;
    }

    /**
     * use user name to find user's email
     *
     * @param _username
     * @return
     */
    @Override
    public String findEmail(String _username) {
        System.out.println("connnect-findEmail");
        String sql = "select * from user where username=?";
        Object[] obj = {_username};
        ResultSet rs = this.executeQuery(sql, obj);

        try {
            while (rs.next()) {
                String email = rs.getString("email");
                return email;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find username is exist or not
     *
     * @param _username
     * @return
     */
    @Override
    public boolean findUserName(String _username) {
        System.out.println("connnect-findUserName");

        String sql = "select * from user where username=?";

        Object[] obj = {_username};
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                if (rs.getString("username").equals(_username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * find email is exist or not
     *
     * @param _email
     * @return
     */
    @Override
    public boolean isExistEmail(String _email) {
        System.out.println("connnect-find email");

        String sql = "select * from user where email=?";

        Object[] obj = {_email};
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                if (rs.getString("email").equals(_email)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * find password by use username
     *
     * @param _username
     * @return
     */
    @Override
    public String findPassword(String _username) {
        System.out.println("connnect-findPassword");

        String sql = "select * from user where username=?";

        Object[] obj = {_username};

        ResultSet rs = this.executeQuery(sql, obj);

        try {
            while (rs.next()) {
                String password = rs.getString("password");
                return password;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * get the signed user information 
     * @param _username
     * @param _password
     * @return 
     */
    @Override
    public UserInfo getUser(String _username, String _password) {
        String sql = "select * from user where username=? and password=? ";
        Object[] obj = {_username, _password};
        ResultSet rs = this.executeQuery(sql, obj);
        UserInfo user = new UserInfo();
        try{
            while(rs.next()){
               user.setId(rs.getString("uuid"));
               user.setUsername(rs.getString("username"));
               user.setPassword(rs.getString("password"));
               user.setEmail(rs.getString("email"));
            }
            return user;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
