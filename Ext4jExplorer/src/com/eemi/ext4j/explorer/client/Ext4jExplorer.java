package com.eemi.ext4j.explorer.client;

import com.eemi.ext4j.explorer.client.modules.ModulesRegistry;
import com.eemi.ext4j.webdesktop.client.core.DesktopEntryPoint;
import com.eemi.ext4j.webdesktop.client.resources.DesktopResources;
import com.eemi.ext4j.webdesktop.client.ui.Desktop;
import com.emitrom.flash4j.clientio.client.ClientIO;

/**
 * Entry point classes define <code>onDesktopLoad()</code>.
 */
public class Ext4jExplorer extends DesktopEntryPoint {
    @Override
    public void onDesktopLoad() {
        // StateManager.setProvider(new CookieProvider());
        ClientIO.init();
        ModulesRegistry.loadModules();
        Desktop.get().setWallPaper(DesktopResources.DESKTOP_WALLPAPERS.nebula().getSafeUri().asString());
    }

}