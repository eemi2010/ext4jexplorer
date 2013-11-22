package com.eemi.ext4j.explorer.client.modules.about;

import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Panel;
import com.eemi.ext4j.explorer.client.modules.about.resources.AboutExt4jModuleResources;
import com.eemi.ext4j.explorer.client.rpc.RequestUtil;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModule;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;

/**
 * The overall idea about the ext4j is implemented in this module
 */
public class AboutExt4jModule extends DesktopModule {

    private final String MODULE_TITLE = "Why Ext4j ? ";
    private final String DESCRIPTION = "Learn why Ext4j was created";

    private Panel contentPanel;

    public static final AboutExt4jModule INSTANCE = new AboutExt4jModule();

    private AboutExt4jModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription(DESCRIPTION);
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(AboutExt4jModuleResources.ICONS.getIcon128());
        moduleConfig.setToolbarIcon(AboutExt4jModuleResources.ICONS.getIcon24());
        moduleConfig.setMenuItemIcon(AboutExt4jModuleResources.ICONS.getIcon16());
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
        RequestUtil.load("ext4j_doc_about.html", contentPanel);
        return win;
    }
}
