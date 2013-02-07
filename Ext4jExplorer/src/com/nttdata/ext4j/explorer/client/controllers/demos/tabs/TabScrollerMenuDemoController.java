package com.nttdata.ext4j.explorer.client.controllers.demos.tabs;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.tabs.TabScrollerMenuDemo;

public class TabScrollerMenuDemoController extends AbstractDemoController {

    private static final TabScrollerMenuDemoController INSTANCE = new TabScrollerMenuDemoController();

    public static TabScrollerMenuDemoController get() {
        return INSTANCE;
    }

    private TabScrollerMenuDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return TabScrollerMenuDemo.get();
    }

}
