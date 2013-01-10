package com.nttdata.ext4j.explorer.client;

import com.nttdata.ext4j.explorer.client.controllers.AppController;
import com.nttdata.gwt4ext.client.core.ExtEntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ext4jExplorer extends ExtEntryPoint {
    @Override
    public void onLoad() {
        AppController.get().launchApp();
    }
}