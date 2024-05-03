package org.example.demo_abstract_factory_mobile_app.entity;

import org.example.demo_abstract_factory_mobile_app.factory.MobileUIFactory;

public class MobileApplication {
    private Toolbar toolbar;
    private MobileButton mobileButton;
    private MobileUIFactory uiFactory;
    public  MobileApplication(MobileUIFactory mobileUIFactory) {
        uiFactory = mobileUIFactory;
        toolbar = uiFactory.createToolBar();
        mobileButton = uiFactory.createMobileButton();
    }

    public void renderApplication(){
        toolbar.renderToolBar();
        mobileButton.renderButton();
    }
}
