package com.nttdata.ext4j.explorer.client.ui.demos.layout;

import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class AnchorLayoutDemo extends DemoBase {

    public static final String TITLE = "Anchor";

    public AnchorLayoutDemo() {

        Panel container = new Panel("Anchor Layout");
        container.setLayout(Layout.ANCHOR);
        container.setSize(1000, 600);
        container.setCollapsible(true);
        container.setXY(30, 50);

        Panel panel1 = new Panel("NotificationContainer 1");
        panel1.setBodyPadding(10);
        panel1.setHtml("Width = 50% of the container");
        panel1.setAnchor("50%");
        container.add(panel1);

        Panel panel2 = new Panel("NotificationContainer 2");
        panel2.setBodyPadding(10);
        panel2.setHtml("Width = container width - 100px");
        panel2.setAnchor("-100");
        container.add(panel2);

        Panel panel3 = new Panel("NotificationContainer 3");
        panel3.setBodyPadding(10);
        panel3.setHtml("Width = container width - 10px<br/> Height = container height - 262px");
        panel3.setAnchor("-10, -262");
        container.add(panel3);

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
        // 99803176
        // 77668194
        // 79910337
        // 91139697

    }

}
