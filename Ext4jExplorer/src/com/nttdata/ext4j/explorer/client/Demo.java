package com.nttdata.ext4j.explorer.client;

import com.nttdata.ext4j.client.core.ExtEntryPoint;
import com.nttdata.ext4j.client.layout.ColumnLayoutData;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Tool;
import com.nttdata.ext4j.client.ui.Viewport;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.ux.portal.client.Portal;
import com.nttdata.ext4j.ux.portal.client.PortalColumn;
import com.nttdata.ext4j.ux.portal.client.Portlet;

public class Demo extends ExtEntryPoint {

    @Override
    public void onLoad() {

        // create a portal
        Portal portal = new Portal();

        // create portal columns
        PortalColumn firstCol = new PortalColumn();
        firstCol.setPaddings(10, 10, 0, 10);

        // add portlets to portal columns
        Portlet portlet = new Portlet();
        portlet.setTitle("Portlet 1");
        portlet.setHtml(Constants.getShortBogusMarkup());
        portlet.setTools(new Tool(Tool.GEAR));
        firstCol.add(portlet);

        portlet = new Portlet("Another Panel 1", Constants.getShortBogusMarkup());
        firstCol.add(portlet);

        // add portal column to portal
        portal.add(firstCol, new ColumnLayoutData(.33));

        // another column
        PortalColumn secondCol = new PortalColumn();
        secondCol.setPaddings(10, 10, 0, 10);
        secondCol.add(new Portlet("Panel 2", Constants.getShortBogusMarkup()));
        secondCol.add(new Portlet("Another Panel 2", Constants.getShortBogusMarkup()));
        portal.add(secondCol, new ColumnLayoutData(.33));

        // third column
        PortalColumn thirdCol = new PortalColumn();
        thirdCol.setPaddings(10, 10, 0, 10);
        thirdCol.add(new Portlet("Panel 3", Constants.getShortBogusMarkup()));
        thirdCol.add(new Portlet("Another Panel 3", Constants.getShortBogusMarkup()));
        portal.add(thirdCol, new ColumnLayoutData(.33));

        Viewport.get(Layout.FIT).add(portal);
    }

}
