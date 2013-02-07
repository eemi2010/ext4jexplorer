package com.nttdata.ext4j.explorer.client.ui.demos.charts;

import com.nttdata.ext4j.client.chart.HighLighter;
import com.nttdata.ext4j.client.chart.Legend;
import com.nttdata.ext4j.client.chart.axis.CategoryAxis;
import com.nttdata.ext4j.client.chart.axis.NumericAxis;
import com.nttdata.ext4j.client.chart.laf.GridConfig;
import com.nttdata.ext4j.client.chart.marker.Circle;
import com.nttdata.ext4j.client.chart.marker.Cross;
import com.nttdata.ext4j.client.chart.series.LineSerie;
import com.nttdata.ext4j.client.chart.theme.Theme;
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

public class LineChartDemo extends DemoBase {

    public static final String TITLE = "Line Chart";
    private JsonStore store;

    public LineChartDemo() {
        store = ChartDataUtil.getStore(12, 20);
        Chart chart = createChart();

        Panel panel = new Panel("Line Chart");
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

        final Chart chart = new Chart(store);
        chart.setShadow(true);
        chart.setAnimate(true);
        chart.setTheme(Theme.CATEGORY1);

        Legend legend = new Legend(Position.RIGHT);
        chart.setLegend(legend);

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setTitle("Number of Hits");
        numericAxis.setFields("data1", "data2", "data3");
        numericAxis.setMinorTickSteps(1);
        numericAxis.setMinimum(0);

        SpriteConfig odd = new SpriteConfig();
        odd.setOpacity(1);
        odd.setFill("#ddd");
        odd.setStroke("#bbb");
        odd.setStrokeWidth(0.5);
        numericAxis.setGrid(new GridConfig(odd));
        chart.addAxis(numericAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        chart.addAxis(categoryAxis);

        chart.drawAxis();

        LineSerie serie = new LineSerie();
        serie.setHighLighter(new HighLighter(7, 7));
        serie.setAxis(Position.LEFT);
        serie.setXField("name");
        serie.setYField("data1");
        serie.setMarker(new Cross(4, 4, 0));
        chart.addSeries(serie);

        serie = new LineSerie();
        serie.setHighLighter(new HighLighter(7, 7));
        serie.setSmooth(true);
        serie.setAxis(Position.LEFT);
        serie.setXField("name");
        serie.setYField("data2");
        serie.setMarker(new Circle(4, 4, 0));
        chart.addSeries(serie);

        serie = new LineSerie();
        serie.setHighLighter(new HighLighter(7, 7));
        serie.setSmooth(true);
        serie.setAxis(Position.LEFT);
        serie.setXField("name");
        serie.setFill(true);
        serie.setYField("data3");
        serie.setMarker(new Circle(4, 4, 0));
        chart.addSeries(serie);

        chart.drawSeries();

        return chart;
    }
}
