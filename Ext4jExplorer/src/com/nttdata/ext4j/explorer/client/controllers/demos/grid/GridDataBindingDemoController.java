package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.GridDataBindingDemo;

public class GridDataBindingDemoController extends AbstractDemoController {

    private static final GridDataBindingDemoController INSTANCE = new GridDataBindingDemoController();

    public static GridDataBindingDemoController get() {
        return INSTANCE;
    }

    private GridDataBindingDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return GridDataBindingDemo.get();
    }

}
