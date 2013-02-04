package com.nttdata.ext4j.explorer.client.controllers.demos.layouts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.ColumnLayoutDemo;

public class ColumnLayoutDemoController extends AbstractDemoController {

    private static final ColumnLayoutDemoController INSTANCE = new ColumnLayoutDemoController();

    public static ColumnLayoutDemoController get() {
        return INSTANCE;
    }

    private ColumnLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new ColumnLayoutDemo();
    }

}
