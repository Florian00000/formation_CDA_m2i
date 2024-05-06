package org.example.demo_proxy_image;

public class HighResolutionImage implements Image {
    @Override
    public void render(String path) {
        System.out.println("High resolution of " +path);
    }
}
