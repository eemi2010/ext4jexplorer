package com.eemi.ext4j.explorer.client.modules.charts;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.chart.axis.AbstractAxis;
import com.eemi.ext4j.client.chart.axis.CategoryAxis;
import com.eemi.ext4j.client.chart.axis.NumericAxis;
import com.eemi.ext4j.client.chart.laf.BarAttribute;
import com.eemi.ext4j.client.chart.laf.Label;
import com.eemi.ext4j.client.chart.series.AbstractSerie;
import com.eemi.ext4j.client.chart.series.BarSerie;
import com.eemi.ext4j.client.chart.series.renderers.SeriesRenderer;
import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.draw.Sprite;
import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.laf.Color;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Chart;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.client.util.Format;
import com.eemi.ext4j.explorer.client.data.DataUtil;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.charts.resources.ChartsModuleResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.google.gwt.core.client.JavaScriptObject;

public class CustomBarChartModule extends BaseDemoModule {

    public static final CustomBarChartModule INSTANCE = new CustomBarChartModule();

    private static final String TITLE = "Custom Bar Charts";
    private Store store;

    private CustomBarChartModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(TITLE);
        moduleConfig.setModuleDescription("Ext4j Custom Bar Chart demo");
        moduleConfig.setWallPaperIcon(ChartsModuleResources.ICONS.customBar128());
        moduleConfig.setToolbarIcon(ChartsModuleResources.ICONS.customBar24());
        moduleConfig.setMenuItemIcon(ChartsModuleResources.ICONS.customBar16());
        moduleConfig.setInitialWindowXPosition(500);
        moduleConfig.setInitialWindowYPosition(300);
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setLayout(Layout.FIT);
        win.setBodyPadding(20);

        ToolBar tb = new ToolBar();
        tb.setDocked(Dock.TOP);
        Button reloadButton = new Button("Reload");
        reloadButton.setCls("x-btn-default-small");
        reloadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                store.loadData(DataUtil.generateData(12, 20));
            }
        });
        tb.add(reloadButton);
        win.addDocked(tb);

        Chart chart = createChart();
        win.add(chart);

        return win;
    }

    private Chart createChart() {

        final List<String> colors = new ArrayList<String>();
        colors.add("rgb(213, 70, 121)");
        colors.add("rgb(44, 153, 201)");
        colors.add("rgb(146, 6, 157)");
        colors.add("rgb(49, 149, 0)");
        colors.add("rgb(249, 153, 0)");

        final List<AbstractSerie> series = new ArrayList<AbstractSerie>();

        BarSerie serie = new BarSerie();
        serie.setAxis(Position.BOTTOM);
        serie.setXField("name");
        serie.setYField("data1");
        serie.setRenderer(new SeriesRenderer() {
            @Override
            public JavaScriptObject onRender(Sprite sprite, BaseModel record, BarAttribute attributes, int index,
                            Store store) {
                int value = record.getAsInteger("data1");
                int i = (value >> 0) % 5;
                String color = colors.get(i);
                attributes.setFill(color);
                return attributes;
            }
        });

        Label l = new Label();
        l.setDisplay("insideEnd");
        l.setField("data1");
        l.setOrientation("horizontal");
        l.setColor("#333");
        l.setTextAnchor("middle");
        l.setRenderer(Format.getNumberRender("0"));
        serie.setLabel(l);

        series.add(serie);

        final List<AbstractAxis> axis = new ArrayList<AbstractAxis>();

        NumericAxis nAxis = new NumericAxis();
        nAxis.setPosition(Position.BOTTOM);
        nAxis.setTitle("Number of Hits");
        nAxis.setFields("data1");
        nAxis.setMinimum(0);

        l = new Label();
        l.setRenderer(Format.getNumberRender("0,0"));
        nAxis.setLabel(l);
        nAxis.setGrid(true);
        axis.add(nAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.LEFT);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        axis.add(categoryAxis);

        store = new Store(ChartData.generateData(12));

        final Chart chart = Chart.newInstance(store, axis, series);
        chart.setShadow(true);
        chart.setAnimate(true);
        chart.setBackGroundFill(Color.BISQUE);

        return chart;
    }
}
