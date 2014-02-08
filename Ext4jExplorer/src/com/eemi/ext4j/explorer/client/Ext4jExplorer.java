package com.eemi.ext4j.explorer.client;

import com.eemi.ext4j.explorer.client.modules.ModulesRegistry;
import com.eemi.ext4j.webdesktop.client.core.DesktopEntryPoint;
import com.eemi.ext4j.webdesktop.client.resources.DesktopResources;
import com.eemi.ext4j.webdesktop.client.ui.Desktop;
import com.emitrom.flash4j.clientio.client.ClientIO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

/**
 * Entry point classes define <code>onDesktopLoad()</code>.
 */
public class Ext4jExplorer extends DesktopEntryPoint implements ValueChangeHandler<String> {

    public static String START_MODULE;

    @Override
    public void onDesktopLoad() {

        GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void onUncaughtException(Throwable e) {
                print(e.getMessage());
            }
        });

        History.addValueChangeHandler(this);
        History.fireCurrentHistoryState();
        // StateManager.setProvider(new CookieProvider());
        ClientIO.init();
        Desktop.get().setWallPaper(DesktopResources.DESKTOP_WALLPAPERS.nebula().getSafeUri().asString());
        ModulesRegistry.loadModules();

    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        START_MODULE = event.getValue();
    }

    private native void print(String msg)/*-{
		$wnd.console.log(msg);
    }-*/;

}