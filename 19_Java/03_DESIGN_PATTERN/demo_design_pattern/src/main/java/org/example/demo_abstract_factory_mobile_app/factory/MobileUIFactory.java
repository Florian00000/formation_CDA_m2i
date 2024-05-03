package org.example.demo_abstract_factory_mobile_app.factory;

import org.example.demo_abstract_factory_mobile_app.entity.MobileButton;
import org.example.demo_abstract_factory_mobile_app.entity.Toolbar;

public abstract class MobileUIFactory {
    public abstract Toolbar createToolBar();
    public abstract MobileButton createMobileButton();
}
