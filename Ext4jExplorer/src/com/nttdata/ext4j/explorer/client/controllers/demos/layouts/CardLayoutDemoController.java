package com.nttdata.ext4j.explorer.client.controllers.demos.layouts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.CardLayoutDemo;

public class CardLayoutDemoController extends AbstractDemoController {

    private static final CardLayoutDemoController INSTANCE = new CardLayoutDemoController();

    public static CardLayoutDemoController get() {
        return INSTANCE;
    }

    private CardLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new CardLayoutDemo();
    }

}
