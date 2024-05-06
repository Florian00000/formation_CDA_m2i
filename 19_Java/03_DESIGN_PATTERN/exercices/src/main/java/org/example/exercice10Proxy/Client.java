package org.example.exercice10Proxy;

public class Client {
    public static void main(String[] args) {
        System.out.println("TEST true ");
        SecureBookProxy secureBookProxy = new SecureBookProxy(true);
        secureBookProxy.readBook();
        System.out.println("TEST false");
        SecureBookProxy secureBookProxy2 = new SecureBookProxy(false);
        secureBookProxy2.readBook();
    }
}
