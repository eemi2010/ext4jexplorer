package com.nttdata.ext4j.explorer.client.ui.app;

import com.nttdata.gwt4ext.client.layout.BorderLayout;
import com.nttdata.gwt4ext.client.ui.Panel;

/**
 * Application main container.<br/>
 * Contains the header and the body part of the application.
 * 
 * @author alainekambi
 * 
 */
public class AppContainer extends Panel {

    private static final AppContainer INSTANCE = new AppContainer();

    public static AppContainer get() {
        return INSTANCE;
    }

    private AppContainer() {
        this.setLayout(new BorderLayout("5 5 5 5"));
        this.add(Header.get());
        this.add(Body.get());
    }

    public Body getBodyContainer() {
        return Body.get();
    }

}
