package com.nttdata.ext4j.explorer.client.ui.demos.grid;

import java.util.List;

import com.nttdata.ext4j.client.core.Template;
import com.nttdata.ext4j.client.data.Store;
import com.nttdata.ext4j.client.data.TableItem;
import com.nttdata.ext4j.client.events.handlers.table.SelectionChangeHandler;
import com.nttdata.ext4j.client.grid.column.GridColumn;
import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.selection.SelectionModel;
import com.nttdata.ext4j.client.ui.GridPanel;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.data.DataUtil;
import com.nttdata.ext4j.explorer.client.data.DataUtil.Company;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class GridDataBindingDemo extends DemoBase {

    public static final String TITLE = "Grid Data Binding";

    public static GridDataBindingDemo get() {
        return new GridDataBindingDemo();
    }

    private Store store;
    private GridPanel grid;
    private Panel detailsPanel;

    private GridDataBindingDemo() {

        store = new Store(DataUtil.getCompanyList());

        String[] content = { "Company : <a href='#'>{" + Company.COMPANY_NAME + "}</a><br/>",
                        "Price : {" + Company.PRICE + "}<br/>", "Last Upated : {" + Company.LAST_UPDATE + "}<br/>" };

        final Template template = new Template(content);

        // Grid component
        grid = new GridPanel(store);
        grid.setHeight(210);
        grid.setSplit(true);
        grid.setForceFit(true);
        grid.setRegion(BorderRegion.NORTH);

        GridColumn column = new GridColumn("Company", DataUtil.Company.COMPANY_NAME);
        column.setFlex(1);
        grid.setColumns(column);
        grid.addSelectionChangeHandler(new SelectionChangeHandler() {
            @Override
            public void onEvent(SelectionModel selectionModel, List<TableItem> records) {
                template.overwrite(detailsPanel.getBody(), records.get(0).getData());
            }
        });

        // Details Panel
        detailsPanel = new Panel();
        detailsPanel.setBodyPadding(7);
        detailsPanel.setBodyStyle("background: #ffffff");
        detailsPanel.setHtml("Please Select a company to see aditional details");
        detailsPanel.setRegion(BorderRegion.CENTER);

        Panel container = new Panel("Companies");
        container.setFrame(true);
        container.setLayout(Layout.BORDER);
        container.setSize(540, 400);
        container.setResizable(true);

        // let's use setItems instead of calling add twice
        container.setItems(grid, detailsPanel);

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
