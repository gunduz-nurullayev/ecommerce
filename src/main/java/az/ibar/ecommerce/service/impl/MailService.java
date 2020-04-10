package az.ibar.ecommerce.service.impl;


import az.ibar.ecommerce.repository.impl.CustomerDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    Logger logger = LogManager.getLogger(CustomerDaoImpl.class);

    private static final Properties mailProperties = new Properties();


    static {

        mailProperties.setProperty("mail.smtp.host", "smtp.gmail.com");
        mailProperties.setProperty("mail.smtp.auth", "true");
        mailProperties.setProperty("mail.smtp.port", "465");
        mailProperties.setProperty("mail.smtp.starttls.enable", "true");
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }


    private static Session getSmtpSession() {

        try {
            return Session.getInstance(mailProperties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("info@dynamex.az", "Dynamex383883");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Mail service islemediyi ucun return true edirem!

    public static boolean sendMail(String subject, String content, String mailTo) {


        try {

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(getSmtpSession());

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("ecommerce.az"));

            // Set To: header field of the header.
            message.addRecipients(Message.RecipientType.TO, mailTo);

            // Set Subject: header field
            message.setSubject(subject, "utf-8");

            // Now set the actual message
            message.setContent(content, "text/html; charset=utf-8");
            //message.setText(content, "utf-8");

            // Send message
            Transport.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

}
