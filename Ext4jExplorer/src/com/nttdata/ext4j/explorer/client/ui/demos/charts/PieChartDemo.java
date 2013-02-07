package com.nttdata.ext4j.explorer.client.ui.demos.charts;

import com.google.gwt.core.client.JavaScriptObject;
import com.nttdata.ext4j.client.chart.ChartTooltipRenderer;
import com.nttdata.ext4j.client.chart.HighLighter;
import com.nttdata.ext4j.client.chart.Legend;
import com.nttdata.ext4j.client.chart.Segment;
import com.nttdata.ext4j.client.chart.laf.ChartTooltip;
import com.nttdata.ext4j.client.chart.laf.Label;
import com.nttdata.ext4j.client.chart.series.PieSerie;
import com.nttdata.ext4j.client.chart.theme.Theme;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.data.BaseModel;
import com.nttdata.ext4j.client.data.JsonStore;
import com.nttdata.ext4j.client.data.handlers.EachCallBack;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Chart;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.ToolTip;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class PieChartDemo extends DemoBase {

    public static final String TITLE = "Pie Chart";
    private JsonStore store;
    private PieSerie serie;

    public PieChartDemo() {
        store = ChartDataUtil.getStore(6, 20);
        final Chart chart = createChart();

        Panel panel = new Panel(TITLE);
        panel.setLayout(Layout.FIT);
        panel.setFrame(true);
        panel.setCollapsible(true);
        panel.setTitleAlign(Position.CENTER);
        panel.add(chart);

        Button donutButton = new Button("Donut", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                if (button.isPressed()) {
                    chart.getSeries().get(0).setDonut(35);
                } else {
                    chart.getSeries().get(0).setDonut(false);
                }
                chart.refresh();
            }
        });
        donutButton.setEnableToggle(true);

        panel.addButtons(donutButton, new Button("Reload Data", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                store.loadData(ChartDataUtil.generateData(6, 20));
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
        chart.setStyle("background:#fff");
        chart.setLegend(new Legend(Position.RIGHT));
        chart.setAnimate(true);
        chart.setShadow(true);
        chart.setInsetPadding(60);
        chart.setTheme(Theme.BASE_GRADIENTS);

        serie = new PieSerie();
        serie.setField("data1");
        serie.setShowInLegend(true);

        ChartTooltip toolTip = new ChartTooltip();
        toolTip.setTrackMouse(true);
        toolTip.setWidth(140);
        toolTip.setHeight(28);
        toolTip.setRenderer(new ChartTooltipRenderer() {
            private int total;

            @Override
            public void onRender(ToolTip tip, BaseModel record, JavaScriptObject item) {
                total = 0;
                store.each(new EachCallBack() {
                    @Override
                    public void onEach(BaseModel record) {
                        total += (int) record.getAsInteger("data1");
                    }
                });
                tip.setTitle(record.getAsString("name") + " : " + Math.round(record.getAsNumber("data1") / total * 100)
                                + " %");
            }
        });
        serie.setTips(toolTip);

        HighLighter highlither = new HighLighter();
        highlither.setSegment(new Segment(20));
        serie.setHighLighter(highlither);

        Label label = new Label();
        label.setField("name");
        label.setDisplay("rotate");
        label.setContrast(true);
        label.setFont("18px Arial");
        serie.setLabel(label);

        chart.addSeries(serie);
        chart.drawSeries();
        return chart;
    }
}
