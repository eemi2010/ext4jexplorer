package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.AreaChartDemo;

public class AreaChartDemoController extends AbstractDemoController {

    private static final AreaChartDemoController INSTANCE = new AreaChartDemoController();

    public static AreaChartDemoController get() {
        return INSTANCE;
    }

    private AreaChartDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new AreaChartDemo();
    }

}
