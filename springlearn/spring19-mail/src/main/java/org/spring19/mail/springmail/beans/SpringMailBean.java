package org.spring19.mail.springmail.beans;

import org.spring19.mail.java.EmailUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SpringMailBean {
	@Bean
	public MailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.163.com");
		mailSender.setUsername(EmailUtil.USE_MAIL);
		mailSender.setPassword(EmailUtil.USE_MAIL_PASSWORD);
		return mailSender;
	}
}
