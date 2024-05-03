package org.example.demo_abstract_factory_mobile_app;

import org.example.demo_abstract_factory_mobile_app.entity.MobileApplication;
import org.example.demo_abstract_factory_mobile_app.factory.impl.AndroidUIFactory;
import org.example.demo_abstract_factory_mobile_app.factory.impl.IOSUIFactory;

public class Main {
    public static void main(String[] args) {
        MobileApplication android = new MobileApplication(new AndroidUIFactory());
        android.renderApplication();

        MobileApplication ios = new MobileApplication(new IOSUIFactory());
        ios.renderApplication();

    }
}
