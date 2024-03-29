package com.eemi.ext4j.explorer.client.modules.combinations;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.grid.column.CellMetaData;
import com.eemi.ext4j.client.grid.column.GridColumn;
import com.eemi.ext4j.client.grid.column.GridColumnRenderer;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.DataView;
import com.eemi.ext4j.client.ui.GridPanel;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.combinations.resources.CombinationModulesResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.emitrom.flash4j.alivepdf.client.colors.RGBColor;
import com.emitrom.flash4j.alivepdf.client.data.DataCollection;
import com.emitrom.flash4j.alivepdf.client.fonts.CoreFont;
import com.emitrom.flash4j.alivepdf.client.grid.Grid;
import com.emitrom.flash4j.alivepdf.client.layout.Align;
import com.emitrom.flash4j.alivepdf.client.pdf.PDF;
import com.emitrom.flash4j.clientio.client.ClientIO;
import com.emitrom.flash4j.excel.client.ExcelFile;
import com.emitrom.flash4j.excel.client.Sheet;

public class GridExportModule extends BaseDemoModule {

    private final String MODULE_TITLE = "Grid Export";

    public static final GridExportModule INSTANCE = new GridExportModule();
    List<Company> companyList;

    private GridPanel grid;

    private GridExportModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Export a Grid to different formats");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(CombinationModulesResources.ICONS.gridExport128());
        moduleConfig.setToolbarIcon(CombinationModulesResources.ICONS.gridExport24());
        moduleConfig.setMenuItemIcon(CombinationModulesResources.ICONS.gridExport16());
        return moduleConfig;
    }

    private static class Company extends BaseModel {
        private static final String COMPANY_NAME = "company";
        private static final String PRICE = "price";
        private static final String CHANGE = "change";
        private static final String CHANGE_IN_PERCENT = "pctChange";
        private static final String LAST_UPDATE = "lastChange";

        public Company(String name, double price, double change, double percentChange, String lastChange) {
            this.set(COMPANY_NAME, name);
            this.set(PRICE, price);
            this.set(CHANGE, change);
            this.set(CHANGE_IN_PERCENT, percentChange);
            this.set(LAST_UPDATE, lastChange);
        }

        public static List<Company> getList() {
            List<Company> list = new ArrayList<GridExportModule.Company>();
            list.add(new Company("3m Co", 71.72, 0.02, 0.03, "9/1/2013"));
            list.add(new Company("Alcoa Inc", 29.01, 0.42, 1.47, "9/1/2013"));
            list.add(new Company("Altria Group Inc", 83.81, 0.28, 0.34, "9/1/2013"));
            list.add(new Company("American Express Company", 52.55, 0.01, 0.02, "9/1/2013"));
            list.add(new Company("American International Group, Inc.", 64.13, 0.31, 0.49, "9/1/2013"));
            list.add(new Company("AT&T Inc.", 31.61, -0.48, -1.54, "9/1/2013"));
            list.add(new Company("Boeing Co.", 75.43, 0.53, 0.71, "9/1/2013"));
            list.add(new Company("Caterpillar Inc.", 67.27, 0.92, 1.39, "9/1/2013"));
            list.add(new Company("Citigroup, Inc.", 49.37, 0.02, 0.04, "9/1/2013"));
            list.add(new Company("E.I. du Pont de Nemours and Company", 40.48, 0.51, 1.28, "9/1/2013"));
            list.add(new Company("Exxon Mobil Corp", 68.1, -0.43, -0.64, "9/1/2013"));
            list.add(new Company("General Electric Company", 34.14, -0.08, -0.23, "9/1/2013"));
            list.add(new Company("General Motors Corporation", 30.27, 1.09, 3.74, "9/1/2013"));
            list.add(new Company("Hewlett-Packard Co.", 36.53, -0.03, -0.08, "9/1/2013"));
            list.add(new Company("Honeywell Intl Inc", 38.77, 0.05, 0.13, "9/1/2013"));
            list.add(new Company("Intel Corporation", 19.88, 0.31, 1.58, "9/1/2013"));
            list.add(new Company("International Business Machines", 81.41, 0.44, 0.54, "9/1/2013"));
            list.add(new Company("Johnson & Johnson", 64.72, 0.06, 0.09, "9/1/2013"));
            list.add(new Company("JP Morgan & Chase & Co", 45.73, 0.07, 0.15, "9/1/2013"));
            list.add(new Company("McDonald\"s Corporation", 36.76, 0.86, 2.40, "9/1/2013"));
            list.add(new Company("Merck & Co., Inc.", 40.96, 0.41, 1.01, "9/1/2013"));
            list.add(new Company("Microsoft Corporation", 25.84, 0.14, 0.54, "9/1/2013"));
            list.add(new Company("Pfizer Inc", 27.96, 0.4, 1.45, "9/1/2013"));
            list.add(new Company("The Coca-Cola Company", 45.07, 0.26, 0.58, "9/1/2013"));
            list.add(new Company("The Home Depot, Inc.", 34.64, 0.35, 1.02, "9/1/2013"));
            list.add(new Company("The Procter & Gamble Company", 61.91, 0.01, 0.02, "9/1/2013"));
            list.add(new Company("United Technologies Corporation", 63.26, 0.55, 0.88, "9/1/2013"));
            list.add(new Company("Verizon Communications", 35.57, 0.39, 1.11, "9/1/2013"));
            list.add(new Company("Wal-Mart Stores, Inc.", 45.45, 0.73, 1.63, "9/1/2013"));

            return list;

        }

    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();

        companyList = Company.getList();

        win.setSize(1200, 600);
        win.setLayout(Layout.FIT);
        win.setBodyPadding(20);

        ToolBar tb = new ToolBar();
        tb.setDocked(Dock.TOP);
        Button pdfButton = new Button("Export to PDF");
        pdfButton.setCls("x-btn-default-small");
        pdfButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.getEl().mask("Generating file ...");
                createPDF();
            }
        });
        tb.add(pdfButton);

        Button xlsButton = new Button("Export to Excel");
        xlsButton.setCls("x-btn-default-small");
        xlsButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.getEl().mask("Generating file ...");
                createXls();
            }
        });

        tb.add(xlsButton);
        win.addDocked(tb);

        Store store = new Store(companyList);

        grid = new GridPanel(store);
        grid.setTitle("Companies");
        grid.setMultiSelect(true);

        GridColumn column = new GridColumn("Company", Company.COMPANY_NAME);
        column.setFlex(1);
        column.setSortable(false);
        grid.addColumn(column);

        column = new GridColumn("Price", Company.PRICE);
        column.setSortable(true);
        column.setWidth(75);
        column.setRenderer("usMoney");
        grid.addColumn(column);

        column = new GridColumn("Change", Company.CHANGE);
        column.setSortable(true);
        column.setWidth(75);
        column.setRenderer(new GridColumnRenderer() {

            @Override
            public String onRender(String value, CellMetaData metadata, BaseModel record, int rowIndex, int colIndex,
                            Store store, DataView view) {
                if (Double.valueOf(value) > 0) {
                    return "<span style='color:green;'>" + value + "</span>";
                } else if (Double.valueOf(value) < 0) {
                    return "<span style='red;'>" + value + "</span>";
                }
                return value;
            }
        });
        grid.addColumn(column);

        column = new GridColumn("% Change", Company.CHANGE_IN_PERCENT);
        column.setSortable(true);
        column.setWidth(75);
        column.setRenderer(new GridColumnRenderer() {
            @Override
            public String onRender(String value, CellMetaData metadata, BaseModel record, int rowIndex, int colIndex,
                            Store store, DataView view) {
                if (Double.valueOf(value) > 0) {
                    return "<span style='color:green;'>" + value + "%</span>";
                } else if (Double.valueOf(value) < 0) {
                    return "<span style='red;'>" + value + "%</span>";
                }
                return value;
            }
        });
        grid.addColumn(column);

        column = new GridColumn("Last Updated", Company.LAST_UPDATE);
        column.setSortable(true);
        column.setWidth(75);
        // column.setRenderer(Format.getDateRenderer("m/d/Y"));
        grid.addColumn(column);

        grid.renderColumns();
        grid.getView().setEnableTextSelection(true);
        grid.getView().setStripeRows(true);

        win.add(grid);
        return win;
    }

    private void createPDF() {
        DataCollection data = new DataCollection();
        for (Company company : companyList) {
            data.addItem(company.getJsObj());
        }

        com.emitrom.flash4j.alivepdf.client.grid.GridColumn company = new com.emitrom.flash4j.alivepdf.client.grid.GridColumn(
                        "Company", "company", 50, Align.CENTER);
        com.emitrom.flash4j.alivepdf.client.grid.GridColumn price = new com.emitrom.flash4j.alivepdf.client.grid.GridColumn(
                        "Price", "price", 50, Align.CENTER);
        com.emitrom.flash4j.alivepdf.client.grid.GridColumn change = new com.emitrom.flash4j.alivepdf.client.grid.GridColumn(
                        "Change", "change", 50, Align.CENTER);

        com.emitrom.flash4j.alivepdf.client.grid.GridColumn changeInPercent = new com.emitrom.flash4j.alivepdf.client.grid.GridColumn(
                        "Change in %", "pctChange", 50, Align.CENTER);

        com.emitrom.flash4j.alivepdf.client.grid.GridColumn lastChange = new com.emitrom.flash4j.alivepdf.client.grid.GridColumn(
                        "Last Change", "lastChange", 50, Align.CENTER);

        Grid pdfGrid = new Grid(data, 250, 300, new RGBColor(0xE6E6FA), new RGBColor(0xF5FFFA), true, new RGBColor(
                        0x00FA9A), new RGBColor(0x1E90FF), 1, 10);

        pdfGrid.setColums(company, price, change, changeInPercent, lastChange);

        PDF pdf = new PDF();
        pdf.addPage();
        pdf.setTextStyle(new RGBColor(0x000000));
        pdf.setFont(new CoreFont(), 10);
        pdf.addGrid(pdfGrid);

        ClientIO.saveFile(pdf.save(), "Company.pdf");

        grid.getEl().unmask();

    }

    private void createXls() {

        Sheet excelSheet = new Sheet();
        excelSheet.resize(10, 10);
        excelSheet.setCell(0, 0, "Company");
        excelSheet.setCell(0, 1, "Price");
        excelSheet.setCell(0, 2, "Change");
        excelSheet.setCell(0, 3, "Change in %");
        excelSheet.setCell(0, 4, "Last Change");

        for (int i = 0; i < companyList.size(); i++) {
            writeContentToSheet(i, excelSheet, companyList.get(i));
        }

        ExcelFile excelFile = new ExcelFile();
        excelFile.addSheet(excelSheet);

        ClientIO.saveFile(excelFile.saveToByteArray(), "Company.xls");
        grid.getEl().unmask();

    }

    private void writeContentToSheet(int row, Sheet sheet, Company company) {
        sheet.setCell(row + 1, 0, company.get(Company.COMPANY_NAME));
        sheet.setCell(row + 1, 1, company.getAsDouble(Company.PRICE) + "");
        sheet.setCell(row + 1, 2, company.getAsDouble(Company.CHANGE) + "");
        sheet.setCell(row + 1, 3, company.getAsDouble(Company.CHANGE_IN_PERCENT) + "");
        sheet.setCell(row + 1, 4, company.get(Company.LAST_UPDATE));
    }

}
