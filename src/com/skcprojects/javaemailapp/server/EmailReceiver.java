package com.skcprojects.javaemailapp.server;

import javax.mail.*;
import java.util.Properties;

public class EmailReceiver {
  public static void receiveEmail(String username, String password) {
      Properties properties = new Properties();
      properties.put("mail.store.protocol", "imaps");
      properties.put("mail.imaps.host", "imap.gmail.com");
      properties.put("mail.imaps.port", "993");
      properties.put("mail.imaps.ssl.enable", "true");

      try {
          Session emailSession = Session.getDefaultInstance(properties);
          Store store = emailSession.getStore("imaps");
          store.connect("imap.gmail.com", username, password);

          Folder emailFolder = store.getFolder("INBOX");
          emailFolder.open(Folder.READ_ONLY);

          Message[] messages = emailFolder.getMessages();
          System.out.println("Number of emails: " + messages.length);

          // Example: Print out subject of each email
          for (Message message : messages) {
              System.out.println("Email Subject: " + message.getSubject());
          }

          emailFolder.close(false);
          store.close();
      } catch (NoSuchProviderException e) {
          e.printStackTrace();
      } catch (MessagingException e) {
          e.printStackTrace();
      }
  }

  public static void main(String[] args) {
      // Example Gmail credentials - replace with actual credentials
      String username = "keshavdsce@gmail.com";
      String password = "qlhd ivnr hwdh xqtv"; // Use app password for Gmail

      receiveEmail(username, password);
  }
}
