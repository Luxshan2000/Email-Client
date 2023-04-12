import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.util.Properties;

abstract class MailSender{
    public static void send(String to_send,String subject,String content){
        MailHost host=MailHost.getInstance();
        String username =host.getUsername(); //Gmail address
        String password = host.getPassword();//Password
        content=content+"\n"+host.getName();

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        FileHandler Session;
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(host.getUsername()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to_send)
            );
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            //add activity to history
            MailHistory.saveHistory(to_send+"\t"+subject);
        }catch (Exception e){
            System.out.println("Error Occurred Check Email address!!!");
            System.out.println("Your inputted Email: "+to_send);
        }
    }
}