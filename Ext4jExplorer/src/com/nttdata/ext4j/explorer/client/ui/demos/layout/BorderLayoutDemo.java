package com.nttdata.ext4j.explorer.client.ui.demos.layout;

import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class BorderLayoutDemo extends DemoBase {

    public static final String TITLE = "Border";

    public BorderLayoutDemo() {

        Panel container = new Panel("Border Layout");
        container.setLayout(Layout.BORDER);
        container.setSize(1000, 600);
        container.setCollapsible(true);
        container.setXY(30, 50);

        Panel navigation = new Panel("Navigation");
        navigation.setRegion(BorderRegion.WEST);
        navigation.setMargin("5 0 0 0");
        navigation.setBodyPadding(15);
        navigation.setHtml("Secondary Content like navigation links could go here");
        navigation.setWidth(175);
        navigation.setMinSize(100);
        navigation.setMaxSize(250);
        navigation.setCollapsible(true);
        navigation.setSplit(true);
        container.add(navigation);

        Panel mainContent = new Panel("Main Content");
        mainContent.setBodyPadding(10);
        mainContent.setCollapsible(false);
        mainContent.setHtml("<b>Main Page</b><br/>This is where the main content would go");
        mainContent.setRegion(BorderRegion.CENTER);
        mainContent.setMargin("5 0 0 0");
        container.add(mainContent);

        Panel footer = new Panel("Footer");
        footer.setRegion(BorderRegion.SOUTH);
        footer.setBodyPadding(10);
        footer.setHtml("Footer");
        footer.setHeight(120);
        footer.setMinSize(75);
        footer.setMaxSize(250);
        footer.setCollapsible(true);
        footer.setSplit(true);
        container.add(footer);

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
