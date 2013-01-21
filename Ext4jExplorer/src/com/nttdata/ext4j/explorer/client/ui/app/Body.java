package com.nttdata.ext4j.explorer.client.ui.app;

import com.nttdata.ext4j.client.layout.BorderLayout;
import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.ui.Panel;

/**
 * Implements the body of the application content.<br/>
 * The body contains the welcome panel and the Ext4j panel
 * 
 * @author alainekambi
 * 
 */
public class Body extends Panel {

    private static final Body INSTANCE = new Body();

    public static Body get() {
        return INSTANCE;
    }

    private Body() {
        this.setRegion(BorderRegion.CENTER);
        this.setLayout(new BorderLayout("5 5 5 5"));
        this.add(Ext4jNavigation.get());
        this.add(Ext4jPanel.get());
    }

}
