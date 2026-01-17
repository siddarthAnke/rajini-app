package com.srg.demo.service;


//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.mail.javamail.JavaMailSender;
	import org.springframework.stereotype.Service;

	@Service
	public class EmailService {

	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendOtp(String toEmail, String otp) {

	        SimpleMailMessage message = new SimpleMailMessage();

	        // ✅ MUST match SendGrid verified sender
	        message.setFrom("rajiniwages@gmail.com");

	        message.setTo(toEmail);
	        message.setSubject("Your OTP for Login");
	        message.setText(
	            "Your OTP is: " + otp + "\n\n" +
	            "This OTP is valid for 5 minutes.\n" +
	            "Do not share this OTP with anyone."
	        );

	        mailSender.send(message);
	    }
	

//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendOtp(String toEmail, String otp) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(toEmail);
//        message.setSubject("Your OTP for Login");
//        message.setText(
//            "Your OTP is: " + otp + "\n\n" +
//            "This OTP is valid for 5 minutes.\n" +
//            "Do not share this OTP with anyone."
//        );
//
//        mailSender.send(message);
//    }
}