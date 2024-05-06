package org.example.demo_proxy;

public class Client {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connect("m2iformation.fr");
        internet.connect("google.com");
    }
}
