package org.example.demo_abstract_factory_mobile_app.entity.impl;

import org.example.demo_abstract_factory_mobile_app.entity.MobileButton;

public class IOSMobileButton extends MobileButton {
    @Override
    public void renderButton() {
        System.out.println("IOS Mobile Button");
    }
}
