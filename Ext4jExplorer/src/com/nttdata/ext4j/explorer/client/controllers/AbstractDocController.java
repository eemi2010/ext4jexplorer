package com.nttdata.ext4j.explorer.client.controllers;

import com.nttdata.ext4j.explorer.client.bindery.EventBusUtil;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEventHandler;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.rpc.RequestUtil;
import com.nttdata.ext4j.explorer.client.ui.app.Ext4jPanel;
import com.nttdata.ext4j.explorer.client.ui.docentries.DocEntryBase;
import com.nttdata.gwt4ext.client.events.handlers.panel.CloseHandler;
import com.nttdata.gwt4ext.client.ui.Panel;

public abstract class AbstractDocController implements DocEntryLoadEventHandler {

    private boolean isAdded;
    protected DocEntryBase docEntry;

    public AbstractDocController() {
        EventBusUtil.get().addHandler(DocEntryLoadEvent.TYPE, this);
        docEntry = getDocEntry();
    }

    @Override
    public void onEvent(DocEntryLoadEvent event) {
        String historyEntry = event.getDocEntryName();
        if (historyEntry != null && !historyEntry.isEmpty()) {
            String demoName = Constants.EXT4J + "_Doc_" + docEntry.getDocTitle().replace(" ", "_");
            if (historyEntry.equalsIgnoreCase(demoName)) {
                if (isAdded == false) {
                    docEntry.addCloseHandler(new CloseHandler() {
                        @Override
                        public void onEvent(Panel panel) {
                            docEntry = getDocEntry();
                            isAdded = false;
                        }
                    });
                    Ext4jPanel.get().addContent(docEntry);
                    RequestUtil.loadContent(demoName.toLowerCase() + ".html", docEntry);
                    isAdded = true;
                } else {
                    Ext4jPanel.get().setActiveTab(docEntry);
                }
            }
        }

    }

    public abstract DocEntryBase getDocEntry();

}
