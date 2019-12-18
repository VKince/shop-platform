package mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import javax.mail.*;
import javax.mail.Message.RecipientType;
public class mailutils {
	public static void sendmail(String email,String emailMsg)
	throws AddressException,MessagingException{
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "false");
		Authenticator auth= new Authenticator() {
			public PasswordAuthentication getPasswordAuthtication() {
				return new PasswordAuthentication("504254790@qq.com","vmdlqjquvaycbgie");
			}
		};
		Session session =Session.getInstance(props, auth);
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress("504254790@qq.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		message.setSubject("¹ºÂò³É¹¦");
		message.setContent(emailMsg,"text/html;charset=utf-8");
		Transport.send(message);
	}
}
