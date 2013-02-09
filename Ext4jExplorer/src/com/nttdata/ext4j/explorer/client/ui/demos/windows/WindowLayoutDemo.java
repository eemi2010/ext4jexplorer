package com.nttdata.ext4j.explorer.client.ui.demos.windows;

import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.laf.ButtonScale;
import com.nttdata.ext4j.client.layout.BorderLayout;
import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.TabPanel;
import com.nttdata.ext4j.client.ui.Window;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class WindowLayoutDemo extends DemoBase {

    public static final String TITLE = "Window Layout";

    public static WindowLayoutDemo get() {
        return new WindowLayoutDemo();
    }

    private WindowLayoutDemo() {
        Button button = new Button("Show window");
        button.setXY(100, 100);
        button.setScale(ButtonScale.LARGE);
        button.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                showWindow();
            }
        });
        demoPanel.add(button);
    }

    protected void showWindow() {

        Window window = new Window("Layout Window");
        window.setModal(true);
        window.setClosable(true);
        window.setSize(600, 350);
        window.setMinWidth(350);

        BorderLayout layout = new BorderLayout();
        layout.setPadding(5);
        window.setLayout(layout);

        Panel navigation = new Panel("Navigation");
        navigation.setWidth(200);
        navigation.setRegion(BorderRegion.WEST);
        navigation.setSplit(true);
        navigation.setCollapsible(true);
        navigation.setFloatable(false);
        window.add(navigation);

        TabPanel centerContent = new TabPanel();
        centerContent.setRegion(BorderRegion.CENTER);

        Panel tab = new Panel("Bogus Tab");
        tab.setHtml("Hello World 1");
        centerContent.add(tab);

        tab = new Panel("Another Tab");
        tab.setHtml("Hello World 2");
        centerContent.add(tab);

        tab = new Panel("Closable Tab");
        tab.setHtml("Hello World 3");
        tab.setClosable(true);
        centerContent.add(tab);
        window.add(centerContent);

        window.show();

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
