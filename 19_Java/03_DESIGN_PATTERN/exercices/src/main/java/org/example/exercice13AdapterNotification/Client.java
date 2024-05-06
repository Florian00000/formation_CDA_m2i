package org.example.exercice13AdapterNotification;

public class Client {
    public static void main(String[] args) {
        SmsService send = new NotificationAdapter();
        send.sendSms("0606060006" , "rolala!");
    }
}
