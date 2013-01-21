package com.nttdata.ext4j.explorer.client.data;

import java.util.ArrayList;

import com.nttdata.ext4j.client.data.TableItem;

public class DocumentationData {

    private DocumentationData() {

    }

    public static TableItem getData() {
        NavigationItem root = new NavigationItem("Documentation");
        root.setIcon("imgs/bullet_shape.png");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new DocNavigationItem("Ext4j Fundamentals"));
        items.add(getComponentsEntry());
        items.add(getLayoutsEntry());
        root.setChildren(items);

        return root;
    }

    private static TableItem getComponentsEntry() {
        NavigationItem root = new NavigationItem("Components");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new DocNavigationItem("The Viewport Container"));
        items.add(new DocNavigationItem("The Panel"));
        items.add(new DocNavigationItem("Windows"));
        items.add(new DocNavigationItem("Tab Panel"));
        root.setChildren(items);

        root.setIcon("imgs/bullet_shape.png");
        return root;
    }

    private static TableItem getLayoutsEntry() {
        NavigationItem root = new NavigationItem("Exploring Layouts");

        ArrayList<TableItem> items = new ArrayList<TableItem>();
        items.add(new DocNavigationItem("Auto Layout"));
        items.add(new DocNavigationItem("Anchor Layout"));
        items.add(new DocNavigationItem("Absolute Layout"));
        items.add(new DocNavigationItem("Accordion Layout"));
        root.setChildren(items);

        root.setIcon("imgs/bullet_shape.png");
        return root;
    }
}
