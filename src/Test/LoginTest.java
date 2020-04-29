package Test;

/**
 *test the login
 * @author dan
 */
import GuiAndControllers.LoginFrame;
import GuiAndControllers.MainHabitFrame;
import Model.ModeTranslators;
import Model.UserInfo;
import Translators.UserApapter;
import Translators.UserInterface;

public class LoginTest {

    /**
     * call the user apapter
     */
    UserInterface tms = new UserApapter();

    public LoginTest() {
    }

    /**
     * test the is exist method
     * @param _TestUser
     * @return 
     */
    public boolean testIsExist(UserInfo _TestUser) {
        LoginFrame instance = new LoginFrame();
        boolean result = instance.isExist(_TestUser.getUsername(), _TestUser.getPassword());
        return result;
    }

    /**
     * test the login
     * @param _TestUser
     * @return 
     */
    public boolean testLogin(UserInfo _TestUser) {
        boolean isExist = testIsExist(_TestUser);
        if (isExist) {
            ModeTranslators.user = tms.getUser(_TestUser.getUsername(), _TestUser.getPassword());
            System.out.println("Login test Success");
            return true;
        } else {
            System.out.println("login test Failed");
            return false;
        }
    }

    /**
     * run the login and open the habits frame
     * @param rag 
     */
    public static void main(String rag[]) {
        LoginTest lgtest = new LoginTest(); 
        UserInfo u = new UserInfo("2248b43a-1459-4368-b3aa-5a9d73ef341a","admin","rootroot","admin@gmail.com");
        boolean lg = lgtest.testLogin(u);
        System.out.println(lg);
        if(lg){
            new MainHabitFrame().setVisible(true);
        }
    }
}
