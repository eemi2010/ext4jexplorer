package com.nttdata.ext4j.explorer.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Chart;
import com.nttdata.ext4j.explorer.client.data.ChartDataUtil;
import com.nttdata.ext4j.explorer.client.ui.demos.charts.ChartCreator;

public class MyChartPanel implements IsWidget {

    private static MyChartPanelUiBinder uiBinder = GWT.create(MyChartPanelUiBinder.class);
    private Widget widget;

    @UiField(provided = true)
    Chart chart;

    @UiField
    Button button;

    interface MyChartPanelUiBinder extends UiBinder<Widget, MyChartPanel> {
    }

    public MyChartPanel() {
        chart = ChartCreator.createCustomBarChart();
        widget = uiBinder.createAndBindUi(this);
        button.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                ChartCreator.getStore().loadData(ChartDataUtil.generateData(12, 20));
            }
        });
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

}
