package com.eemi.ext4j.explorer.client.modules.grids;

import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.eventhandling.button.ClickEvent;
import com.eemi.ext4j.client.eventhandling.button.ClickHandler;
import com.eemi.ext4j.client.grid.column.GridColumn;
import com.eemi.ext4j.client.grid.column.GridColumnEditor;
import com.eemi.ext4j.client.grid.plugin.CellEditing;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.GridPanel;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.client.ui.form.field.DateField;
import com.eemi.ext4j.client.ui.form.field.NumberField;
import com.eemi.ext4j.explorer.client.data.DataUtil;
import com.eemi.ext4j.explorer.client.data.DataUtil.Company;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.grids.resources.GridsModuleResource;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

public class GridCellEditingModule extends BaseDemoModule {

    private final String TITLE = "Grid Cell Editing";
    private CellEditing cellEditing = new CellEditing(1);
    public static final GridCellEditingModule INSTANCE = new GridCellEditingModule();

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(TITLE);
        moduleConfig.setModuleDescription("Ext4j Grid Cell Editing demo");
        moduleConfig.setWallPaperIcon(GridsModuleResource.ICONS.grid128());
        moduleConfig.setToolbarIcon(GridsModuleResource.ICONS.grid24());
        moduleConfig.setMenuItemIcon(GridsModuleResource.ICONS.grid16());
        moduleConfig.setInitialWindowXPosition(500);
        moduleConfig.setInitialWindowYPosition(300);
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setSize(1200, 600);
        win.setLayout(Layout.FIT);
        win.setBodyPadding(20);

        final Store store = new Store(DataUtil.getCompanyList());

        final GridPanel grid = new GridPanel(store);
        grid.setTitle("Edit companies ?");
        grid.setFrame(true);
        grid.setResizable(true);
        grid.setMultiSelect(true);
        grid.setPlugins(cellEditing);

        GridColumn column = new GridColumn("Company", DataUtil.Company.COMPANY_NAME);
        column.setFlex(1);
        column.setFilterable(true);

        GridColumnEditor editor = new GridColumnEditor();
        editor.setAllowBlank(false);
        column.setEditor(editor);
        grid.addColumn(column);

        column = new GridColumn("Price", DataUtil.Company.PRICE);
        column.setSortable(true);
        column.setWidth(75);

        NumberField priceEditor = new NumberField();
        priceEditor.setAllowBlank(false);
        priceEditor.setMinValue(0);
        priceEditor.setMaxValue(100000);
        column.setEditor(priceEditor);

        column.setRenderer("usMoney");
        grid.addColumn(column);

        column = new GridColumn("Change", DataUtil.Company.CHANGE);
        column.setSortable(true);
        column.setWidth(75);
        grid.addColumn(column);

        column = new GridColumn("% Change", Company.CHANGE_IN_PERCENT);
        column.setSortable(true);
        column.setWidth(75);
        grid.addColumn(column);

        column = new GridColumn("Last Updated", Company.LAST_UPDATE);
        column.setSortable(true);
        column.setWidth(75);

        DateField updateEditor = new DateField();
        updateEditor.setFormat("m/d/y");
        updateEditor.setMinValue("01/01/06");
        updateEditor.setDisabledDays(0, 6);
        updateEditor.setDisabledDaysText("Updates cant be changed on the weekends");
        column.setEditor(updateEditor);

        grid.addColumn(column);

        grid.renderColumns();

        ToolBar tb = new ToolBar(Dock.TOP);
        tb.add(new Button("Add Company", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Company c = new Company("New company", 83.81, 0.28, 0.34, "9/1/2013");
                store.insert(0, c);
                cellEditing.startEditByPosition(0, 0);
                event.getSource().setDisabled(true);

            }
        }));

        grid.addDocked(tb);

        win.add(grid);
        return win;
    }

}
