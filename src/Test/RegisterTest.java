package Test;

/**
 * test the register 
 * @author dan
 */
import GuiAndControllers.RegisterFrame;
import Model.UserInfo;
import Translators.UserApapter;
import Translators.UserInterface;


public class RegisterTest {

    UserInterface tms = new UserApapter();

    public RegisterTest() {
    }

    /**
     * test the validate email method
     * @param _TestUser
     * @return 
     */
    public boolean testValidateEmail(UserInfo _TestUser) {
        //System.out.println("validateEmail");
        String _email = _TestUser.getEmail();
        RegisterFrame instance = new RegisterFrame();
        boolean result = instance.validateEmail(_email);
        return result;

    }

    /**
     * test validate password method
     * @param _TestUser
     * @return 
     */
    public boolean testValidatePassword(UserInfo _TestUser) {
        //System.out.println("validatePassword");
        String _password = _TestUser.getPassword();
        RegisterFrame instance = new RegisterFrame();
        boolean result = instance.validatePassword(_password);
        return result;
    }

    /**
     * test validate username method
     * @param _TestUser
     * @return 
     */
    public boolean testValidateUsername(UserInfo _TestUser) {
        //System.out.println("validateUsername");
        String _username = _TestUser.getUsername();
        RegisterFrame instance = new RegisterFrame();
        boolean result = instance.validateUsername(_username);
        return result;
    }

    /**
     * test email is taken method
     * @param _TestUser
     * @return 
     */
    public boolean testEmailIsTaken(UserInfo _TestUser) {
        //System.out.println("emailIsTaken");
        String _email = _TestUser.getEmail();
        RegisterFrame instance = new RegisterFrame();
        boolean result = instance.emailIsTaken(_email);
        return result;
    }

    /**
     * test register user 
     * @param _TestUser
     * @return 
     */
    public boolean testInsert(UserInfo _TestUser) {
        if (this.testValidateUsername(_TestUser) && this.testValidatePassword(_TestUser)
                && this.testValidateEmail(_TestUser) && this.testEmailIsTaken(_TestUser)) {
            boolean insertUser = tms.insertUser(_TestUser);
            if (insertUser) {
                System.out.println("insert Test success");
                return true;
            } else {
                System.out.println("insert Test faild");
                return false;
            }

        } else {
            System.out.println("register infomation has error");
            return false;
        }
    }

    /**
     * run the register test
     * @param rag 
     */
    public static void main(String rag[]) {
        RegisterTest rgtest = new RegisterTest();
        UserInfo u = new UserInfo("2248b43a-1459-4368-b3aa-5a9d73ef344a", "admin2", "rootroot", "admin2@gmail.com");
        boolean register = rgtest.testInsert(u);
        System.out.println(register);
    }

}
