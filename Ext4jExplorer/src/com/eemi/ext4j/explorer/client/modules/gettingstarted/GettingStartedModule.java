package com.eemi.ext4j.explorer.client.modules.gettingstarted;

import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Panel;
import com.eemi.ext4j.explorer.client.modules.gettingstarted.resources.GettingStartedResources;
import com.eemi.ext4j.explorer.client.rpc.RequestUtil;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModule;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

public class GettingStartedModule extends DesktopModule {

    private final String MODULE_TITLE = "Getting Started with Ext4j";
    private Panel contentPanel;

    public static final GettingStartedModule INSTANCE = new GettingStartedModule();

    private GettingStartedModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Ext4j up and running");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(GettingStartedResources.ICONS.getIcon128());
        moduleConfig.setToolbarIcon(GettingStartedResources.ICONS.getIcon24());
        moduleConfig.setMenuItemIcon(GettingStartedResources.ICONS.getIcon16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setSize(1200, 600);
        win.setLayout(Layout.FIT);

        contentPanel = new Panel();
        contentPanel.setAutoScroll(true);
        win.add(contentPanel);
        RequestUtil.load("ext4j_doc_getting_started.html", contentPanel);
        return win;
    }
}
