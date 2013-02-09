package com.nttdata.ext4j.explorer.client.controllers.demos.windows;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.windows.WindowLayoutDemo;

public class WindowLayoutDemoController extends AbstractDemoController {

    private static final WindowLayoutDemoController INSTANCE = new WindowLayoutDemoController();

    public static WindowLayoutDemoController get() {
        return INSTANCE;
    }

    private WindowLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return WindowLayoutDemo.get();
    }

}
