package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.LockedGridDemo;

public class LockedGridDemoController extends AbstractDemoController {

    private static final LockedGridDemoController INSTANCE = new LockedGridDemoController();

    public static LockedGridDemoController get() {
        return INSTANCE;
    }

    private LockedGridDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return LockedGridDemo.get();
    }

}
