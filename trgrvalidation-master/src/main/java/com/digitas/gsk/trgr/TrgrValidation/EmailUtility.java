package com.digitas.gsk.trgr.TrgrValidation;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {
	static String S = File.separator;
	
	Properties props = null;
	Session session = null;

	public EmailUtility() {
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("trgrreporter@gmail.com", "trgrValidator@123");
			}
		});

	}

	public void sendMail(String recepients, String[] filePaths, String id, String bodyMessage,
			String ignoredLineItems) {

		try {

//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("trgrreporter@gmail.com"));
//
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepients));
//			message.setSubject("Result From execution run id  " + id);
//
//			//// Add text to body
//			Multipart multipart = new MimeMultipart();
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//			messageBodyPart1.setText("Following LineItems were Ignored in the Tests \n" + ignoredLineItems
//					+ "\nSummary of Execution \n" + bodyMessage.toString());
//			multipart.addBodyPart(messageBodyPart1);
//
//			MimeBodyPart messageBodyPart = null;
//
//			for (String file : filePaths) {
//
//				messageBodyPart = new MimeBodyPart();
//				File f = new File(file);
//				String filename = f.getName();
//				DataSource source = new FileDataSource(file);
//				messageBodyPart.setDataHandler(new DataHandler(source));
//				messageBodyPart.setFileName(filename);
//				multipart.addBodyPart(messageBodyPart);
//				message.setContent(multipart);
//			}
//
//			Transport.send(message);
//			session = null;
//			System.out.println("=====Email Sent=====");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * private static void addAttachment(Multipart multipart, String filename)
	 * throws Exception { DataSource source = new FileDataSource(filename); BodyPart
	 * messageBodyPart = new MimeBodyPart(); messageBodyPart.setDataHandler(new
	 * DataHandler(source)); messageBodyPart.setFileName(filename);
	 * multipart.addBodyPart(messageBodyPart); }
	 */

	public void sendHeaderMail(String recepients, String id, String bodyMessage) {

		try {
			System.out.println();

//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("trgrreporter@gmail.com"));
//
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepients));
//
//			Multipart multipart = new MimeMultipart();
//			message.setSubject("Result From execution run id  " + id);
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//			messageBodyPart1.setText("The Execution has been triggered \n" + bodyMessage);
//			multipart.addBodyPart(messageBodyPart1);
//
//			message.setContent(multipart);
//			Transport.send(message);
//			session = null;
//			System.out.println("=====Email Sent=====");

		} catch (Exception e) {

			throw new RuntimeException(e);

		}

	}

}