package com.nttdata.ext4j.explorer.client.ui.app;

import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.rpc.RequestUtil;

/**
 * Implements the welcome panel of the doc app
 * 
 * @author alainekambi
 * 
 */
public class WelcomePanel extends Panel {

    private static final WelcomePanel INSTANCE = new WelcomePanel();

    public static WelcomePanel get() {

        return INSTANCE;
    }

    private WelcomePanel() {
        this.setTitle("Welcome");
        this.setCls("docPanel");
        Ext4jPanel.get().add(this);
        RequestUtil.loadContent("index.html", this);
    }

}
