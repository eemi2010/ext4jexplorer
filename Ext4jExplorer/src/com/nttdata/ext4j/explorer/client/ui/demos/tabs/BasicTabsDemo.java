package com.nttdata.ext4j.explorer.client.ui.demos.tabs;

import com.google.gwt.user.client.Window;
import com.nttdata.ext4j.client.core.Component;
import com.nttdata.ext4j.client.events.handlers.component.EventHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.TabPanel;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class BasicTabsDemo extends DemoBase {

    public static final String TITLE = "Basic Tabs";

    public static BasicTabsDemo get() {
        return new BasicTabsDemo();
    }

    private Panel tabItem;

    private BasicTabsDemo() {

        TabPanel tabPanel = new TabPanel();
        tabPanel.setPlain(true);
        tabPanel.setBodyPadding(10);

        tabItem = new Panel("Normal Tab");
        tabItem.setHtml(Constants.getShortBogusMarkup());
        tabPanel.add(tabItem);

        tabItem = new Panel("Closable Tab");
        tabItem.setClosable(true);
        tabItem.setHtml("I m a closable Tab");
        tabPanel.add(tabItem);

        final Panel eventItem = new Panel("Event Tab");
        eventItem.setHtml("I m an event Tab");
        eventItem.addActivateHandler(new EventHandler() {
            @Override
            public void onEvent(Component component) {
                Window.alert(eventItem.getTitle() + " was clicked");
            }
        });
        tabPanel.add(eventItem);

        tabItem = new Panel("Disabled Tab");
        tabItem.setDisabled(true);
        tabItem.setHtml(Constants.getShortBogusMarkup());
        tabPanel.add(tabItem);

        demoPanel.setBodyPadding(40);
        demoPanel.setLayout(Layout.FIT);
        demoPanel.add(tabPanel);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
