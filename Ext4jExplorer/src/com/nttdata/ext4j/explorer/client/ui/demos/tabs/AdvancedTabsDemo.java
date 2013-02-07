package com.nttdata.ext4j.explorer.client.ui.demos.tabs;

import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.TabPanel;
import com.nttdata.ext4j.client.ui.ToolBar;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.ux.tabclosemenu.client.TabCloseMenu;

public class AdvancedTabsDemo extends DemoBase {

    public static final String TITLE = "Advanced Tabs";
    private int index = 1;
    private TabPanel tabPanel;

    public static AdvancedTabsDemo get() {
        return new AdvancedTabsDemo();
    }

    private AdvancedTabsDemo() {

        Panel panel = new Panel("Tab with contextmenu plugin");
        panel.setBodyPadding(30);

        ToolBar tb = new ToolBar();
        tb.add(new Button("Add Closable Tab", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                addTab(true);
            }
        }));
        tb.add(new Button("Add Unclosable Tab", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                addTab(false);
            }
        }));
        panel.addDocked(tb);

        tabPanel = new TabPanel();
        tabPanel.setHeight(300);
        tabPanel.setPlugins(new TabCloseMenu());

        panel.add(tabPanel);

        addTab(true);
        addTab(false);

        demoPanel.setBodyPadding(20);
        demoPanel.setLayout(Layout.FIT);
        demoPanel.add(panel);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

    private void addTab(boolean closable) {
        Panel tabItem = new Panel("Tab " + index++);
        tabItem.setHtml(Constants.getShortBogusMarkup());
        tabItem.setClosable(closable);
        tabItem.setIconCls("tabs");
        tabPanel.add(tabItem);
    }

}
