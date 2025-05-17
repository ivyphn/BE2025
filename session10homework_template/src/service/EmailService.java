package service;

import java.io.*;
import java.net.*;

import session10homework_template.Storage;

public class EmailService {

    public static void sendEmail(String receiver, String subject, String body) {

        try (Socket socket = new Socket(Storage.SMTP_HOST, Storage.SMTP_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("From: " + Storage.SENDER_EMAIL);
            out.println("To: " + receiver);
            out.println("Subject: " + subject);
            out.println();
            out.println(body);
            out.println(".");

            System.out.println("Email sent successfully to " + receiver);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while sending email.");
        }
    }
}
