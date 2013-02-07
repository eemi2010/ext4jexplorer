package com.nttdata.ext4j.explorer.client.ui.demos.charts;

import com.google.gwt.core.client.JavaScriptObject;
import com.nttdata.ext4j.client.chart.ChartTooltipRenderer;
import com.nttdata.ext4j.client.chart.axis.CategoryAxis;
import com.nttdata.ext4j.client.chart.axis.NumericAxis;
import com.nttdata.ext4j.client.chart.laf.ChartTooltip;
import com.nttdata.ext4j.client.chart.laf.Label;
import com.nttdata.ext4j.client.chart.series.BarSerie;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.data.BaseModel;
import com.nttdata.ext4j.client.data.JsonStore;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Chart;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.ToolTip;
import com.nttdata.ext4j.client.util.Format;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class BarChartDemo extends DemoBase {

    public static final String TITLE = "Bar Chart";
    private JsonStore store;

    public BarChartDemo() {
        store = ChartDataUtil.getStore(12, 20);
        Chart chart = createChart();

        Panel panel = new Panel("Bar Chart");
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

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.BOTTOM);
        numericAxis.setTitle("Number of Hits");
        numericAxis.setFields("data1");
        numericAxis.setMinimum(0);

        Label l = new Label();
        l.setRenderer(Format.getNumberRender("0,0"));
        numericAxis.setLabel(l);
        numericAxis.setGrid(true);
        chart.addAxis(numericAxis);

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

        ChartTooltip tip = new ChartTooltip();
        tip.setTrackMouse(true);
        tip.setWidth(140);
        tip.setHeight(28);
        tip.setRenderer(new ChartTooltipRenderer() {
            @Override
            public void onRender(ToolTip tip, BaseModel record, JavaScriptObject item) {
                tip.setTitle(record.getAsString("name") + " : " + record.getAsInteger("data1") + " views");
            }
        });
        serie.setTips(tip);
        serie.setHighLight(true);

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

        return chart;
    }
}
