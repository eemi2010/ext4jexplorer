package com.nttdata.ext4j.explorer.client.ui.demos.layout;

import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.layout.ColumnLayoutData;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Container;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

@SuppressWarnings("unchecked")
public class ColumnLayoutDemo extends DemoBase {

    public static final String TITLE = "Column";

    public ColumnLayoutDemo() {

        Panel container = new Panel("Column Layout");
        container.setLayout(Layout.BORDER);
        container.setSize(1000, 600);
        container.setCollapsible(true);
        container.setXY(30, 50);
        container.setTitleAlign(Position.CENTER);
        container.add(getNavigationPanel());
        container.add(getCenterPanel());

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

    private Panel getNavigationPanel() {
        Panel panel = new Panel("West");
        panel.setSplit(true);
        panel.setWidth(200);
        panel.setMinSize(175);
        panel.setMaxSize(400);
        panel.setCollapsible(true);
        panel.setLayout(Layout.ACCORDION);
        panel.setRegion(BorderRegion.WEST);

        Panel child = new Panel("Navigation");
        child.setAutoScroll(true);
        child.setBorder(false);
        child.setBodyPadding(10);
        child.setHtml(Constants.getShortBogusMarkup());
        panel.add(child);

        child = new Panel("Settins");
        child.setAutoScroll(true);
        child.setBorder(false);
        child.setBodyPadding(10);
        child.setHtml(Constants.getShortBogusMarkup());
        panel.add(child);

        return panel;

    }

    private Panel getCenterPanel() {
        Panel panel = new Panel();
        // panel.setHeader(false);
        panel.setRegion(BorderRegion.CENTER);
        panel.setLayout(Layout.COLUMN);

        Container column = new Container();
        column.setBaseCls("x-plain");
        column.setPaddings(10, 10, 0, 10);

        Panel child = new Panel("A panel");
        child.setBodyPadding(10);
        child.setHtml(Constants.getShortBogusMarkup());
        column.add(child);

        panel.add(column, new ColumnLayoutData(.33));

        column = new Container();
        column.setBaseCls("x-plain");
        column.setPaddings(10, 10, 0, 10);

        child = new Panel("A panel");
        child.setBodyPadding(10);
        child.setHtml(Constants.getShortBogusMarkup());
        column.add(child);

        panel.add(column, new ColumnLayoutData(.33));

        column = new Container();
        column.setBaseCls("x-plain");
        column.setPaddings(10, 10, 0, 10);

        child = new Panel("A panel");
        child.setHtml(Constants.getShortBogusMarkup());
        child.setBodyPadding(10);
        column.add(child);

        child = new Panel("Another panel");
        child.setHtml(Constants.getShortBogusMarkup());
        child.setBodyPadding(10);
        column.add(child);

        panel.add(column, new ColumnLayoutData(.33));

        return panel;

    }

}
