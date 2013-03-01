package com.nttdata.ext4j.explorer.client.desktop.modules;

import com.google.gwt.user.client.Timer;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.events.handlers.panel.CloseHandler;
import com.nttdata.ext4j.client.events.handlers.window.WindowEventHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.Window;
import com.nttdata.ext4j.explorer.client.controllers.NotImplementedController;
import com.nttdata.ext4j.explorer.client.ui.app.AppContainer;
import com.nttdata.ext4j.explorer.client.ui.app.WelcomePanel;
import com.nttdata.ext4j.webdesktop.client.models.ModuleConfig;
import com.nttdata.ext4j.webdesktop.client.resources.Resources;
import com.nttdata.ext4j.webdesktop.client.views.core.DesktopModule;
import com.nttdata.ext4j.webdesktop.client.views.core.DesktopModuleWindow;

public class Ext4jExplorerModule extends DesktopModule {

    private DesktopModuleWindow window;

    public Ext4jExplorerModule() {

    }

    @Override
    protected ModuleConfig createModuleConfig() {
        ModuleConfig c = new ModuleConfig();
        c.setModuleTitle(Resources.TEXT.explorer());
        c.setIcon(Resources.ICONS.explorer());
        return c;
    };

    @Override
    protected void createModuleWindow() {
        ensureWindowIsCreated();
        window.show();
        new Timer() {
            @Override
            public void run() {
                NotImplementedController.get();
                WelcomePanel.get();
            }
        }.schedule(2500);
    }

    private void ensureWindowIsCreated() {
        if (window == null) {
            window = new DesktopModuleWindow();
            window.setLayout(Layout.FIT);
            window.setSize(1200, 700);
            window.setTitle(Resources.TEXT.explorer());
            window.setTitleAlign(Position.CENTER);
            window.setMinimizable(true);
            window.setMaximizable(true);
            window.setAnimateTarget(this.shortCut);
            window.addCloseHandler(new CloseHandler() {
                @Override
                public void onEvent(Panel panel) {
                    window = null;
                }
            });
            window.addMinimizeHandler(new WindowEventHandler() {
                @Override
                public void onEvent(Window window) {
                    window.hide();
                }
            });
            window.add(AppContainer.get());

        }
    }
}
