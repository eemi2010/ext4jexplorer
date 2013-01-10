package com.nttdata.ext4j.explorer.client.ui.demos.charts;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.gwt4ext.client.chart.axis.CategoryAxis;
import com.nttdata.gwt4ext.client.chart.axis.NumericAxis;
import com.nttdata.gwt4ext.client.chart.laf.BarAttribute;
import com.nttdata.gwt4ext.client.chart.laf.Label;
import com.nttdata.gwt4ext.client.chart.series.BarSerie;
import com.nttdata.gwt4ext.client.chart.series.renderers.SeriesRenderer;
import com.nttdata.gwt4ext.client.core.EventObject;
import com.nttdata.gwt4ext.client.core.config.Position;
import com.nttdata.gwt4ext.client.data.JsonStore;
import com.nttdata.gwt4ext.client.data.Record;
import com.nttdata.gwt4ext.client.data.Store;
import com.nttdata.gwt4ext.client.draw.Sprite;
import com.nttdata.gwt4ext.client.events.handlers.button.InteractionHandler;
import com.nttdata.gwt4ext.client.laf.Color;
import com.nttdata.gwt4ext.client.layout.Layout;
import com.nttdata.gwt4ext.client.ui.Button;
import com.nttdata.gwt4ext.client.ui.Chart;
import com.nttdata.gwt4ext.client.ui.Panel;
import com.nttdata.gwt4ext.client.ui.ToolBar;
import com.nttdata.gwt4ext.client.util.Format;

public class CustomBarChartDemo extends DemoBase {

    public static final String TITLE = "Custom Bar Charts";
    private JsonStore store;

    public CustomBarChartDemo() {
        store = ChartDataUtil.getStore(12, 20);
        Chart chart = createChart();

        Panel panel = new Panel("Bar Chart");
        panel.setLayout(Layout.FIT);
        panel.setSize(1000, 600);
        panel.setCollapsible(true);
        panel.setXY(30, 50);
        panel.setTitleAlign(Position.CENTER);

        ToolBar toolBar = new ToolBar();
        toolBar.add(new Button("Reload Data", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                store.loadData(ChartDataUtil.generateData(12, 20));
            }
        }));
        panel.addDocked(toolBar);
        panel.add(chart);

        demoPanel.add(panel);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

    private Chart createChart() {

        final List<String> colors = new ArrayList<String>();
        colors.add("rgb(213, 70, 121)");
        colors.add("rgb(44, 153, 201)");
        colors.add("rgb(146, 6, 157)");
        colors.add("rgb(49, 149, 0)");
        colors.add("rgb(249, 153, 0)");

        final Chart chart = new Chart(store);
        chart.setShadow(true);
        chart.setAnimate(true);

        NumericAxis nAxis = new NumericAxis();
        nAxis.setPosition(Position.BOTTOM);
        nAxis.setTitle("Number of Hits");
        nAxis.setFields("data1");
        nAxis.setMinimum(0);

        Label l = new Label();
        l.setRenderer(Format.getNumberRender("0,0"));
        nAxis.setLabel(l);
        nAxis.setGrid(true);
        chart.addAxis(nAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.LEFT);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        chart.addAxis(categoryAxis);

        chart.drawAxis();

        BarSerie serie = new BarSerie();
        serie.setAxis(Position.BOTTOM);
        serie.setXField("name");
        serie.setYField("data1");
        serie.setRenderer(new SeriesRenderer() {
            @Override
            public JavaScriptObject onRender(Sprite sprite, Record record, BarAttribute attributes, int index,
                            Store store) {
                int value = (int) record.getNumber("data1");
                int i = (value >> 0) % 5;
                String color = colors.get(i);
                attributes.setFill(color);
                return attributes;
            }
        });

        l = new Label();
        l.setDisplay("insideEnd");
        l.setField("data1");
        l.setOrientation("horizontal");
        l.setColor("#333");
        l.setTextAnchor("middle");
        l.setRenderer(Format.getNumberRender("0"));
        serie.setLabel(l);

        chart.addSeries(serie);
        chart.drawSeries();
        chart.setBackGroundFill(Color.BISQUE);

        return chart;
    }
}
