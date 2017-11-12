package org.spring19.mail.springmail.beans;

import java.nio.file.Paths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.spring19.mail.java.EmailUtil;
import org.spring19.mail.springmail.configuration.SpringMailConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SpringMailBeanTest {

	@Test
	public void test() throws MessagingException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringMailConfiguration.class);
		JavaMailSender mailSender = (JavaMailSender) context.getBean(MailSender.class);
		// send simplemsg
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(EmailUtil.USE_MAIL);
		message.setTo(EmailUtil.USE_MAIL);
		message.setSubject("spring java mail-simpletest");
		message.setText("this is a java spring mail SimpleMailMessage");
		mailSender.send(message);
		System.out.println("send SimpleMailMessage");

		// send mimemessage
		MimeMessage attchMessage = mailSender.createMimeMessage();
		MimeMessageHelper attachHelper = new MimeMessageHelper(attchMessage, true);
		attachHelper.setFrom(EmailUtil.USE_MAIL);
		attachHelper.setTo(EmailUtil.USE_MAIL);
		attachHelper.setSubject("spring java mail-attchtest");
		attachHelper.setText("this is a java spring mail MimeMessage");
		FileSystemResource image = new FileSystemResource(
				Paths.get(System.getProperty("user.dir"), "src/main/resources/冬天.jpg").toString());
		attachHelper.addAttachment("dongtian.jpg", image);
		mailSender.send(attchMessage);
		System.out.println("send attch MailMessage");

		// send full text
		MimeMessage htmlMessage = ((JavaMailSender) mailSender).createMimeMessage();
		MimeMessageHelper htmlHelper = new MimeMessageHelper(htmlMessage, true);
		htmlHelper.setFrom(EmailUtil.USE_MAIL);
		htmlHelper.setTo(EmailUtil.USE_MAIL);
		htmlHelper.setSubject("spring java mail-htmltest");
		htmlHelper.setText("<html><body><img src='cid:spitterLogo'></body></html>", true);
		FileSystemResource image2 = new FileSystemResource(
				Paths.get(System.getProperty("user.dir"), "src/main/resources/冬天.jpg").toString());
		htmlHelper.addInline("spitterLogo", image2);
		mailSender.send(htmlMessage);
		System.out.println("send html MailMessage");
	}

}
