package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.GridRowEditingDemo;

public class GridRowEditingDemoController extends AbstractDemoController {

    private static final GridRowEditingDemoController INSTANCE = new GridRowEditingDemoController();

    public static GridRowEditingDemoController get() {
        return INSTANCE;
    }

    private GridRowEditingDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return GridRowEditingDemo.get();
    }

}
