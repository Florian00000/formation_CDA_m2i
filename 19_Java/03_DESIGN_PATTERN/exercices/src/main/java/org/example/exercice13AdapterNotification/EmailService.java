package org.example.exercice13AdapterNotification;

public class EmailService {
    public void sendEmail(String email, String subject, String body) {
        System.out.println("A " + email + "\n objet: " + subject + "\n" + body);
    }
}
