package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.BarChartDemo;

public class BarChartDemoController extends AbstractDemoController {

    private static final BarChartDemoController INSTANCE = new BarChartDemoController();

    public static BarChartDemoController get() {
        return INSTANCE;
    }

    private BarChartDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new BarChartDemo();
    }

}
