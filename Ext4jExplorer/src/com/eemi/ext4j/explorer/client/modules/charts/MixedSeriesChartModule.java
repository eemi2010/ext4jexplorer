package com.eemi.ext4j.explorer.client.modules.charts;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.chart.axis.AbstractAxis;
import com.eemi.ext4j.client.chart.axis.CategoryAxis;
import com.eemi.ext4j.client.chart.axis.NumericAxis;
import com.eemi.ext4j.client.chart.marker.Cross;
import com.eemi.ext4j.client.chart.series.AbstractSerie;
import com.eemi.ext4j.client.chart.series.ColumnSerie;
import com.eemi.ext4j.client.chart.series.LineSerie;
import com.eemi.ext4j.client.chart.series.ScatterSerie;
import com.eemi.ext4j.client.chart.theme.Theme;
import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Chart;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.charts.resources.ChartsModuleResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

public class MixedSeriesChartModule extends BaseDemoModule {

    public static final MixedSeriesChartModule INSTANCE = new MixedSeriesChartModule();

    private static final String TITLE = "Mixed Charts";
    private Store store;

    private MixedSeriesChartModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(TITLE);
        moduleConfig.setModuleDescription("Ext4j Mixed Charts demo");
        moduleConfig.setWallPaperIcon(ChartsModuleResources.ICONS.custom128());
        moduleConfig.setToolbarIcon(ChartsModuleResources.ICONS.custom24());
        moduleConfig.setMenuItemIcon(ChartsModuleResources.ICONS.custom16());
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
                store.loadData(ChartData.generateData(12));
            }
        });
        tb.add(reloadButton);
        win.addDocked(tb);

        Chart chart = createChart();
        win.add(chart);

        return win;
    }

    private Chart createChart() {

        final List<AbstractAxis> axis = new ArrayList<AbstractAxis>();

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setTitle("Number of Hits");
        numericAxis.setFields("data1", "data2", "data3");
        numericAxis.setGrid(true);
        axis.add(numericAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setFields("name");
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setTitle("Month of the year");
        axis.add(categoryAxis);

        final List<AbstractSerie> series = new ArrayList<AbstractSerie>();

        ColumnSerie columnSerie = new ColumnSerie();
        columnSerie.setAxis(Position.LEFT);
        columnSerie.setXField("name");
        columnSerie.setYField("data1");
        columnSerie.setMarker(new Cross(5, 1));
        series.add(columnSerie);

        ScatterSerie scatterSerie = new ScatterSerie();
        scatterSerie.setAxis(Position.LEFT);
        scatterSerie.setXField("name");
        scatterSerie.setYField("data2");
        scatterSerie.setMarker(new Cross(5, 1));
        series.add(scatterSerie);

        LineSerie lineSerie = new LineSerie();
        lineSerie.setAxis(Position.LEFT);
        lineSerie.setSmooth(true);
        lineSerie.setFill(true);
        lineSerie.setFillOpacitiy(0.5);
        lineSerie.setXField("name");
        lineSerie.setYField("data3");
        series.add(lineSerie);

        store = new Store(ChartData.generateData(12));

        final Chart chart = Chart.newInstance(store, axis, series);
        chart.setShadow(true);
        chart.setAnimate(true);
        chart.setTheme(Theme.CATEGORY1);

        return chart;
    }
}
