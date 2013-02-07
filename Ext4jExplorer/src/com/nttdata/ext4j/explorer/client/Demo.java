package com.nttdata.ext4j.explorer.client;

import com.google.gwt.user.client.Timer;
import com.nttdata.ext4j.client.core.ExtEntryPoint;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.TabPanel;
import com.nttdata.ext4j.client.ui.Viewport;
import com.nttdata.ext4j.ux.tabclosemenu.client.TabCloseMenu;
import com.nttdata.ext4j.ux.tabscrollermenu.client.TabScrollerMenu;

public class Demo extends ExtEntryPoint {

    private int index = 1;
    Panel firstPanel;
    private TabPanel tabPanel;

    @Override
    public void onLoad() {

        Panel panel = new Panel("Exercising scrollable tabs with a TabScroller menu");
        panel.setBodyPadding(30);

        firstPanel = new Panel("First Tab");
        firstPanel.setHtml("First Child");

        tabPanel = new TabPanel();
        tabPanel.add(firstPanel);
        tabPanel.setHeight(300);

        TabScrollerMenu tabScrollerMenu = new TabScrollerMenu();
        tabScrollerMenu.setMaxText(15);
        tabScrollerMenu.setPageSize(5);
        tabPanel.setPlugins(tabScrollerMenu, new TabCloseMenu());

        panel.add(tabPanel);

        Viewport.get(Layout.FIT).add(panel);

        new Timer() {
            Panel p;

            @Override
            public void run() {
                for (int i = index; i < 20; i++) {
                    p = new Panel();
                    p.setTitle("Tab # " + i);
                    p.setHtml("Hi, I am tab " + i);
                    p.setClosable(true);
                    tabPanel.add(p);
                }
                // firstPanel.getBody().update("Done !");
            }
        }.schedule(1000);

    }

}
