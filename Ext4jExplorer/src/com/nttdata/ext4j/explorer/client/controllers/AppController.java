package com.nttdata.ext4j.explorer.client.controllers;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.nttdata.ext4j.explorer.client.bindery.EventBusUtil;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.controllers.demos.ButtonsDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.CustomBarChartController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AbsoluteLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AccordionLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AnchorLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.BorderLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.CardLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.AboutDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.GettingStartedDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.RequirementsDocController;
import com.nttdata.ext4j.explorer.client.ui.app.AppContainer;
import com.nttdata.ext4j.explorer.client.ui.app.WelcomePanel;
import com.nttdata.gwt4ext.client.layout.Layout;
import com.nttdata.gwt4ext.client.tip.QuickTips;
import com.nttdata.gwt4ext.client.ui.Viewport;

public class AppController implements ValueChangeHandler<String> {

    private static final AppController INSTANCE = new AppController();
    private static String currentData = "";

    public static AppController get() {
        return INSTANCE;
    }

    private AppController() {
        History.addValueChangeHandler(this);
    }

    public void launchApp() {
        QuickTips.init();
        Viewport.get(Layout.FIT).add(AppContainer.get());
        loadContent();
        History.fireCurrentHistoryState();
    }

    private static void loadContent() {
        WelcomePanel.get();

        // Doc entries
        AboutDocController.get();
        RequirementsDocController.get();
        GettingStartedDocController.get();

        // Layouts
        AbsoluteLayoutDemoController.get();
        AccordionLayoutDemoController.get();
        AnchorLayoutDemoController.get();
        BorderLayoutDemoController.get();
        CardLayoutDemoController.get();

        // Controllers
        ButtonsDemoController.get();
        CustomBarChartController.get();

    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        if (event.getValue() != null) {
            EventBusUtil.get().fireEvent(new DocEntryLoadEvent(event.getValue(), currentData));
        }
    }

    public static void setData(String value) {
        currentData = value;
    }

    public static String getData() {
        return currentData;
    }

}
