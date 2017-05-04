package POM;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class sendemail {

	ResourceBundle rb = ResourceBundle.getBundle("Elements");
	Logger log = Logger.getLogger("devpinoyLogger");
	
	final String username = "naman.agrawal@arcscorp.net";// Email address
	final String password = "vision78912";// Password
	String To=rb.getString("to");
	String BCC=rb.getString("bcc");
	String From=rb.getString("from");
	String htmlmessage_p2= "<ul><li>";
	String htmlmessage_p4="</li></ul><p>Thanks and Regards,</p><p>Naman Agrawal<br/>Quality Analyst</p>";
	String Subject_1="DailyTimeSheet for ";
	String oclist="</li></ul><ul><li>";
	Date now = new Date();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
	String currentdate=dateFormatter.format(now);
	String Subject = Subject_1+currentdate;
	String htmlmessage_p1= "<p>Hello Sir,</p><p>Greetings!</p><p>I am sending you my DailyTimeSheet for "+currentdate+".</p>";
	
	public void send(String summary1, String status1) {

		String htmlmessage_p3=summary1+" ("+status1.trim()+")";
		String htmlmessage = htmlmessage_p1+htmlmessage_p2+htmlmessage_p3+htmlmessage_p4;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.arcscorp.net");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC));
			message.setSubject(Subject);
			
			log.debug("Sent mail to: "+To);
			log.debug("Sent mail bcc: "+BCC);
			
			System.out.println("Sent mail to: "+To);
			System.out.println("Sent mail bcc "+BCC);
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);
			System.out.println("Email is sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void send(String summary1, String summary2, String status1, String status2) {

		String htmlmessage_p3=summary1+" ("+status1.trim()+")";
		String htmlmessage_p3_3=summary2+" ("+status2.trim()+")";
		String htmlmessage = htmlmessage_p1+htmlmessage_p2+htmlmessage_p3+oclist+htmlmessage_p3_3+htmlmessage_p4;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.arcscorp.net");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC));
			message.setSubject(Subject);
			
			log.debug("Sent mail to: "+To);
			log.debug("Sent mail bcc: "+BCC);
			
			System.out.println("Sent mail to: "+To);
			System.out.println("Sent mail bcc "+BCC);
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);
			System.out.println("Email is sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void send(String summary1, String summary2, String summary3, String status1, String status2, String status3) {


		String htmlmessage_p3=summary1+" ("+status1.trim()+")";
		String htmlmessage_p3_3=summary2+" ("+status2.trim()+")";
		String htmlmessage_p3_4=summary3+" ("+status3.trim()+")";
		String htmlmessage = htmlmessage_p1+htmlmessage_p2+htmlmessage_p3+oclist+htmlmessage_p3_3+oclist+htmlmessage_p3_4+htmlmessage_p4;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.arcscorp.net");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC));
			message.setSubject(Subject);
			
			log.debug("Sent mail to: "+To);
			log.debug("Sent mail bcc "+BCC);
			
			System.out.println("Sent mail to: "+To);
			System.out.println("Sent mail bcc: "+BCC);
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);
			System.out.println("Email is sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void send(String summary1, String summary2, String summary3, String summary4, String status1, String status2, String status3,String status4) {


		String htmlmessage_p3=summary1+" ("+status1.trim()+")";
		String htmlmessage_p3_3=summary2+" ("+status2.trim()+")";
		String htmlmessage_p3_4=summary3+" ("+status3.trim()+")";
		String htmlmessage_p3_5=summary4+" ("+status4.trim()+")";
		String htmlmessage = htmlmessage_p1+htmlmessage_p2+htmlmessage_p3+oclist+htmlmessage_p3_3+oclist+htmlmessage_p3_4+oclist+htmlmessage_p3_5+htmlmessage_p4;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.arcscorp.net");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC));
			message.setSubject(Subject);
			
			log.debug("Sent mail to: "+To);
			log.debug("Sent mail bcc "+BCC);
			
			System.out.println("Sent mail to: "+To);
			System.out.println("Sent mail bcc: "+BCC);
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);
			System.out.println("Email is sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void send(String summary1, String summary2, String summary3, String summary4, String summary5, String status1, String status2, String status3,String status4,String status5) {


		String htmlmessage_p3=summary1+" ("+status1.trim()+")";
		String htmlmessage_p3_3=summary2+" ("+status2.trim()+")";
		String htmlmessage_p3_4=summary3+" ("+status3.trim()+")";
		String htmlmessage_p3_5=summary4+" ("+status4.trim()+")";
		String htmlmessage_p3_6=summary5+" ("+status5.trim()+")";
		String htmlmessage = htmlmessage_p1+htmlmessage_p2+htmlmessage_p3+oclist+htmlmessage_p3_3+oclist+htmlmessage_p3_4+oclist+htmlmessage_p3_5+oclist+htmlmessage_p3_6+htmlmessage_p4;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.arcscorp.net");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC));
			message.setSubject(Subject);
			
			log.debug("Sent mail to: "+To);
			log.debug("Sent mail bcc "+BCC);
			
			System.out.println("Sent mail to: "+To);
			System.out.println("Sent mail bcc: "+BCC);
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);
			System.out.println("Email is sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void send(String summary1, String summary2, String summary3, String summary4, String summary5, String summary6, String status1, String status2, String status3,String status4,String status5, String status6) {


		String htmlmessage_p3=summary1+" ("+status1.trim()+")";
		String htmlmessage_p3_3=summary2+" ("+status2.trim()+")";
		String htmlmessage_p3_4=summary3+" ("+status3.trim()+")";
		String htmlmessage_p3_5=summary4+" ("+status4.trim()+")";
		String htmlmessage_p3_6=summary5+" ("+status5.trim()+")";
		String htmlmessage_p3_7=summary6+" ("+status6.trim()+")";
		String htmlmessage = htmlmessage_p1+htmlmessage_p2+htmlmessage_p3+oclist+htmlmessage_p3_3+oclist+htmlmessage_p3_4+oclist+htmlmessage_p3_5+oclist+htmlmessage_p3_6+oclist+htmlmessage_p3_7+htmlmessage_p4;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mail.arcscorp.net");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(From));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(BCC));
			message.setSubject(Subject);
			
			log.debug("Sent mail to: "+To);
			log.debug("Sent mail bcc: "+BCC);
			
			System.out.println("Sent mail to: "+To);
			System.out.println("Sent mail bcc "+BCC);
			/*
			 * Simple message as Text format
			 */
			// message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
			// please!");
			/*
			 * HTML format message
			 */
			message.setContent(htmlmessage, "text/html");
			Transport.send(message);
			System.out.println("Email is sent.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
