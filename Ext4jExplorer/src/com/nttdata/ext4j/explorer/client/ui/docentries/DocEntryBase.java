package com.nttdata.ext4j.explorer.client.ui.docentries;

import com.nttdata.gwt4ext.client.ui.Panel;

/**
 * Base class for all pane containing doc entries.
 * 
 * @author alainekambi
 * 
 */
public abstract class DocEntryBase extends Panel {

    public DocEntryBase() {
        this.setTitle(getDocTitle());
        this.setAutoScroll(true);
        this.setClosable(true);
    }

    public abstract String getDocTitle();
}
