package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.CustomBarChartDemo;

public class CustomBarChartController extends AbstractDemoController {

    private static final CustomBarChartController INSTANCE = new CustomBarChartController();

    public static CustomBarChartController get() {
        return INSTANCE;
    }

    private CustomBarChartController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new CustomBarChartDemo();
    }

}
