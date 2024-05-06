package org.example.demo_proxy_image;

public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage();
        image.render("/path/to/image");
    }
}
