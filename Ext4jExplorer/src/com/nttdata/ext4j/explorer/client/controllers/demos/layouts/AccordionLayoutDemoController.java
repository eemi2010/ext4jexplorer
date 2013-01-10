package com.nttdata.ext4j.explorer.client.controllers.demos.layouts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AccordionLayoutDemo;

public class AccordionLayoutDemoController extends AbstractDemoController {

    private static final AccordionLayoutDemoController INSTANCE = new AccordionLayoutDemoController();

    public static AccordionLayoutDemoController get() {
        return INSTANCE;
    }

    private AccordionLayoutDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new AccordionLayoutDemo();
    }

}
