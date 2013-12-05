package com.eemi.ext4j.explorer.client.modules.grids;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.core.Ext;
import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.data.BaseModel;
import com.eemi.ext4j.client.data.Store;
import com.eemi.ext4j.client.data.TableItem;
import com.eemi.ext4j.client.eventhandling.button.ClickEvent;
import com.eemi.ext4j.client.eventhandling.button.ClickHandler;
import com.eemi.ext4j.client.events.handlers.table.SelectionChangeHandler;
import com.eemi.ext4j.client.grid.column.DateGridColumn;
import com.eemi.ext4j.client.grid.column.GridColumn;
import com.eemi.ext4j.client.grid.column.GridColumnEditor;
import com.eemi.ext4j.client.grid.column.NumberGridColumn;
import com.eemi.ext4j.client.grid.plugin.RowEditing;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.selection.SelectionModel;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.GridPanel;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.client.ui.form.field.DateField;
import com.eemi.ext4j.client.ui.form.field.NumberField;
import com.eemi.ext4j.client.ui.form.field.VTypes;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.grids.resources.GridsModuleResource;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

public class GridRowEditingModule extends BaseDemoModule {

    private final String TITLE = "Grid Row Editing";
    public static final GridRowEditingModule INSTANCE = new GridRowEditingModule();

    private String[] names = new String[] { "Jones", "Smith", "Lee", "Wilson", "Black", "Williams", "Lewis", "Johnson",
                    "Foot", "Little", "Vee", "Train", "Hot", "Mutt" };

    private String[] surnames = new String[] { "Fred", "Julie", "Bill", "Ted", "Jack", "John", "Mark", "Mike", "Chris",
                    "Bob", "Travis", "Kelly", "Sara" };

    private boolean[] active = new boolean[] { true, false };
    private RowEditing rowEditing = new RowEditing(2);

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(TITLE);
        moduleConfig.setModuleDescription("Ext4j RowEditing Grid demo");
        moduleConfig.setWallPaperIcon(GridsModuleResource.ICONS.gridRowEdit128());
        moduleConfig.setToolbarIcon(GridsModuleResource.ICONS.gridRowEdit24());
        moduleConfig.setMenuItemIcon(GridsModuleResource.ICONS.gridRowEdit16());
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

        final Store store = new Store(generateEmployees());

        final GridPanel grid = new GridPanel(store);
        grid.setTitle("Employee Salaries");
        grid.setCollapsible(true);
        grid.setFrame(true);
        grid.setMultiSelect(true);
        grid.setPlugins(rowEditing);

        GridColumn column = new GridColumn("Name", "name");
        column.setFlex(1);

        GridColumnEditor editor = new GridColumnEditor();
        editor.setAllowBlank(false);
        editor.setVType(VTypes.EMAIL);
        column.setEditor(editor);
        grid.addColumn(column);

        column = new GridColumn("Email", "email");
        column.setWidth(160);

        editor = new GridColumnEditor();
        editor.setAllowBlank(false);
        editor.setVType(VTypes.EMAIL);
        column.setEditor(editor);
        grid.addColumn(column);

        DateGridColumn dateColumn = new DateGridColumn("Start", "start");
        dateColumn.setWidth(90);

        DateField df = new DateField();
        df.setAllowBlank(false);
        df.setFormat("m/d/y");
        df.setMinValue("01/01/1995");
        df.setMinText("Cannot have a start date before the company existed!");
        dateColumn.setEditor(df);
        grid.addColumn(dateColumn);

        NumberGridColumn numberColumn = new NumberGridColumn("Salary", "salary");
        numberColumn.setFormat("$0,0");
        numberColumn.setWidth(90);

        NumberField nf = new NumberField();
        nf.setAllowBlank(false);
        nf.setMinValue(1);
        // nf.setMaxValue(15000);
        numberColumn.setEditor(nf);
        grid.addColumn(numberColumn);

        /**
         * CheckColumn checkColumn = new CheckColumn("Active", "active");
         * checkColumn.setWidth(60); checkColumn.setEditor(new CheckBox());
         * grid.addColumn(checkColumn);
         */

        grid.renderColumns();

        ToolBar tb = new ToolBar(Dock.TOP);

        Button addButton = new Button("Add Employee", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                BaseModel employee = new BaseModel();
                employee.set("name", "New Guy");
                employee.set("email", "new@test.com");
                employee.set("start", "01/01/2013");
                employee.set("active", true);
                employee.set("salary", "50000");
                store.insert(0, employee);
                rowEditing.startEdit();

            }
        });

        addButton.setIcon("imgs/add-user.png");
        tb.add(addButton);

        final Button delButton = new Button("Delete Employee", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                rowEditing.cancelEdit();
                SelectionModel sm = grid.getSelectionModel();
                store.remove(sm.getSelection());
                if (store.getCount() > 0) {
                    sm.select(0);
                }
            }
        });
        delButton.setIcon("imgs/del-user.png");
        delButton.setDisabled(true);
        tb.add(delButton);
        grid.addDocked(tb);
        grid.addSelectionChangeHandler(new SelectionChangeHandler() {
            @Override
            public void onEvent(SelectionModel selectionModel, List<TableItem> records) {
                if (store.getCount() > 0) {
                    delButton.setDisabled(false);
                } else {
                    delButton.setDisabled(true);
                }
            }
        });

        win.add(grid);
        return win;
    }

    private List<BaseModel> generateEmployees() {
        List<BaseModel> values = new ArrayList<BaseModel>();
        int nameLength = this.names.length;
        int surnameLenght = this.surnames.length;
        String name;
        for (int i = 0; i < 50; i++) {
            name = this.names[Ext.randomInt(0, nameLength - 1)] + " "
                            + this.surnames[Ext.randomInt(0, surnameLenght - 1)];
            BaseModel employee = new BaseModel();
            employee.set("name", name);
            employee.set("email", name.toLowerCase().replace(" ", ".") + "@test.com");
            employee.set("start", "01/01/2013");
            employee.set("active", this.active[Ext.randomInt(0, this.active.length - 1)]);
            employee.set("salary", Math.floor(Ext.randomInt(35000, 85000) / 1000) * 1000);
            values.add(employee);
        }

        return values;
    }

}
