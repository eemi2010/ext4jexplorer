package com.nttdata.ext4j.explorer.client.controllers.docentries;

import com.nttdata.ext4j.client.events.handlers.panel.CloseHandler;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.controllers.AbstractDocController;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.ui.app.Ext4jPanel;
import com.nttdata.ext4j.explorer.client.ui.docentries.DocEntryBase;
import com.nttdata.ext4j.explorer.client.ui.docentries.SenchaDocsDocEntry;

public class SenchaDocsDocEntryController extends AbstractDocController {

    private static final SenchaDocsDocEntryController INSTANCE = new SenchaDocsDocEntryController();

    public static SenchaDocsDocEntryController get() {
        return INSTANCE;
    }

    private SenchaDocsDocEntryController() {

    }

    @Override
    public DocEntryBase getDocEntry() {
        return new SenchaDocsDocEntry();
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
                    isAdded = true;
                } else {
                    Ext4jPanel.get().setActiveTab(docEntry);
                }
            }
        }

    }

}
