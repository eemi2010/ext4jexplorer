package com.nttdata.ext4j.explorer.client.controllers.demos.charts;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.MixedSeriesChartDemo;

public class MixedSeriesChartDemoController extends AbstractDemoController {

    private static final MixedSeriesChartDemoController INSTANCE = new MixedSeriesChartDemoController();

    public static MixedSeriesChartDemoController get() {
        return INSTANCE;
    }

    private MixedSeriesChartDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return new MixedSeriesChartDemo();
    }

}
