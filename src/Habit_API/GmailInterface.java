package Habit_API;


/**
 * translator class for gmail api
 *defines the methods that need to be implemented for any
 * @author dan
 */
public interface GmailInterface {

    public boolean sendOneMail(String _sentTo, String _mailTitle, String _mailContent);
}
