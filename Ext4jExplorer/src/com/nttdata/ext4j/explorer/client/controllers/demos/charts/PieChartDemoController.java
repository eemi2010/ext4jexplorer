package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.PieChartDemo;

public class PieChartDemoController extends AbstractDemoController {

    private static final PieChartDemoController INSTANCE = new PieChartDemoController();

    public static PieChartDemoController get() {
        return INSTANCE;
    }

    private PieChartDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new PieChartDemo();
    }

}
