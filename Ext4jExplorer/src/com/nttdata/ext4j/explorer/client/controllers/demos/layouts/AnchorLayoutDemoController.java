package com.nttdata.ext4j.explorer.client.controllers.demos.layouts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AnchorLayoutDemo;

public class AnchorLayoutDemoController extends AbstractDemoController {

    private static final AnchorLayoutDemoController INSTANCE = new AnchorLayoutDemoController();

    public static AnchorLayoutDemoController get() {
        return INSTANCE;
    }

    private AnchorLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new AnchorLayoutDemo();
    }

}
