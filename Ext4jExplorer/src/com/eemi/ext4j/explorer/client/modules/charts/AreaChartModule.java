package com.eemi.ext4j.explorer.client.modules.charts;

import com.eemi.ext4j.client.chart.Legend;
import com.eemi.ext4j.client.chart.axis.CategoryAxis;
import com.eemi.ext4j.client.chart.axis.NumericAxis;
import com.eemi.ext4j.client.chart.laf.GridConfig;
import com.eemi.ext4j.client.chart.laf.Label;
import com.eemi.ext4j.client.chart.laf.Style;
import com.eemi.ext4j.client.chart.series.AreaSerie;
import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.core.config.SpriteConfig;
import com.eemi.ext4j.client.data.JsonStore;
import com.eemi.ext4j.client.eventhandling.button.ClickEvent;
import com.eemi.ext4j.client.eventhandling.button.ClickHandler;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Chart;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.explorer.client.data.DataUtil;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.charts.resources.ChartsModuleResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

public class AreaChartModule extends BaseDemoModule {

    public static final AreaChartModule INSTANCE = new AreaChartModule();

    private static final String TITLE = "Area Chart";
    private JsonStore store;

    private AreaChartModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(TITLE);
        moduleConfig.setModuleDescription("Ext4j Area Chart demo");
        moduleConfig.setWallPaperIcon(ChartsModuleResources.ICONS.getIcon128());
        moduleConfig.setToolbarIcon(ChartsModuleResources.ICONS.getIcon24());
        moduleConfig.setMenuItemIcon(ChartsModuleResources.ICONS.getIcon16());
        moduleConfig.setInitialWindowXPosition(300);
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
