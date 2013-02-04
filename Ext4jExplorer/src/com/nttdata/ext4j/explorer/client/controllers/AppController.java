package com.nttdata.ext4j.explorer.client.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.tip.QuickTips;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.Viewport;
import com.nttdata.ext4j.explorer.client.bindery.EventBusUtil;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.CustomBarChartController;
import com.nttdata.ext4j.explorer.client.controllers.demos.combinationexamples.PortalDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.component.ButtonsDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.component.MessageBoxDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AbsoluteLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AccordionLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AnchorLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.BorderLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.CardLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.ColumnLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.AboutDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.GettingStartedDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.RequirementsDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.SenchaDocsDocEntryController;
import com.nttdata.ext4j.explorer.client.ui.app.AppContainer;
import com.nttdata.ext4j.explorer.client.ui.app.WelcomePanel;

public class AppController implements ValueChangeHandler<String> {

    private static final AppController INSTANCE = new AppController();
    private static String currentData = "";
    private static List<String> demoTitles = new ArrayList<String>();
    private static Panel notImplementedPanel;
    private static boolean panelAdded = false;
    private static int added = 0;

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
        NotImplementedController.get();
        WelcomePanel.get();

        // Doc entries
        AboutDocController.get();
        RequirementsDocController.get();
        GettingStartedDocController.get();
        SenchaDocsDocEntryController.get();

        // Layouts
        AbsoluteLayoutDemoController.get();
        AccordionLayoutDemoController.get();
        AnchorLayoutDemoController.get();
        BorderLayoutDemoController.get();
        CardLayoutDemoController.get();
        ColumnLayoutDemoController.get();

        // Components
        ButtonsDemoController.get();
        CustomBarChartController.get();
        MessageBoxDemoController.get();
        PortalDemoController.get();

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

    public static void registerEntry(String title) {
        demoTitles.add(title);
    }

    public static boolean isEntryImplemented(String demoTitle) {
        return demoTitles.contains(demoTitle);
    }

}
