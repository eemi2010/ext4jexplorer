package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.SimpleGridDemo;

public class SimpleGridDemoController extends AbstractDemoController {

    private static final SimpleGridDemoController INSTANCE = new SimpleGridDemoController();

    public static SimpleGridDemoController get() {
        return INSTANCE;
    }

    private SimpleGridDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return SimpleGridDemo.get();
    }

}
