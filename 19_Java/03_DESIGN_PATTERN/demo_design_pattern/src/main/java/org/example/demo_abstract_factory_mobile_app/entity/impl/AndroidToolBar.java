package org.example.demo_abstract_factory_mobile_app.entity.impl;

import org.example.demo_abstract_factory_mobile_app.entity.Toolbar;

public class AndroidToolBar extends Toolbar {
    @Override
    public void renderToolBar() {
        System.out.println("Android Tool Bar");
    }
}
