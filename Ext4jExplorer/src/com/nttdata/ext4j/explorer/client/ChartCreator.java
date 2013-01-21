package com.nttdata.ext4j.explorer.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.nttdata.ext4j.client.chart.ChartTooltipRenderer;
import com.nttdata.ext4j.client.chart.HighLighter;
import com.nttdata.ext4j.client.chart.Legend;
import com.nttdata.ext4j.client.chart.Segment;
import com.nttdata.ext4j.client.chart.axis.CategoryAxis;
import com.nttdata.ext4j.client.chart.axis.NumericAxis;
import com.nttdata.ext4j.client.chart.axis.RadialAxis;
import com.nttdata.ext4j.client.chart.laf.BarAttribute;
import com.nttdata.ext4j.client.chart.laf.ChartTooltip;
import com.nttdata.ext4j.client.chart.laf.GridConfig;
import com.nttdata.ext4j.client.chart.laf.Label;
import com.nttdata.ext4j.client.chart.laf.Style;
import com.nttdata.ext4j.client.chart.series.AreaSerie;
import com.nttdata.ext4j.client.chart.series.BarSerie;
import com.nttdata.ext4j.client.chart.series.PieSerie;
import com.nttdata.ext4j.client.chart.series.RadarSerie;
import com.nttdata.ext4j.client.chart.series.renderers.SeriesRenderer;
import com.nttdata.ext4j.client.chart.theme.Theme;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.core.config.SpriteConfig;
import com.nttdata.ext4j.client.data.Record;
import com.nttdata.ext4j.client.data.Store;
import com.nttdata.ext4j.client.data.handlers.EachCallBack;
import com.nttdata.ext4j.client.draw.Sprite;
import com.nttdata.ext4j.client.laf.Color;
import com.nttdata.ext4j.client.ui.Chart;
import com.nttdata.ext4j.client.ui.DatePicker;
import com.nttdata.ext4j.client.ui.ToolTip;
import com.nttdata.ext4j.client.util.Format;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;

public class ChartCreator {

    private static final Store store = ChartDataUtil.getStore(12, 20);
    private static final Store barStore = ChartDataUtil.getStore(6, 20);

    public static Chart createAreaChart() {
        final Chart chart = new Chart(store);
        // chart.setTheme(Theme.GREEN);
        chart.setStyle("background:#fff");
        chart.setLegend(new Legend(Position.BOTTOM));
        chart.setAnimate(true);

        NumericAxis nAxis = new NumericAxis();

        SpriteConfig sprite = new SpriteConfig();
        sprite.setOpacity(1);
        sprite.setFill(Color.LIGHTGRAY);
        sprite.setStroke("#bbb");
        sprite.setStrokeWidth(1);

        nAxis.setGrid(new GridConfig(sprite));

        nAxis.setPosition(Position.LEFT);
        nAxis.setTitle("Number of Hits");
        nAxis.setFields("data1", "data2", "data3", "data4", "data5", "data6", "data7");
        nAxis.setMinimum(0);
        nAxis.setAdjustMaximumByMajorUnit(true);
        chart.addAxis(nAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        categoryAxis.setGrid(true);

        Label l = new Label();
        l.setRotate(315);
        categoryAxis.setLabel(l);
        chart.addAxis(categoryAxis);
        chart.drawAxis();

        AreaSerie serie = new AreaSerie();
        serie.setAxis(Position.LEFT);
        serie.setXField("name");
        serie.setYField("data1", "data2", "data3", "data4", "data5", "data6", "data7");

        Style style = new Style();
        style.setOpacity(0.93);
        serie.setStyle(style);
        chart.addSeries(serie);
        chart.drawSeries();
        return chart;
    }

    public static Chart createBarChart() {

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
        serie.setHighLight(true);
        serie.setXField("name");
        serie.setYField("data1");

        final ChartTooltip chartTip = new ChartTooltip();
        chartTip.setTrackMouse(true);
        chartTip.setWidth(200);
        chartTip.setHeight(200);
        chartTip.setRenderer(new ChartTooltipRenderer() {
            @Override
            public void onRender(ToolTip tip, Record record, JavaScriptObject item) {
                String title = record.getString("name") + ": " + (int) record.getNumber("data1") + " views";
                tip.setTitle(title);
            }
        });
        chartTip.setItems(new DatePicker());
        serie.setTips(chartTip);

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

    public static Chart createCustomBarChart() {

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

    public static Chart createPieChart() {
        final Chart chart = new Chart(barStore);
        chart.setStyle("background:#fff");
        chart.setLegend(new Legend(Position.RIGHT));
        chart.setAnimate(true);
        chart.setShadow(true);
        chart.setInsetPadding(60);
        chart.setTheme(Theme.BASE_GRADIENTS);

        PieSerie serie = new PieSerie();
        serie.setField("data1");
        serie.setShowInLegend(true);

        ChartTooltip toolTip = new ChartTooltip();
        toolTip.setTrackMouse(true);
        toolTip.setWidth(140);
        toolTip.setHeight(28);
        toolTip.setRenderer(new ChartTooltipRenderer() {
            private int total;

            @Override
            public void onRender(ToolTip tip, Record record, JavaScriptObject item) {
                total = 0;
                barStore.each(new EachCallBack() {
                    @Override
                    public void onEachRecord(Record record) {
                        total += (int) record.getNumber("data1");
                    }
                });
                tip.setTitle(record.getString("name") + " : " + Math.round(record.getNumber("data1") / total * 100)
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

    public static Chart createRadarChart() {
        final Chart chart = new Chart(store);
        chart.setStyle("background:#fff");
        chart.setLegend(new Legend(Position.RIGHT));
        chart.setAnimate(true);
        chart.setInsetPadding(20);
        chart.setTheme(Theme.BASE);

        RadialAxis axe = new RadialAxis();

        Label label = new Label();
        label.setDisplay(true);
        axe.setLabel(label);

        chart.addAxis(axe);
        chart.drawSeries();

        RadarSerie serie = new RadarSerie();
        serie.setXField("name");
        serie.setYField("data1");

        Style style = new Style();
        style.setOpacity(0.4);
        serie.setStyle(style);
        serie.setShowInLegend(true);
        chart.addSeries(serie);

        serie = new RadarSerie();
        serie.setXField("name");
        serie.setYField("data2");

        style = new Style();
        style.setOpacity(0.4);
        serie.setStyle(style);
        serie.setShowInLegend(true);
        chart.addSeries(serie);

        serie = new RadarSerie();
        serie.setXField("name");
        serie.setYField("data3");

        style = new Style();
        style.setOpacity(0.4);
        serie.setStyle(style);
        serie.setShowInLegend(true);
        chart.addSeries(serie);
        chart.drawSeries();

        return chart;
    }

    public static Store getStore() {
        return store;
    }
}
