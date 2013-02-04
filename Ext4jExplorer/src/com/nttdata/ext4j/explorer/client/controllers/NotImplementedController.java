package com.nttdata.ext4j.explorer.client.controllers;

import com.nttdata.ext4j.client.events.handlers.panel.CloseHandler;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.bindery.EventBusUtil;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEventHandler;
import com.nttdata.ext4j.explorer.client.ui.app.Ext4jPanel;

public class NotImplementedController implements DocEntryLoadEventHandler {

    private boolean panelAdded = false;
    private Panel notImplementedPanel;
    private static final NotImplementedController INSTANCE = new NotImplementedController();

    private NotImplementedController() {
        EventBusUtil.get().addHandler(DocEntryLoadEvent.TYPE, this);
    }

    @Override
    public void onEvent(DocEntryLoadEvent event) {
        String historyEntry = event.getDocEntryName();
        if (historyEntry != null && !historyEntry.isEmpty() && !AppController.isEntryImplemented(historyEntry)) {
            if (!panelAdded) {
                notImplementedPanel = creatPanel();
                notImplementedPanel.addCloseHandler(new CloseHandler() {
                    @Override
                    public void onEvent(Panel panel) {
                        notImplementedPanel = creatPanel();
                        panelAdded = false;
                    }
                });
                Ext4jPanel.get().addContent(notImplementedPanel);
                panelAdded = true;
            } else {
                Ext4jPanel.get().setActiveTab(notImplementedPanel);
            }

        }

    }

    private Panel creatPanel() {
        Panel p = new Panel("Not available");
        p.setBodyPadding(10);
        p.setHtml("<h1>Content not yet implemented !</h1>");
        p.setClosable(true);
        return p;
    }

    public static NotImplementedController get() {
        return INSTANCE;
    }
}
