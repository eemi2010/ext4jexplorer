package com.nttdata.ext4j.explorer.client.data;

import java.util.ArrayList;

import com.nttdata.ext4j.explorer.client.ui.demos.buttons.ButtonsDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.CustomBarChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AbsoluteLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AccordionLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AnchorLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.BorderLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.CardLayoutDemo;
import com.nttdata.gwt4ext.client.data.TableItem;

public class ExamplesData {

    private ExamplesData() {

    }

    public static TableItem getData() {
        NavigationItem root = new NavigationItem("Examples");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(getChartsData());
        items.add(getComponentsData());
        items.add(getLayoutsData());
        root.setChildren(items);

        return root;
    }

    private static TableItem getChartsData() {
        NavigationItem root = new NavigationItem("Charts");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem("Area Charts"));
        items.add(new NavigationItem("Bar Charts"));
        items.add(new NavigationItem(CustomBarChartDemo.TITLE));
        items.add(new NavigationItem("Column Charts"));
        items.add(new NavigationItem("Line Charts"));
        items.add(new NavigationItem("Radar Charts"));
        items.add(new NavigationItem("Column Custom Background"));
        items.add(new NavigationItem("Mixed Series Chart"));
        items.add(new NavigationItem("Pie Charts"));
        items.add(new NavigationItem("Gauge Charts"));
        items.add(new NavigationItem("Live Animated Charts"));
        items.add(new NavigationItem("Grouped Bar"));

        root.setChildren(items);

        return root;
    }

    private static TableItem getComponentsData() {
        NavigationItem root = new NavigationItem("Components");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(ButtonsDemo.TITLE));
        items.add(new NavigationItem("DatePicker"));
        items.add(new NavigationItem("Slider"));

        root.setChildren(items);

        return root;
    }

    private static TableItem getLayoutsData() {
        NavigationItem root = new NavigationItem("Layouts");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(AbsoluteLayoutDemo.TITLE));
        items.add(new NavigationItem(AccordionLayoutDemo.TITLE));
        items.add(new NavigationItem(AnchorLayoutDemo.TITLE));
        items.add(new NavigationItem(BorderLayoutDemo.TITLE));
        // items.add(new NavigationItem("Card (TabPanel"));
        items.add(new NavigationItem(CardLayoutDemo.TITLE));
        items.add(new NavigationItem("Column"));
        items.add(new NavigationItem("Fit"));
        items.add(new NavigationItem("Table"));
        items.add(new NavigationItem("vBox"));
        items.add(new NavigationItem("hBox"));

        root.setChildren(items);

        return root;
    }
}
