package br.com.cadoresistemas.williamcadore.Utils;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
public class SendMail {

    public void sendMail(String to_mail, String subject, String msg, int i, String path, String description, String name_file){
            try {
                  // Create the email message
                  MultiPartEmail email = new MultiPartEmail();
                  email.setDebug(true);
                  email.setHostName("200.143.59.218");
                  email.setSmtpPort(587);
                  email.setAuthentication("no-reply@cadoresistemas.com.br","a1s2d3f4Cadore()");
                  email.setSSL(false);
                  email.addTo(to_mail); //pode ser qualquer um email
                  email.setFrom("no-reply@cadoresistemas.com.br"); //aqui necessita ser o email que voce fara a autenticacao
                  email.setSubject(subject);
                  email.setMsg(msg);
                  // add the attachment
                  if(i == 1 && i != 0){
                        EmailAttachment attachment = new EmailAttachment();
                        attachment.setPath(path); // Obtem o caminho do arquivo
                        attachment.setDisposition(EmailAttachment.ATTACHMENT);
                        attachment.setDescription(description);
                        attachment.setName(name_file); // Obtem o nome do arquivo
                        email.attach(attachment);
                  }
                  email.send();
          } catch (EmailException e) {
       }
    }
}
