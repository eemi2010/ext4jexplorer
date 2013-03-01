package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.GridFilterDemo;

public class GridFilteringDemoController extends AbstractDemoController {

    private static final GridFilteringDemoController INSTANCE = new GridFilteringDemoController();

    public static GridFilteringDemoController get() {
        return INSTANCE;
    }

    private GridFilteringDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return GridFilterDemo.get();
    }

}
