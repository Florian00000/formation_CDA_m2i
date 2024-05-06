package org.example.demo_proxy_image;

public class LowResolutionImage implements Image {
    @Override
    public void render(String path) {
        System.out.println("Low resolution Image "+path);
    }
}
