package com.nttdata.ext4j.explorer.client.controllers.demos;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.buttons.ButtonsDemo;

public class ButtonsDemoController extends AbstractDemoController {

    private static final ButtonsDemoController INSTANCE = new ButtonsDemoController();

    public static ButtonsDemoController get() {
        return INSTANCE;
    }

    private ButtonsDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return ButtonsDemo.get();
    }

}
