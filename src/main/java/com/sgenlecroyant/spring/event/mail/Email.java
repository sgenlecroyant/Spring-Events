package com.sgenlecroyant.spring.event.mail;

public class Email {
	
	private String destinationEmailAddress;
	private String emailBody;
	
	public Email(String destinationEmailAddress, String emailBody) {
		this.destinationEmailAddress = destinationEmailAddress;
		this.emailBody = emailBody;
	}

	public String getDestinationEmailAddress() {
		return destinationEmailAddress;
	}

	public String getEmailBody() {
		return emailBody;
	}
	
	public void setDestinationEmailAddress(String destinationEmailAddress) {
		this.destinationEmailAddress = destinationEmailAddress;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
}
