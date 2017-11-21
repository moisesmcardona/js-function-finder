/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionCheck;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author cardona_76937
 */
public class checkUserLogin {
    String FileDirectory = "C:\\files\\";
    String DomainName = "localhost";
    public int checkLogin(String username, String password) {
        int uservalid = 0;
        try {
            File f = new File(FileDirectory + username + "_"); //temporary file, when an account is not validated
            if (f.exists()) {
                uservalid = 3; //3 means user has not validated their account
            } else {
                BufferedReader in = new BufferedReader(new FileReader(FileDirectory + username));
                String str;
                while ((str = in.readLine()) != null) {
                    if (password.equals(str)) {
                        uservalid = 1;
                    } else {
                        uservalid = 5;
                    }
                }
                //Loads Play times from Text File if Exists
                in.close();
            }
        } catch (IOException e) {
            uservalid = 2;
        }
        return uservalid;
    }

    public String register(String username, String password, String email) {
        String ok;
        try {
            File file = new File(FileDirectory + username + "_");
            File filecheck = new File(FileDirectory + username);
            File emailfile = new File(FileDirectory + username + "_email");
            File historyfile2 = new File(FileDirectory + username + "_history2");
            if (file.exists()) {
                ok = "6";
            } else if (filecheck.exists()) {
                ok = "7";
            } else {
                OutputStream outputStream = new FileOutputStream(file);
                Writer out = new OutputStreamWriter(outputStream);
                OutputStream outputStream2 = new FileOutputStream(emailfile);
                Writer out2 = new OutputStreamWriter(outputStream2);
                OutputStream outputStream4 = new FileOutputStream(historyfile2);
                Writer out4 = new OutputStreamWriter(outputStream4);
                out.write(password);
                out.close();
                out2.write(email);
                out2.close();
                PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter(FileDirectory + username + "_history1", true)));
                out3.println("Select a date below to check the code and results:");
                out3.close();
                out4.write("0");
                out4.close();
                //sends email
                String to = email;
                String from = "user@domain.com";
                String host = "smtp-relay.gmail.com";
                Properties properties = System.getProperties();
                properties.setProperty("mail.smtp.host", host);
                Session session = Session.getDefaultInstance(properties);
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("Activate your account");
                    message.setText("Hi, " + username + "," + "\n" + "You recently made an account to use our function locator program." + "\n" + "Please go to the following link to activate your account: " + DomainName + "/activate.jsp?user=" + username);

                    Transport.send(message);
                    System.out.println("Sent message successfully....");
                    ok = "1";
                } catch (MessagingException mex) {
                    ok = String.valueOf(mex);
                }
            }
        } catch (IOException e) {
            ok = String.valueOf(e);
        }
        return ok;
    }

    public int activate(String username) {
        int ok = 0;
        File file = new File(FileDirectory + username + "_");
        File destinationName = new File(FileDirectory + username);
        if (file.exists()) {
            try {
                file.renameTo(destinationName);
                ok = 1;
            } catch (Exception e) {
                ok = 2;
            }
        }
        return ok;
    }
}
