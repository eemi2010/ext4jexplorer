package com.nttdata.ext4j.explorer.client.data;

import java.util.ArrayList;

import com.nttdata.ext4j.client.data.TableItem;
import com.nttdata.ext4j.client.data.TreeStore;
import com.nttdata.ext4j.explorer.client.ui.docentries.AboutDocEntry;
import com.nttdata.ext4j.explorer.client.ui.docentries.GettingStartedDocEntry;
import com.nttdata.ext4j.explorer.client.ui.docentries.RequirementsDocEntry;

public class Ext4jNavigationTreeStore extends TreeStore {

    private static final Ext4jNavigationTreeStore INSTANCE = new Ext4jNavigationTreeStore(getData());

    private Ext4jNavigationTreeStore(ArrayList<? extends TableItem> data) {
        super(data);
    }

    public static Ext4jNavigationTreeStore get() {
        return INSTANCE;
    }

    private static ArrayList<TableItem> getData() {
        ArrayList<TableItem> data = new ArrayList<TableItem>();
        data.add(new DocNavigationItem(AboutDocEntry.TITLE));
        data.add(new DocNavigationItem(RequirementsDocEntry.TITLE));
        data.add(new DocNavigationItem(GettingStartedDocEntry.TITLE));
        data.add(new DocNavigationItem("Java Docs"));
        data.add(new DocNavigationItem("Official Sencha Documentation"));
        data.add(DocumentationData.getData());
        data.add(ExamplesData.getData());
        return data;
    }

}
