package org.spring19.mail.java;

import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * test refer
 * https://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp
 * 
 * @author kwz
 *
 */
public class EmailUtilTest {

	@Test
	public void simpleMessage() {
		System.out.println("SimpleEmail Start");
		String smtpHostServer = "smtp.163.com";
		String emailID = EmailUtil.USE_MAIL;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHostServer);
		Session session = Session.getInstance(props, null);
		EmailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

	/**
	 * 上一个不成功，这个ok
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	@Test
	public void testSimple() throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EmailUtil.USE_MAIL, EmailUtil.USE_MAIL_PASSWORD);
			}

		};
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("coder91@163.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("coder91@163.com"));
		msg.setSubject("subject-test");
		msg.setContent("from java test", "text/plain");
		Transport.send(msg);
	}

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for TLS/STARTTLS: 587
	 */
	@Test
	public void simpleMessageWithAuth() {
		final String fromEmail = EmailUtil.USE_MAIL; // requires valid gmail id
		final String password = EmailUtil.USE_MAIL_PASSWORD; // correct password for gmail id
		final String toEmail = fromEmail; // can be any email id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		// refer http://help.163.com/09/1223/14/5R7P3QI100753VB8.html
		props.put("mail.smtp.host", "smtp.163.com"); // SMTP Host
		props.put("mail.smtp.port", "25"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		EmailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body");
	}

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for SSL: 465
	 */
	@Test
	public void sendMailWithSSLAttachment() {
		final String fromEmail = EmailUtil.USE_MAIL; // requires valid gmail id
		final String password = EmailUtil.USE_MAIL_PASSWORD; // correct password for gmail id
		final String toEmail = fromEmail; // can be any email id

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.163.com"); // SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); // SMTP Port

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		EmailUtil.sendEmail(session, toEmail, "SSLEmail Testing Subject", "SSLEmail Testing Body");

		EmailUtil.sendAttachmentEmail(session, toEmail, "SSLEmail Testing Subject with Attachment",
				"SSLEmail Testing Body with Attachment");

		EmailUtil.sendImageEmail(session, toEmail, "SSLEmail Testing Subject with Image",
				"SSLEmail Testing Body with Image");
	}
}
