package com.nttdata.ext4j.explorer.client.ui.app;

import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.TabPanel;

public class Ext4jPanel extends TabPanel {

    private static final Ext4jPanel INSTANCE = new Ext4jPanel();

    public static Ext4jPanel get() {
        return INSTANCE;
    }

    private Ext4jPanel() {
        this.setRegion(BorderRegion.CENTER);
        this.setBodyPadding(2);
        this.setLayout(Layout.FIT);
    }

    public void addContent(Panel panel) {
        this.add(panel);
        this.setActiveTab(panel);
    }

}
