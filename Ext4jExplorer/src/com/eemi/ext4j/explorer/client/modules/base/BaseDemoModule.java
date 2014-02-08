package com.eemi.ext4j.explorer.client.modules.base;

import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.events.component.ActivateEvent;
import com.eemi.ext4j.client.events.component.ActivateHandler;
import com.eemi.ext4j.client.events.panel.CloseEvent;
import com.eemi.ext4j.client.events.panel.CloseHandler;
import com.eemi.ext4j.client.events.window.MinimizeEvent;
import com.eemi.ext4j.client.events.window.MinimizeHandler;
import com.eemi.ext4j.client.laf.ButtonScale;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Panel;
import com.eemi.ext4j.explorer.client.modules.button.resources.ButtonModuleResources;
import com.eemi.ext4j.explorer.client.rpc.RequestUtil;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModule;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.google.gwt.user.client.Timer;

/**
 * Base class for all modules that implement a demo in the web desktop
 */
public abstract class BaseDemoModule extends DesktopModule {

    private Panel contentPanel;
    private DesktopModuleWindow sourceWindow;
    protected Button sourceButton;

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setDeletable(false);
        moduleConfig.setMutltiple(false);
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setSize(1000, 600);
        win.addCloseHandler(new com.eemi.ext4j.client.events.panel.CloseHandler() {
            @Override
            public void onClose(CloseEvent event) {
                if (sourceWindow != null) {
                    sourceWindow.close();
                    sourceWindow = null;
                }

            }
        });
        win.addMinimizeHandler(new MinimizeHandler() {
            @Override
            public void onMinimize(MinimizeEvent event) {
                if (sourceWindow != null) {
                    sourceWindow.hide();
                }
            }
        });

        win.addActivateHandler(new ActivateHandler() {
            @Override
            public void onActivate(ActivateEvent event) {
                if (sourceWindow != null && !sourceWindow.isVisible()) {
                    sourceWindow.show();
                }
            }
        });

        sourceButton = new Button("Source");
        sourceButton.setScale(ButtonScale.LARGE);
        sourceButton.setIcon(ButtonModuleResources.ICONS.source());
        sourceButton.setWidth(100);
        sourceButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                loadDemoSource();
            }
        });
        win.addButtons(sourceButton);

        return win;
    }

    private void loadDemoSource() {
        if (sourceWindow == null) {
            sourceWindow = this.createChildWindow();
            sourceWindow.setTitle("<span class='ux-desktop-text'>Source for " + config.getModuleTitle() + "</span>");
            sourceWindow.setLayout(Layout.FIT);

            contentPanel = new Panel();
            contentPanel.setAutoScroll(true);
            sourceWindow.add(contentPanel);
            sourceWindow.addCloseHandler(new CloseHandler() {
                @Override
                public void onClose(CloseEvent event) {
                    sourceWindow = null;
                }
            });

            sourceWindow.show();
            new Timer() {
                @Override
                public void run() {
                    RequestUtil.loadContent(config.getModuleTitle() + ".html", contentPanel);
                }
            }.schedule(1000);
        } else {
            sourceWindow.show();
        }

    }
}
