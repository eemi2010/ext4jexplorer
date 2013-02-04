package com.nttdata.ext4j.explorer.client.ui.docentries;

import com.nttdata.ext4j.client.ui.Panel;

/**
 * Base class for all pane containing doc entries.
 * 
 * @author alainekambi
 * 
 */
@SuppressWarnings("unchecked")
public abstract class DocEntryBase extends Panel {

    public DocEntryBase() {
        this.setTitle(getDocTitle());
        this.setAutoScroll(true);
        this.setClosable(true);
    }

    public abstract String getDocTitle();
}
