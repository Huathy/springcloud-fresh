package com.hx.fresh.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 邮件发送工具类
 * @author Huathy
 * @date 2020年4月5日
 */
@Component
@ConfigurationProperties(prefix = "spring.mail")
public class SendMailUtil {
	@Value("${spring.mail.username}")	//或@Autowired
	private String sendEmail;	//发件人邮箱
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * 邮件发送类
	 * @param receiveMail	接收方邮箱
	 * @param mainText		发送的正文
	 * @param subject		发送的主题
	 * @return
	 */
	public boolean sendEmail(String receiveMail,String mainText,String subject){
		try {
			if(ParamsUtil.checkNull(receiveMail,mainText,subject)){
				throw new Exception("参数不可为空，请检查参数：receiveMail,mainText,subject");
			}
			//建立邮件的消息，我们需要发送的是html格式的邮件
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			
			//设置收件人，寄件人，邮件主题
			messageHelper.setTo(receiveMail);
			messageHelper.setFrom(sendEmail);
			messageHelper.setSubject(subject);
			
			//设置邮件正文
			messageHelper.setText(mainText,true);
			mailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
