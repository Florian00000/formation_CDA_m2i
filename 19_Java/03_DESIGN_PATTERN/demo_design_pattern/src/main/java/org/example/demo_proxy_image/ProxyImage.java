package org.example.demo_proxy_image;

public class ProxyImage implements Image {

    private boolean isHighSpeed = true;
    private Image image;


    @Override
    public void render(String path) {
        if(isHighSpeed) {
            image = new HighResolutionImage();
        }else {
            image = new LowResolutionImage();
        }
        image.render(path);
    }
}
