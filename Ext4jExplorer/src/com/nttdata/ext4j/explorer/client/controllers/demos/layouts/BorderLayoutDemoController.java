package com.nttdata.ext4j.explorer.client.controllers.demos.layouts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.BorderLayoutDemo;

public class BorderLayoutDemoController extends AbstractDemoController {

    private static final BorderLayoutDemoController INSTANCE = new BorderLayoutDemoController();

    public static BorderLayoutDemoController get() {
        return INSTANCE;
    }

    private BorderLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new BorderLayoutDemo();
    }

}
