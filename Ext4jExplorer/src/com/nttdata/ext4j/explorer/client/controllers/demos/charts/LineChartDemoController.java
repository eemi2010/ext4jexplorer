package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.LineChartDemo;

public class LineChartDemoController extends AbstractDemoController {

    private static final LineChartDemoController INSTANCE = new LineChartDemoController();

    public static LineChartDemoController get() {
        return INSTANCE;
    }

    private LineChartDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new LineChartDemo();
    }

}
