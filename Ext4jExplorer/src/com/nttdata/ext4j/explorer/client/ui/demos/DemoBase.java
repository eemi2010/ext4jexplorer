package com.nttdata.ext4j.explorer.client.ui.demos;

import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.rpc.RequestUtil;
import com.nttdata.gwt4ext.client.core.Component;
import com.nttdata.gwt4ext.client.core.config.Position;
import com.nttdata.gwt4ext.client.events.handlers.tab.TabChangeHandler;
import com.nttdata.gwt4ext.client.layout.Layout;
import com.nttdata.gwt4ext.client.ui.Panel;
import com.nttdata.gwt4ext.client.ui.TabPanel;

public abstract class DemoBase extends Panel {

    protected Panel demoPanel;
    protected Panel sourcePanel;
    private TabPanel demoContainer;
    private boolean sourceCodeLoaded = false;

    public DemoBase() {
        this.setTitle(getDemoTitle());
        this.setLayout(Layout.FIT);
        this.setClosable(true);

        demoContainer = new TabPanel();
        demoContainer.setTabPosition(Position.BOTTOM);

        demoPanel = new Panel("Demo");
        demoContainer.add(demoPanel);

        sourcePanel = new Panel("Source");
        sourcePanel.setAutoScroll(true);
        demoContainer.add(sourcePanel);
        demoContainer.addTabChangeHandler(new TabChangeHandler() {
            @Override
            public void onEvent(TabPanel panel, Component newCard, Component oldCard) {
                Panel focusedPanel = Panel.cast(newCard);
                if (focusedPanel.getTitle().equalsIgnoreCase("source")) {
                    if (sourceCodeLoaded == false) {
                        String fileName = Constants.EXT4J.toLowerCase() + "_"
                                        + getDemoTitle().toLowerCase().replace(" ", "_") + ".html";
                        RequestUtil.loadContent(fileName, focusedPanel);
                        sourceCodeLoaded = true;
                    }
                }
            }
        });

        this.add(demoContainer);

    }

    public abstract String getDemoTitle();

    /**
     * @return the demoPanel
     */
    public Panel getDemoPanel() {
        return demoPanel;
    }

    /**
     * @return the sourcePanel
     */
    public Panel getSourcePanel() {
        return sourcePanel;
    }

    /**
     * @return the demoContainer
     */
    public TabPanel getDemoContainer() {
        return demoContainer;
    }
}
