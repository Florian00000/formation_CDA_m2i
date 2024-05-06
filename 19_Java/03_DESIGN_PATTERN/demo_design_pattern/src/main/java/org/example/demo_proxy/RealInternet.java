package org.example.demo_proxy;

public class RealInternet implements Internet {
    @Override
    public void connect(String url) {
        System.out.println("Connexion Internet "+url);
    }
}
