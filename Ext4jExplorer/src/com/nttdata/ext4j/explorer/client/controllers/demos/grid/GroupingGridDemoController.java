package com.nttdata.ext4j.explorer.client.controllers.demos.grid;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.GroupingGridDemo;

public class GroupingGridDemoController extends AbstractDemoController {

    private static final GroupingGridDemoController INSTANCE = new GroupingGridDemoController();

    public static GroupingGridDemoController get() {
        return INSTANCE;
    }

    private GroupingGridDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return GroupingGridDemo.get();
    }

}
