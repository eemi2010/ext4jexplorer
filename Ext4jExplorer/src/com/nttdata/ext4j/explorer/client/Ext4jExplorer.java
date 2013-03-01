package com.nttdata.ext4j.explorer.client;

import com.nttdata.ext4j.client.core.ExtEntryPoint;
import com.nttdata.ext4j.client.state.CookieProvider;
import com.nttdata.ext4j.client.state.StateManager;
import com.nttdata.ext4j.client.tip.QuickTips;
import com.nttdata.ext4j.explorer.client.desktop.modules.Ext4jExplorerModule;
import com.nttdata.ext4j.explorer.client.desktop.modules.SenchaDocsModule;
import com.nttdata.ext4j.explorer.client.desktop.modules.SettingsModule;
import com.nttdata.ext4j.webdesktop.client.views.core.Desktop;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ext4jExplorer extends ExtEntryPoint {
    @Override
    public void onLoad() {
        // DesktopController.get().launchApp();
        /*
         * Window w = new Window("Test Window"); w.setSize(200, 200);
         * w.setXY(300, 300); w.show();
         * 
         * final Anim anim = new Anim(w);
         * 
         * AnimConfig config = new AnimConfig(); config.set("x", 100);
         * config.set("y", 400); config.set("width", 400); config.set("height",
         * 400);
         * 
         * anim.setTo(config); anim.setDuration(2000);
         * 
         * Button button = new Button("Click me"); button.setXY(50, 50);
         * button.addClickHandler(new InteractionHandler() {
         * 
         * @Override public void onEvent(Button button, EventObject event) {
         * anim.run(); } }); Viewport.get().add(button);
         */

        QuickTips.init();
        StateManager.setProvider(new CookieProvider());

        Desktop desktop = Desktop.get();
        desktop.addModule(new Ext4jExplorerModule());
        desktop.addModule(new SenchaDocsModule());
        desktop.addModule(new SettingsModule());

    }

}