package com.nttdata.ext4j.explorer.client.controllers.demos.combinationexamples;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.combination.PortalDemo;

public class PortalDemoController extends AbstractDemoController {

    private static final PortalDemoController INSTANCE = new PortalDemoController();

    public static PortalDemoController get() {
        return INSTANCE;
    }

    private PortalDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return PortalDemo.get();
    }

}
