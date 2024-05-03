package org.example.demo_abstract_factory_mobile_app.factory.impl;

import org.example.demo_abstract_factory_mobile_app.entity.MobileButton;
import org.example.demo_abstract_factory_mobile_app.entity.Toolbar;
import org.example.demo_abstract_factory_mobile_app.entity.impl.IOSMobileButton;
import org.example.demo_abstract_factory_mobile_app.entity.impl.IOSToolBar;
import org.example.demo_abstract_factory_mobile_app.factory.MobileUIFactory;

public class IOSUIFactory extends MobileUIFactory {

    @Override
    public Toolbar createToolBar() {
        return new IOSToolBar();
    }

    @Override
    public MobileButton createMobileButton() {
        return new IOSMobileButton();
    }
}
