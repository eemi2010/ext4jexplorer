package com.nttdata.ext4j.explorer.client.controllers.demos.windows;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.windows.WindowsVariationDemo;

public class WindowsVariationDemoController extends AbstractDemoController {

    private static final WindowsVariationDemoController INSTANCE = new WindowsVariationDemoController();

    public static WindowsVariationDemoController get() {
        return INSTANCE;
    }

    private WindowsVariationDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return WindowsVariationDemo.get();
    }

}
