package Habit_API;



/**
 * translator class for api
 *
 * @author dan
 */
public interface GmailInterface {

    public boolean sendOneMail(String _sentTo, String _mailTitle, String _mailContent);
}
