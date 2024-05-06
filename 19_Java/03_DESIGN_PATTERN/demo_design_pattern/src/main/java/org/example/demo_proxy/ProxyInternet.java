package org.example.demo_proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {

    private RealInternet realInternet;
    private List<String> allowedUrls;

    public ProxyInternet() {
        realInternet = new RealInternet();
        allowedUrls = new ArrayList<>(Arrays.asList("m2iformation.fr", "github.com"));
    }

    @Override
    public void connect(String url) {
        boolean allowed = false;
        for(String d : allowedUrls) {
            if(d.contains(url)) {
                allowed = true;
                break;
            }
        }
        if(allowed) {
            realInternet.connect(url);
        }else {
            throw new RuntimeException("Not Allowed");
        }
    }
}
