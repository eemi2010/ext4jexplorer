package com.eemi.ext4j.explorer.client.modules.combinations;

import com.eemi.ext4j.client.chart.HighLighter;
import com.eemi.ext4j.client.chart.Legend;
import com.eemi.ext4j.client.chart.axis.CategoryAxis;
import com.eemi.ext4j.client.chart.axis.NumericAxis;
import com.eemi.ext4j.client.chart.laf.GridConfig;
import com.eemi.ext4j.client.chart.marker.Circle;
import com.eemi.ext4j.client.chart.marker.Cross;
import com.eemi.ext4j.client.chart.series.LineSerie;
import com.eemi.ext4j.client.chart.theme.Theme;
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
import com.eemi.ext4j.explorer.client.modules.combinations.resources.CombinationModulesResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.emitrom.flash4j.alivepdf.client.pdf.PDF;
import com.emitrom.flash4j.clientio.canvg.client.CanVgParser;
import com.emitrom.flash4j.clientio.client.ClientIO;
import com.emitrom.flash4j.core.client.display.Bitmap;
import com.emitrom.flash4j.core.client.display.Loader;
import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.utils.ByteArray;
import com.emitrom.flash4j.core.client.utils.Encoder;

public class ChartExportModule extends BaseDemoModule {

    private final String MODULE_TITLE = "Chart Export";
    private JsonStore store;
    private Chart chart;

    public static final ChartExportModule INSTANCE = new ChartExportModule();

    private ChartExportModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Export Ext charts to different formats");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(CombinationModulesResources.ICONS.chartExport128());
        moduleConfig.setToolbarIcon(CombinationModulesResources.ICONS.chartExport24());
        moduleConfig.setMenuItemIcon(CombinationModulesResources.ICONS.chartExport16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        sourceButton.setDisabled(true);

        win.setSize(1200, 600);
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

        Button pdfButton = new Button("Export to PDF");
        pdfButton.setCls("x-btn-default-small");
        pdfButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ByteArray data = CanVgParser.getFromSgvElement(chart.getElement());

                final Loader loader = new Loader();
                loader.getContentLoaderInfo().addCompleteHandler(new EventHandler() {
                    @Override
                    public void onEvent(Event event) {
                        Bitmap b = Bitmap.from(loader.getContent());

                        PDF pdf = new PDF();
                        pdf.addPage();
                        pdf.writeFlashHtmlText("<h1>Exporting Ext JS Charts to PDF with ClientIO</h1>");
                        pdf.addImageStream(Encoder.get().encodePNG(b.getBitmapData()), 0, 40);

                        ClientIO.saveFile(pdf.save(), "chart-ext.pdf");
                    }
                });

                loader.loadBytes(data);

            }
        });
        tb.add(pdfButton);

        Button pngButton = new Button("Export to PNG");
        pngButton.setCls("x-btn-default-small");
        pngButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ByteArray data = CanVgParser.getFromSgvElement(chart.getElement());

                final Loader loader = new Loader();
                loader.getContentLoaderInfo().addCompleteHandler(new EventHandler() {
                    @Override
                    public void onEvent(Event event) {
                        Bitmap b = Bitmap.from(loader.getContent());
                        ClientIO.saveFile(Encoder.get().encodePNG(b.getBitmapData()), "chart-ext.png");
                    }
                });
                loader.loadBytes(data);

            }
        });
        tb.add(pngButton);
        win.addDocked(tb);

        store = DataUtil.getStore(12, 20);
        Chart chart = createChart();
        win.add(chart);

        return win;
    }

    private Chart createChart() {

        chart = new Chart(store);
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
