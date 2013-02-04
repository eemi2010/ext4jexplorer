package com.nttdata.ext4j.explorer.client.controllers;

import com.nttdata.ext4j.client.events.handlers.panel.CloseHandler;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.bindery.EventBusUtil;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEventHandler;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.ui.app.Ext4jPanel;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public abstract class AbstractDemoController implements DocEntryLoadEventHandler {

    private boolean isAdded;
    protected DemoBase demo;

    public AbstractDemoController() {
        EventBusUtil.get().addHandler(DocEntryLoadEvent.TYPE, this);
        demo = getDemoBase();
        AppController.registerEntry(demo.getDemoTitle());
    }

    @Override
    public void onEvent(DocEntryLoadEvent event) {
        String historyEntry = event.getDocEntryName();
        if (historyEntry != null && !historyEntry.isEmpty()) {
            String demoName = Constants.EXT4J + "_" + demo.getDemoTitle().replace(" ", "_");
            if (historyEntry.equalsIgnoreCase(demoName)) {
                if (isAdded == false) {
                    demo.addCloseHandler(new CloseHandler() {
                        @Override
                        public void onEvent(Panel panel) {
                            demo = getDemoBase();
                            isAdded = false;
                        }
                    });
                    Ext4jPanel.get().addContent(demo);
                    isAdded = true;
                } else {
                    Ext4jPanel.get().setActiveTab(demo);
                }
            }
        }
    }

    public abstract DemoBase getDemoBase();

}
