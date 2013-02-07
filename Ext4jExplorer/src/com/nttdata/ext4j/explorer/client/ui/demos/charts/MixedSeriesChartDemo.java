package com.nttdata.ext4j.explorer.client.ui.demos.charts;

import com.nttdata.ext4j.client.chart.axis.CategoryAxis;
import com.nttdata.ext4j.client.chart.axis.NumericAxis;
import com.nttdata.ext4j.client.chart.marker.Cross;
import com.nttdata.ext4j.client.chart.series.ColumnSerie;
import com.nttdata.ext4j.client.chart.series.LineSerie;
import com.nttdata.ext4j.client.chart.series.ScatterSerie;
import com.nttdata.ext4j.client.chart.theme.Theme;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.data.JsonStore;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Chart;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class MixedSeriesChartDemo extends DemoBase {

    public static final String TITLE = "Mixed Charts";
    private JsonStore store;

    public MixedSeriesChartDemo() {
        store = ChartDataUtil.getStore(8, 20);
        Chart chart = createChart();

        Panel panel = new Panel(TITLE);
        panel.setLayout(Layout.FIT);
        panel.setFrame(true);
        panel.setCollapsible(true);
        panel.setTitleAlign(Position.CENTER);

        panel.add(chart);

        panel.addButtons(new Button("Reload Data", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                store.loadData(ChartDataUtil.generateData(8, 20));
            }
        }));

        demoPanel.setLayout(Layout.FIT);
        demoPanel.add(panel);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

    public Chart createChart() {

        final Chart chart = new Chart(store);
        chart.setShadow(true);
        chart.setAnimate(true);
        chart.setTheme(Theme.CATEGORY1);

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setTitle("Number of Hits");
        numericAxis.setFields("data1", "data2", "data3");
        numericAxis.setGrid(true);
        chart.addAxis(numericAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setFields("name");
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setTitle("Month of the year");
        chart.addAxis(categoryAxis);

        chart.drawAxis();

        ColumnSerie columnSerie = new ColumnSerie();
        columnSerie.setAxis(Position.LEFT);
        columnSerie.setXField("name");
        columnSerie.setYField("data1");
        columnSerie.setMarker(new Cross(5, 1));
        chart.addSeries(columnSerie);

        ScatterSerie scatterSerie = new ScatterSerie();
        scatterSerie.setAxis(Position.LEFT);
        scatterSerie.setXField("name");
        scatterSerie.setYField("data2");
        scatterSerie.setMarker(new Cross(5, 1));
        chart.addSeries(scatterSerie);

        LineSerie lineSerie = new LineSerie();
        lineSerie.setAxis(Position.LEFT);
        lineSerie.setSmooth(true);
        lineSerie.setFill(true);
        lineSerie.setFillOpacitiy(0.5);
        lineSerie.setXField("name");
        lineSerie.setYField("data3");
        chart.addSeries(lineSerie);

        chart.drawSeries();

        return chart;
    }
}
