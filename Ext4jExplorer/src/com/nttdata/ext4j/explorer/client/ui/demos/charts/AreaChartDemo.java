package com.nttdata.ext4j.explorer.client.ui.demos.charts;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.ext4j.client.chart.Legend;
import com.nttdata.ext4j.client.chart.axis.CategoryAxis;
import com.nttdata.ext4j.client.chart.axis.NumericAxis;
import com.nttdata.ext4j.client.chart.laf.GridConfig;
import com.nttdata.ext4j.client.chart.laf.Label;
import com.nttdata.ext4j.client.chart.laf.Style;
import com.nttdata.ext4j.client.chart.series.AreaSerie;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.core.config.SpriteConfig;
import com.nttdata.ext4j.client.data.JsonStore;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Chart;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class AreaChartDemo extends DemoBase {

    public static final String TITLE = "Area Chart";
    private JsonStore store;

    public AreaChartDemo() {
        store = ChartDataUtil.getStore(12, 20);
        Chart chart = createChart();

        Panel panel = new Panel("Area Chart");
        panel.setLayout(Layout.FIT);
        panel.setFrame(true);
        panel.setCollapsible(true);
        panel.setTitleAlign(Position.CENTER);
        panel.add(chart);
        panel.addButtons(new Button("Reload Data", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                store.loadData(ChartDataUtil.generateData(12, 20));
            }
        }));

        demoPanel.setLayout(Layout.FIT);
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

        Legend legend = new Legend(Position.BOTTOM);
        chart.setLegend(legend);

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setTitle("Number of Hits");
        numericAxis.setFields("data1", "data2", "data3", "data4", "data5", "data6", "data7");

        SpriteConfig odd = new SpriteConfig();
        odd.setOpacity(1);
        odd.setFill("#ddd");
        odd.setStroke("#bbb");
        odd.setStrokeWidth(1);

        numericAxis.setGrid(new GridConfig(odd));
        numericAxis.setMinimum(0);
        numericAxis.setAdjustMaximumByMajorUnit(false);
        chart.addAxis(numericAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        categoryAxis.setGrid(true);

        Label label = new Label();
        label.setRotate(315);
        categoryAxis.setLabel(label);
        chart.addAxis(categoryAxis);

        chart.drawAxis();

        AreaSerie serie = new AreaSerie();
        serie.setHighLight(false);
        serie.setXField("name");
        serie.setYField("data1", "data2", "data3", "data4", "data5", "data6", "data7");

        Style style = new Style();
        style.setOpacity(0.93);
        serie.setStyle(style);

        chart.addSeries(serie);
        chart.drawSeries();

        return chart;
    }
}
