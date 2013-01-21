package com.nttdata.ext4j.explorer.client.ui.demos.layout;

import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class AbsoluteLayoutDemo extends DemoBase {

    public static final String TITLE = "Absolute";

    public AbsoluteLayoutDemo() {

        Panel container = new Panel("Absolute Layout");
        container.setLayout(Layout.ABSOLUTE);
        container.setSize(1000, 600);
        container.setCollapsible(true);
        container.setXY(30, 50);
        container.setTitleAlign(Position.CENTER);

        Panel panel1 = new Panel("Panel 1");
        panel1.setSize(200, 200);
        panel1.setHtml("Positioned at x:50, y:50");
        panel1.setFrame(true);
        panel1.setXY(50, 50);
        container.add(panel1);

        Panel panel2 = new Panel("Panel 2");
        panel2.setSize(200, 200);
        panel2.setFrame(true);
        panel2.setXY(125, 125);
        panel2.setHtml("Positioned at x:125, y:125");
        container.add(panel2);

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
