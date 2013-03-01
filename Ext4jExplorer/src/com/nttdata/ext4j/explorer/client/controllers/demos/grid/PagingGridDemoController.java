package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.PagingGridDemo;

public class PagingGridDemoController extends AbstractDemoController {

    private static final PagingGridDemoController INSTANCE = new PagingGridDemoController();

    public static PagingGridDemoController get() {
        return INSTANCE;
    }

    private PagingGridDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return PagingGridDemo.get();
    }

}
