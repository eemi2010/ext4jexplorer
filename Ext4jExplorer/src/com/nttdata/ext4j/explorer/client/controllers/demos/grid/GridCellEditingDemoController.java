package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.GridCellEditingDemo;

public class GridCellEditingDemoController extends AbstractDemoController {

    private static final GridCellEditingDemoController INSTANCE = new GridCellEditingDemoController();

    public static GridCellEditingDemoController get() {
        return INSTANCE;
    }

    private GridCellEditingDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return GridCellEditingDemo.get();
    }

}
