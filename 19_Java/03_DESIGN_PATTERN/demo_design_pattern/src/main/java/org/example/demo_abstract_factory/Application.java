package org.example.demo_abstract_factory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GuiFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }
}
