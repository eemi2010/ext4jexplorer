package com.nttdata.ext4j.explorer.client.ui.app;

import com.nttdata.ext4j.explorer.client.data.Ext4jNavigationTreeStore;
import com.nttdata.gwt4ext.client.data.TreeStore;

public class Ext4jNavigation extends NavigationBase {

    private static final Ext4jNavigation INSTANCE = new Ext4jNavigation();

    public static Ext4jNavigation get() {
        return INSTANCE;
    }

    private Ext4jNavigation() {
        this.downloadButton.setText("Download Ext4j");
        this.downloadUrl = "";

    }

    @Override
    public TreeStore getStore() {
        return Ext4jNavigationTreeStore.get();
    }

    @Override
    public String getProductName() {
        return "Ext4j";
    }

}
