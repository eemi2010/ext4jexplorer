package com.nttdata.ext4j.explorer.client.ui.demos.grid;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.ext4j.client.core.config.Dock;
import com.nttdata.ext4j.client.data.BaseModel;
import com.nttdata.ext4j.client.data.Store;
import com.nttdata.ext4j.client.grid.column.CellMetaData;
import com.nttdata.ext4j.client.grid.column.GridColumn;
import com.nttdata.ext4j.client.grid.column.GridColumnRenderer;
import com.nttdata.ext4j.client.ui.DataView;
import com.nttdata.ext4j.client.ui.GridPanel;
import com.nttdata.ext4j.client.ui.PagingToolbar;
import com.nttdata.ext4j.explorer.client.data.DataUtil;
import com.nttdata.ext4j.explorer.client.data.DataUtil.Company;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.ux.data.pagingmemoryproxy.client.PagingStore;

public class PagingGridDemo extends DemoBase {

    public static final String TITLE = "Paging Grid";

    public static PagingGridDemo get() {
        return new PagingGridDemo();
    }

    private PagingGridDemo() {

        List<DataUtil.Company> data = new ArrayList<DataUtil.Company>();
        for (int i = 0; i < 5; i++) {
            data.addAll(DataUtil.getCompanyList());
        }

        PagingStore store = new PagingStore(data);

        GridPanel grid = new GridPanel(store);
        grid.setHeight(350);
        grid.setWidth(600);
        grid.setTitle("Companies");
        grid.setCollapsible(true);
        grid.setMultiSelect(true);
        grid.setXY(100, 100);

        GridColumn column = new GridColumn("Company", DataUtil.Company.COMPANY_NAME);
        column.setFlex(1);
        column.setSortable(false);
        grid.addColumn(column);

        column = new GridColumn("Price", DataUtil.Company.PRICE);
        column.setSortable(true);
        column.setWidth(75);
        column.setRenderer("usMoney");
        grid.addColumn(column);

        column = new GridColumn("Change", DataUtil.Company.CHANGE);
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
        grid.addColumn(column);

        PagingToolbar tb = new PagingToolbar(store);
        tb.setDocked(Dock.BOTTOM);
        tb.setDisplayMsg("Displaying companies {0} - {1} of {2}");
        tb.setEmptyMsg("No company to display");
        grid.setBottomBar(tb);

        grid.renderColumns();
        grid.getView().setEnableTextSelection(true);
        grid.getView().setStripeRows(true);
        demoPanel.add(grid);

        store.load(10);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}