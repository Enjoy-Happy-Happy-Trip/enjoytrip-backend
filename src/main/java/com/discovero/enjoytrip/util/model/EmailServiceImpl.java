package com.discovero.enjoytrip.util.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService{
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(EmailDto edto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		// 0. 메일 송신자 설정
		simpleMailMessage.setFrom("skydreamer210@gmail.com");
		
		// 1. 메일 수신자 설정
		simpleMailMessage.setTo(edto.getAddressTo());
		
		// 2. 메일 제목 설정
		simpleMailMessage.setSubject(edto.getTitle());
		
		// 3. 메일 내용 설정
		simpleMailMessage.setText(edto.getContent());
		
		mailSender.send(simpleMailMessage);
	}
}
