package com.sgenlecroyant.spring.event.mail;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSender{

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value(value = "${spring.mail.username}")
	private String fromEmailAddress;
	
	@Value(value ="${app.mail.destination.address}")
	private String destinationEmailAddress;
	
	
	@PostConstruct
	public void getFromEmailAddress() {
		fromEmailAddress = System.getenv("Mine_Email");
		this.logger.info("Email Address Source: " +fromEmailAddress);
	}
	
	@Override
	public void sendEmail(Email email) {
		this.logger.info(fromEmailAddress+ " sending email to: " +destinationEmailAddress);
		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		email.setDestinationEmailAddress(destinationEmailAddress);
		
		try {
			mimeMessageHelper.setSubject("Registration Notification");
			mimeMessageHelper.setFrom(fromEmailAddress);
			mimeMessageHelper.setTo(email.getDestinationEmailAddress());
			mimeMessageHelper.setText(email.getEmailBody(), true);
			this.javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			this.logger.error("error while sending email: " +e.getMessage());
		}
		
	}

}
