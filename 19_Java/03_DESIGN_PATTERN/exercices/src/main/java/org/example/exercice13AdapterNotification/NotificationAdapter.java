package org.example.exercice13AdapterNotification;

public class NotificationAdapter implements  SmsService{
    private EmailService emailService;

    public NotificationAdapter() {
        emailService = new EmailService();
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        emailService.sendEmail(getEmailByPhoneNumber(phoneNumber), "emailSecours", message);
    }

    private String getEmailByPhoneNumber(String phoneNumber) {
        return "juandelpuente@mail.com";
    }
}
