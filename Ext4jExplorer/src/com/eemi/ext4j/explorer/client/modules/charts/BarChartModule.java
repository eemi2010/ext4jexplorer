package com.eemi.ext4j.explorer.client.modules.charts;

import com.eemi.ext4j.client.chart.ChartTooltipRenderer;
import com.eemi.ext4j.client.chart.axis.CategoryAxis;
import com.eemi.ext4j.client.chart.axis.NumericAxis;
import com.eemi.ext4j.client.chart.laf.ChartTooltip;
import com.eemi.ext4j.client.chart.laf.Label;
import com.eemi.ext4j.client.chart.series.BarSerie;
import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.data.JsonStore;
import com.eemi.ext4j.client.eventhandling.button.ClickEvent;
import com.eemi.ext4j.client.eventhandling.button.ClickHandler;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Chart;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.client.ui.ToolTip;
import com.eemi.ext4j.client.util.Format;
import com.eemi.ext4j.explorer.client.data.DataUtil;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.charts.resources.ChartsModuleResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.google.gwt.core.client.JavaScriptObject;

public class BarChartModule extends BaseDemoModule {

    public static final BarChartModule INSTANCE = new BarChartModule();

    private static final String TITLE = "Bar Chart";
    private JsonStore store;

    private BarChartModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(TITLE);
        moduleConfig.setModuleDescription("Ext4j Bar Chart demo");
        moduleConfig.setWallPaperIcon(ChartsModuleResources.ICONS.bar128());
        moduleConfig.setToolbarIcon(ChartsModuleResources.ICONS.bar24());
        moduleConfig.setMenuItemIcon(ChartsModuleResources.ICONS.bar16());
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
        store = DataUtil.getStore(12, 20);

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
