package com.eemi.ext4j.explorer.client.modules.combinations;

import com.eemi.ext4j.client.layout.ColumnLayoutData;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Panel;
import com.eemi.ext4j.client.ui.Tool;
import com.eemi.ext4j.explorer.client.core.Constants;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.combinations.resources.CombinationModulesResources;
import com.eemi.ext4j.ux.portal.client.Portal;
import com.eemi.ext4j.ux.portal.client.PortalColumn;
import com.eemi.ext4j.ux.portal.client.Portlet;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

public class PortalModule extends BaseDemoModule {

    private final String MODULE_TITLE = "Portal";

    public static final PortalModule INSTANCE = new PortalModule();

    private PortalModule() {
        Portal.injectPlugin();
    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Portal Demo with Ext4j");
        moduleConfig.setMutltiple(false);
        moduleConfig.setInitialWindowXPosition(100);
        moduleConfig.setInitialWindowYPosition(100);
        moduleConfig.setWallPaperIcon(CombinationModulesResources.ICONS.dashboard128());
        moduleConfig.setToolbarIcon(CombinationModulesResources.ICONS.dashboard24());
        moduleConfig.setMenuItemIcon(CombinationModulesResources.ICONS.dashboard16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {

        DesktopModuleWindow win = super.createModuleWindow();
        win.setLayout(Layout.FIT);
        win.setSize(1000, 600);

        // create a portal
        Portal portal = new Portal();

        // create portal columns
        PortalColumn firstCol = new PortalColumn();
        firstCol.setPaddings(10, 10, 0, 10);

        // add portlets to portal columns
        Portlet portlet = new Portlet();
        portlet.setTitle("Pie Chart");
        portlet.setLayout(Layout.FIT);

        Panel container = new Panel(Layout.FIT);
        // container.add(ChartCreator.createBarChart());

        portlet.add(container);
        portlet.setHeight(300);
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

        win.add(portal);

        return win;
    }

}
