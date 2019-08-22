package Service.registrationDetails;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * A utility class for sending e-mail messages
 */

public class EmailUtility {
    public static void sendMail(String host, String port, final String username, final String password,
                                String toAddress, String subject, String message) throws AddressException, MessagingException {

        // sets SMTP server properties
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            // creates a new session with an authenticator
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            Session session = Session.getInstance(properties, auth);

            // creates a new e-mail message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(message);

            // sends the e-mail
            Transport.send(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
