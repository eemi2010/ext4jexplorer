package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.CustomBarChartDemo;

public class CustomBarChartDemoController extends AbstractDemoController {

    private static final CustomBarChartDemoController INSTANCE = new CustomBarChartDemoController();

    public static CustomBarChartDemoController get() {
        return INSTANCE;
    }

    private CustomBarChartDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new CustomBarChartDemo();
    }

}
