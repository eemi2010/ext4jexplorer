package com.nttdata.ext4j.explorer.client.controllers.demos.tabs;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.tabs.AdvancedTabsDemo;

public class AdvancedTabsDemoController extends AbstractDemoController {

    private static final AdvancedTabsDemoController INSTANCE = new AdvancedTabsDemoController();

    public static AdvancedTabsDemoController get() {
        return INSTANCE;
    }

    private AdvancedTabsDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return AdvancedTabsDemo.get();
    }

}
