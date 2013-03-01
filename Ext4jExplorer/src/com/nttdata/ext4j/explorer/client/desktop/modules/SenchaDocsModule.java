package com.nttdata.ext4j.explorer.client.desktop.modules;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.user.client.ui.Frame;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.events.handlers.panel.CloseHandler;
import com.nttdata.ext4j.client.events.handlers.window.WindowEventHandler;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.Window;
import com.nttdata.ext4j.webdesktop.client.models.ModuleConfig;
import com.nttdata.ext4j.webdesktop.client.resources.Resources;
import com.nttdata.ext4j.webdesktop.client.views.core.DesktopModule;
import com.nttdata.ext4j.webdesktop.client.views.core.DesktopModuleWindow;

/**
 * Implements a module for user management
 * 
 * @author alainekambi
 * 
 */
public class SenchaDocsModule extends DesktopModule {

    private DesktopModuleWindow window;

    public SenchaDocsModule() {

    }

    @Override
    protected ModuleConfig createModuleConfig() {
        ModuleConfig c = new ModuleConfig();
        c.setModuleTitle(Resources.TEXT.sencha());
        c.setIcon(Resources.ICONS.senchaDocs());
        return c;
    };

    @Override
    protected void createModuleWindow() {
        ensureWindowIsCreated();
        window.show();

    }

    private void ensureWindowIsCreated() {
        if (window == null) {
            window = new DesktopModuleWindow();
            window.setLayout(Layout.FIT);
            window.setSize(1200, 700);
            window.setTitle(Resources.TEXT.sencha());
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

            Frame frame = new Frame("http://docs.sencha.com/ext-js/4-1/#!/api");
            frame.getElement().getStyle().setBorderStyle(BorderStyle.NONE);
            window.add(frame);
        }
    }

}
