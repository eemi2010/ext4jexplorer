package com.nttdata.ext4j.explorer.client.ui.demos.layout;

import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.gwt4ext.client.core.config.Position;
import com.nttdata.gwt4ext.client.layout.Layout;
import com.nttdata.gwt4ext.client.ui.DatePicker;
import com.nttdata.gwt4ext.client.ui.Panel;

public class AccordionLayoutDemo extends DemoBase {

    public static final String TITLE = "Accordion";

    public AccordionLayoutDemo() {

        Panel container = new Panel("Accordion Layout");
        container.setLayout(Layout.ACCORDION);
        container.setSize(1000, 600);
        container.setCollapsible(true);
        container.setXY(30, 50);
        container.setTitleAlign(Position.CENTER);

        Panel panel1 = new Panel("Panel 1");
        panel1.setHtml("Accordion Content 1");
        container.add(panel1);

        Panel panel2 = new Panel("Panel 2");
        panel2.setBodyPadding(20);
        panel2.add(new DatePicker());
        container.add(panel2);

        Panel panel3 = new Panel("Panel 3");
        panel3.setBodyPadding(20);
        panel3.setHtml("Accordion Content 3");
        container.add(panel3);

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
