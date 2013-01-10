package com.nttdata.ext4j.explorer.client.controllers.demos.layouts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AbsoluteLayoutDemo;

public class AbsoluteLayoutDemoController extends AbstractDemoController {

    private static final AbsoluteLayoutDemoController INSTANCE = new AbsoluteLayoutDemoController();

    public static AbsoluteLayoutDemoController get() {
        return INSTANCE;
    }

    private AbsoluteLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new AbsoluteLayoutDemo();
    }

}
