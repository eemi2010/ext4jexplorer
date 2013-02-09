package com.nttdata.ext4j.explorer.client.data;

import java.util.ArrayList;

import com.nttdata.ext4j.client.data.TableItem;
import com.nttdata.ext4j.explorer.client.ui.demos.buttons.ButtonsDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.AreaChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.BarChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.CustomBarChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.LineChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.MixedSeriesChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.PieChartDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.combination.GoogleMapDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.combination.PortalDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.grid.SimpleGridDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AbsoluteLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AccordionLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.AnchorLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.BorderLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.CardLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.layout.ColumnLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.tabs.AdvancedTabsDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.tabs.BasicTabsDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.tabs.TabScrollerMenuDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.windows.MessageBoxDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.windows.WindowLayoutDemo;
import com.nttdata.ext4j.explorer.client.ui.demos.windows.WindowsVariationDemo;

public class ExamplesData {

    private ExamplesData() {

    }

    public static TableItem getData() {
        NavigationItem root = new NavigationItem("Examples");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(getChartsData());
        items.add(getComponentsData());
        items.add(getTabsData());
        items.add(getWindowsData());
        items.add(getLayoutsData());
        items.add(getGridsData());
        items.add(getCombinationExampleData());
        root.setChildren(items);

        return root;
    }

    private static TableItem getChartsData() {
        NavigationItem root = new NavigationItem("Charts");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(AreaChartDemo.TITLE));
        items.add(new NavigationItem(BarChartDemo.TITLE));
        items.add(new NavigationItem(CustomBarChartDemo.TITLE));
        // items.add(new NavigationItem("Column Charts"));
        items.add(new NavigationItem(LineChartDemo.TITLE));
        items.add(new NavigationItem("Radar Charts"));
        // items.add(new NavigationItem("Column Custom Background"));
        items.add(new NavigationItem(MixedSeriesChartDemo.TITLE));
        items.add(new NavigationItem(PieChartDemo.TITLE));
        items.add(new NavigationItem("Gauge Charts"));
        // items.add(new NavigationItem("Live Animated Charts"));
        // items.add(new NavigationItem("Grouped Bar"));

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

    private static TableItem getTabsData() {
        NavigationItem root = new NavigationItem("Tabs");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(BasicTabsDemo.TITLE));
        items.add(new NavigationItem(AdvancedTabsDemo.TITLE));
        items.add(new NavigationItem(TabScrollerMenuDemo.TITLE));

        root.setChildren(items);

        return root;
    }

    private static TableItem getWindowsData() {
        NavigationItem root = new NavigationItem("Windows");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(WindowLayoutDemo.TITLE));
        items.add(new NavigationItem(WindowsVariationDemo.TITLE));
        items.add(new NavigationItem(MessageBoxDemo.TITLE));

        root.setChildren(items);

        return root;
    }

    private static TableItem getGridsData() {
        NavigationItem root = new NavigationItem("Grids");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(SimpleGridDemo.TITLE));
        items.add(new NavigationItem("Grouping"));
        items.add(new NavigationItem("Paging"));
        items.add(new NavigationItem("Filtering"));
        items.add(new NavigationItem("Grid Plugins"));
        items.add(new NavigationItem("Grid Cell Editinh"));
        items.add(new NavigationItem("Multiple Sorting"));
        items.add(new NavigationItem("Data Binding"));
        items.add(new NavigationItem("Grid Row Editing"));
        items.add(new NavigationItem("Multiple Sorting"));
        items.add(new NavigationItem("Infinite Grid"));
        items.add(new NavigationItem("Grid with Locking"));
        items.add(new NavigationItem("Property Grid"));
        items.add(new NavigationItem("Grouped Header"));
        items.add(new NavigationItem("Row Editing"));
        items.add(new NavigationItem("Live Search"));
        items.add(new NavigationItem("Grouping with summary"));
        items.add(new NavigationItem("Sliding Pager"));

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
        items.add(new NavigationItem(ColumnLayoutDemo.TITLE));
        items.add(new NavigationItem("Fit"));
        items.add(new NavigationItem("Table"));
        items.add(new NavigationItem("vBox"));
        items.add(new NavigationItem("hBox"));

        root.setChildren(items);

        return root;
    }

    private static TableItem getCombinationExampleData() {
        NavigationItem root = new NavigationItem("Combination Examples");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new NavigationItem(PortalDemo.TITLE));
        items.add(new NavigationItem(GoogleMapDemo.TITLE));

        root.setChildren(items);

        return root;
    }
}
