package Habit_API;

/***
 * This class is using Gmail to send email to user
 * @author dan
 */


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendGmailApi implements GmailInterface{
    //gmail api setting
    public static final String mail_smtp_auth = "true";
    public static final String mail_transport_protocol = "smtp";
    public static final String mail_smtp_ssl_enable = "true";
    public static final String mail_smtp_socketFactory_class = "javax.net.ssl.SSLSocketFactory";
    public static final String mail_InternetAddress = "luod1219@gmail.com";// need to modify
    public static final String mail_Host = "smtp.gmail.com";
    public static final int mail_port = 465;
    public static final String mail_username = "luod1219@gmail.com";//need to modify
    public static final String mail_password = "******";  // need to modify

  /***
   * send email to user
   * @param _sentTo user email address
   * @param _mailTitle  mail subject
   * @param _mailContent email content
   * @return 
   */
    @Override
    public boolean sendOneMail(String _sentTo, String _mailTitle, String _mailContent) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", mail_smtp_auth);
        props.setProperty("mail.transport.protocol", mail_transport_protocol);
        props.setProperty("mail.smtp.ssl.enable", mail_smtp_ssl_enable);
        props.put("mail.smtp.socketFactory.class", mail_smtp_socketFactory_class);

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        InternetAddress[] addres = new InternetAddress[1];
        try {
            // list recipient address
            addres[0] = new InternetAddress(_sentTo);
            // build new message
            MimeMessage msg = new MimeMessage(session);
            // from address
            msg.setFrom(new InternetAddress(mail_InternetAddress));
            // Create a mail recipient address and set it to the mail message
            msg.setRecipients(Message.RecipientType.TO, _sentTo);

            msg.setSubject(_mailTitle);
            //  add attachment
            Multipart multipart = new MimeMultipart();
            // add mail body
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(_mailContent);
            multipart.addBodyPart(contentPart);
            msg.setContent(multipart);
            // save 
            msg.saveChanges();
            // get transport
            Transport transport = session.getTransport();
            // connect 
            transport.connect(mail_Host, mail_port, mail_username, mail_password);
            // send msg 
            transport.sendMessage(msg, addres);

            
            transport.close();
        } catch (Exception e) {
            System.out.println("Send email error");
            return false;
        }
        return true;
    }

   
}
