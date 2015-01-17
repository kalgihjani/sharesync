package reg;

import javax.mail.*;

import javax.mail.internet.*;

import java.util.*;
import javax.swing.JOptionPane;



public class Mail {

  
    /**
     *
     * @param rcvId
     * @param code
     * @param sendrID
     * @param sendfolder
     * @return
     */
    public int sendMail(String rcvId,String code){

        try
        {
    
        Properties props = System.getProperties();
              // -- Attaching to default Session, or we could start a new one --
              
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");        
        props.put("mail.smtp.auth", "true");

       Mail.SMTPAuthenticator auth = new Mail.SMTPAuthenticator();

       Session session = Session.getInstance(props, auth);
              // -- Create a new message --
       
       Message msg = new MimeMessage(session);
              // -- Set the FROM and TO fields --
    

        //  msg.setFrom(new InternetAddress("sharesyncapp"));             
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rcvId, false));
 //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
              // -- We could include CC recipients too --
          
    // if (cc != null)
 
             // msg.setRecipients(Message.RecipientType.CC
              // ,InternetAddress.parse(cc, false));
              // -- Set the subject and body text --
            
         msg.setSubject("Your friend want you to use Sharesync app!");
         msg.setText("Greetings from Share sync app !\n"
                 + "our application let the users of google drive and skydrive share and synchronize files with each other"
                 
                 + "So we request you to register your cloud storage accoung of google drive or skydrive with us.\n"
                 + "To register your acount on our application please go to the following URL:\n"
                 + "http://localhost:8084/projectdemo_1/validatecode.jsp\n "
                 + " your access code to register your account is:  " +code);
         
              // -- Set some other header information --

         msg.setHeader("MyMail", "Java Mail Test");
         msg.setSentDate(new Date());
              // -- Send the message --
         
     Transport.send(msg);
           
   System.out.println("Message sent");
    

          return 0;
        }


        catch (Exception ex)
        {
JOptionPane.showMessageDialog(null, ex.getMessage());
        ex.printStackTrace();
       
   System.out.println("Exception "+ex);
      
    return -1;
      
  }
  }
    
     public int sendMail(String username,String password,String rcvid){
        try
        {
    
        Properties props = System.getProperties();
              // -- Attaching to default Session, or we could start a new one --
              
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");        
        props.put("mail.smtp.auth", "true");

       Mail.SMTPAuthenticator auth = new Mail.SMTPAuthenticator();

       Session session = Session.getInstance(props, auth);
              // -- Create a new message --
       
       Message msg = new MimeMessage(session);
              // -- Set the FROM and TO fields --
    

        //  msg.setFrom(new InternetAddress("sharesyncapp"));             
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rcvid, false));
 //msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
              // -- We could include CC recipients too --
          
    // if (cc != null)
 
             // msg.setRecipients(Message.RecipientType.CC
              // ,InternetAddress.parse(cc, false));
              // -- Set the subject and body text --
            
         msg.setSubject("Confirmation from sharesync app!");
         msg.setText("Greetings from Share sync app !"
                 + "Now you have successfully registered your account with our application."
                 + "You are now able to start synchronizing your data with your friend."
                 + "the username and password to login into our application is provided below."
                 + "username: "+username+"  password: "+password+"   "    
                 + "To login, go to the following url:  "
                 + " http://localhost:8084/projectdemo_1/index.html.  "
                 + "  thank you. ");
         
              // -- Set some other header information --

         msg.setHeader("MyMail", "Java Mail Test");
         msg.setSentDate(new Date());
              // -- Send the message --
         
     Transport.send(msg);
           
   System.out.println("Message sent");
    

          return 0;
        }


        catch (Exception ex)
        {
JOptionPane.showMessageDialog(null, ex.getMessage());
        ex.printStackTrace();
       
   System.out.println("Exception "+ex);
      
    return -1;
      
  }
  }
  
  
      private class SMTPAuthenticator extends javax.mail.Authenticator {  
   
        
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
     
             String username = "kalgi.pratixa@gmail.com";
             String password = "sharesync";

        return new PasswordAuthentication(username, password);
       
 }

  }

}
