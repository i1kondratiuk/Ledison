package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendMailAboutOrderSuccess(User user) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			mimeMessage.setFrom(new InternetAddress("ledison.store@gmail.com"));
			helper.setTo(user.getEmail());
			helper.setText("Hello " + user.getFirstName() + " " + user.getLastName() +
					"! Your order confirmed successfully!\n" +
					"Thank you!\n" +"" +
					"For more details visit our website <a href = 'http://ledison.in.ua'>Ledison</a>",
					true);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMailAboutOrderStatusChanging(User user, CustomerOrder customerOrder) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			mimeMessage.setFrom(new InternetAddress("ledison.store@gmail.com"));
			helper.setTo(user.getEmail());
			helper.setText("Hello " + user.getFirstName() + " " + user.getLastName() +
							"! Your order status is \"" + customerOrder.getStatus().name() + "\". \n" +
							"Thank you!\n" +"" +
							"For more details visit our website <a href = 'http://ledison.in.ua'>Ledison</a>",
					true);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
