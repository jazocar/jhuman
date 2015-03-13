package cl.jazocar.jselector.util;

import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import cl.jazocar.jselector.constants.IConstants;

import com.sun.mail.util.MailSSLSocketFactory;

public class EmailService {

	private Logger log = Logger.getLogger(getClass());
	private String host; 
	private String port;
	private String user;
	private String password;
	private String mailto;
	private String mailfrom;
	private String mailsubject;
	
	
	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailto() {
		return mailto;
	}

	public void setMailto(String mailto) {
		this.mailto = mailto;
	}

	public String getMailfrom() {
		return mailfrom;
	}

	public void setMailfrom(String mailform) {
		this.mailfrom = mailform;
	}

	public String getMailsubject() {
		return mailsubject;
	}

	public void setMailsubject(String mailsubject) {
		this.mailsubject = mailsubject;
	}

	
	
	public EmailService() {
		host         = "smtp.gmail.com";
		port         = "465";
		user         = "jselector.wf@gmail.com";
		password     = "Jokerist.69";
		mailfrom     = "jselector.wf@gmail.com";
		mailto       = "juan.azocar.malverde@gmail.com";
		mailsubject  = "Notificacion desde jselector";		
	}


	public void sendEmail(String destinatario, String asunto, String mensaje) 
	{
		Session session = getSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(this.getMailfrom()));
			
			this.mailto = destinatario;
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getMailto()));
			
			message.setSubject(asunto);
			message.setText(mensaje);
			Transport transport = session.getTransport("smtp");

			transport.connect(this.getHost(), Integer.parseInt(this.getPort()), this.getMailfrom(), this.getPassword() );
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException e) {

			e.printStackTrace();
		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}
	
	private Session getSession() 
	{
		Session session = Session.getDefaultInstance( setMailProperties(this.getHost(), this.getMailfrom()),
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(getUser(), getPassword());
			}
		});
		return session;
	}

	public static boolean validateMail(String mail) {
		Pattern pattern = Pattern.compile(IConstants.REGULAR_PATTERN_MAIL);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}


	private Properties setMailProperties(String host, String user) {

		Properties properties = System.getProperties();
		properties.put("mail.smtp.socketFactory.port", this.getPort());
		properties.put("mail.smtp.socketFactory.fallback", "false");
		properties.put("mail.smtp.host", this.getHost());
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.port", this.getPort());
		properties.put("mail.smtp.user", this.getUser());
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtps.quitwait", "false");
		properties.put("mail.smtp.debug", "true");

		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.socketFactory", sf);

		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties;
	}

	// en caso de requerir enviar archivos
	protected MimeMultipart addAttachment(Multipart multipart, String filename,  MimeBodyPart messageBodyPart )
	{
	
		DataSource source = new FileDataSource(filename);
		MimeMultipart multipart1 = (MimeMultipart) multipart;
		try {
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart1.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			log.error("Problemas con archivo adjunto "+filename +" "+ e);
			
		}
		return multipart1;
	}

	
	private void sendEmail(MimeMultipart multi) {
		
		Session session = getSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(this.getMailfrom()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getMailto()));
			message.setSubject(this.getMailsubject());
			message.setContent(multi);
			Transport transport = session.getTransport("smtp");

			transport.connect(this.getHost(), Integer.parseInt(this.getPort()), this.getMailfrom(), this.getPassword() );
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException e) {

			e.printStackTrace();
		} catch (MessagingException e) {

			e.printStackTrace();
		}

		
	}

	public void sendEmailWithAttach(String fileNames) {
		log.info("Iniciando envio por correo");
		MimeMultipart adjunto  = addAttachment(new MimeMultipart(), fileNames, new MimeBodyPart());
		sendEmail(adjunto);
		
	}

}
