package cl.jazocar.jselector.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class EnvioEmail
{
   public static void main(String [] args)
   {    
      // La direcci�n de env�o (to)
      String para = "juan.azocar.malverde@gmail.com";
 
      // La direcci�n de la cuenta de env�o (from)
      String de = "juanazocar@jazocar.com";
 
      // El servidor (host). En este caso usamos localhost
      String host = "mail.jazocar.cl";
 
      // Obtenemos las propiedades del sistema
      Properties propiedades = System.getProperties();
 
      // Configuramos el servidor de correo
      propiedades.setProperty("mail.smtp.host", host);
 
      // Obtenemos la sesi�n por defecto
      Session sesion = Session.getDefaultInstance(propiedades);
 
      try{
         // Creamos un objeto mensaje tipo MimeMessage por defecto.
         MimeMessage mensaje = new MimeMessage(sesion);
 
         // Asignamos el �de o from� al header del correo.
         mensaje.setFrom(new InternetAddress(de));
 
         // Asignamos el �para o to� al header del correo.
         mensaje.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(para));
 
         // Asignamos el asunto
         mensaje.setSubject("Primer correo sencillo");
 
         // Asignamos el mensaje como tal
         mensaje.setText("El mensaje de nuestro primer correo");
 
         // Enviamos el correo
         Transport.send(mensaje);
         System.out.println("Mensaje enviado");
      }catch (MessagingException e) {
         e.printStackTrace();
      }
   }
}