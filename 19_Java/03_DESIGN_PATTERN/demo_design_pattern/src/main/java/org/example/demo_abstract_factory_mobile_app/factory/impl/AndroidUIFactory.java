package org.example.demo_abstract_factory_mobile_app.factory.impl;

import org.example.demo_abstract_factory_mobile_app.entity.MobileButton;
import org.example.demo_abstract_factory_mobile_app.entity.Toolbar;
import org.example.demo_abstract_factory_mobile_app.entity.impl.AndroidMobileButton;
import org.example.demo_abstract_factory_mobile_app.entity.impl.AndroidToolBar;
import org.example.demo_abstract_factory_mobile_app.factory.MobileUIFactory;

public class AndroidUIFactory extends MobileUIFactory {
    @Override
    public Toolbar createToolBar() {
        return new AndroidToolBar();
    }

    @Override
    public MobileButton createMobileButton() {
        return new AndroidMobileButton();
    }
}
