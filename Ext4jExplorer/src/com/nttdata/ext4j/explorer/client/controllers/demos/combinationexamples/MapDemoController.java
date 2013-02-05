package com.nttdata.ext4j.explorer.client.controllers.demos.combinationexamples;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.combination.GoogleMapDemo;

public class MapDemoController extends AbstractDemoController {

    private static final MapDemoController INSTANCE = new MapDemoController();

    public static MapDemoController get() {
        return INSTANCE;
    }

    private MapDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return GoogleMapDemo.get();
    }

}
