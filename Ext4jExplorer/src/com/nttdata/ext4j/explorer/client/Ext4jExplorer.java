package com.nttdata.ext4j.explorer.client;

import com.nttdata.ext4j.client.core.ExtEntryPoint;
import com.nttdata.ext4j.client.layout.ColumnLayoutData;
import com.nttdata.ext4j.client.layout.FitLayout;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.Portal;
import com.nttdata.ext4j.client.ui.PortalColumn;
import com.nttdata.ext4j.client.ui.Portlet;
import com.nttdata.ext4j.client.ui.Viewport;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ext4jExplorer extends ExtEntryPoint {
    @Override
    public void onLoad() {
        // AppController.get().launchApp();

        Panel panel = new Panel();
        panel.setBorder(false);
        panel.setPaddings(15);
        panel.setLayout(new FitLayout());

        // create a portal
        Portal portal = new Portal();

        // create portal columns
        PortalColumn firstCol = new PortalColumn();
        firstCol.setPaddings(10, 10, 0, 10);

        // add portlets to portal columns
        Portlet gridPortlet = new Portlet();
        gridPortlet.setTitle("Grid in a Portlet");
        gridPortlet.setLayout(new FitLayout());

        firstCol.add(gridPortlet);

        Portlet portlet = new Portlet("Another Panel 1", getShortBogusMarkup());
        firstCol.add(portlet);

        // add portal column to portal
        portal.add(firstCol, new ColumnLayoutData(.33));

        // another column
        PortalColumn secondCol = new PortalColumn();
        secondCol.setPaddings(10, 10, 0, 10);
        secondCol.add(new Portlet("Panel 2", getShortBogusMarkup()));
        secondCol.add(new Portlet("Another Panel 2", getShortBogusMarkup()));
        portal.add(secondCol, new ColumnLayoutData(.33));

        // third column
        PortalColumn thirdCol = new PortalColumn();
        thirdCol.setPaddings(10, 10, 0, 10);
        thirdCol.add(new Portlet("Panel 3", getShortBogusMarkup()));
        thirdCol.add(new Portlet("Another Panel 3", getShortBogusMarkup()));
        portal.add(thirdCol, new ColumnLayoutData(.33));

        Viewport.get(Layout.FIT).add(portal);

    }

    private static String getShortBogusMarkup() {
        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui.  In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.";
    }
}