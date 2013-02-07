package com.nttdata.ext4j.explorer.client.controllers.demos.tabs;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.tabs.BasicTabsDemo;

public class BasicTabsDemoController extends AbstractDemoController {

    private static final BasicTabsDemoController INSTANCE = new BasicTabsDemoController();

    public static BasicTabsDemoController get() {
        return INSTANCE;
    }

    private BasicTabsDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return BasicTabsDemo.get();
    }

}
