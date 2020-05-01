package Habit_API;

/**
 * This translator class connector for sendGmail API
 * @author luod1
 */
public class GmailApapter implements GmailInterface{
    
    GmailInterface send = new SendGmailApi();
    
    @Override
    public boolean sendOneMail(String _sentTo, String _mailTitle, String _mailContent) {
        return send.sendOneMail(_sentTo, _mailTitle, _mailContent);
    }
    
}
