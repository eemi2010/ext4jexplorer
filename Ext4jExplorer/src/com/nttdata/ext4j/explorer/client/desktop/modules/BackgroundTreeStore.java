package com.nttdata.ext4j.explorer.client.desktop.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.nttdata.ext4j.client.data.TableItem;
import com.nttdata.ext4j.client.data.TreeStore;
import com.nttdata.ext4j.explorer.client.data.NavigationItem;
import com.nttdata.ext4j.webdesktop.client.resources.Resources;

public class BackgroundTreeStore extends TreeStore {

    private static final BackgroundTreeStore INSTANCE = new BackgroundTreeStore(getData());
    private static Map<String, Image> map = new HashMap<String, Image>();

    private BackgroundTreeStore(ArrayList<? extends TableItem> data) {
        super(data);

    }

    public static BackgroundTreeStore get() {
        return INSTANCE;
    }

    private static ArrayList<TableItem> getData() {
        ArrayList<TableItem> data = new ArrayList<TableItem>();
        data.add(prepareData("BMW", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Stone", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Blue Sencha", Resources.WALLPAPERS.blueSencha()));
        data.add(prepareData("Wood Sencha", Resources.WALLPAPERS.woodSencha()));
        data.add(prepareData("Blue", Resources.WALLPAPERS.blue()));
        data.add(prepareData("Water", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Desk", Resources.WALLPAPERS.desk()));
        data.add(prepareData("Leopard", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Desktop", Resources.WALLPAPERS.desktop()));
        data.add(prepareData("Standalone", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Sahara", Resources.WALLPAPERS.desktop2()));
        data.add(prepareData("Sky", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Toy", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Water", Resources.WALLPAPERS.sky()));
        data.add(prepareData("Stonehenge", Resources.WALLPAPERS.sky()));

        return data;
    }

    private static BackgroundEntry prepareData(String text, ImageResource res) {
        BackgroundEntry entry = new BackgroundEntry(text);
        // map.put(text, new Image(res));
        return entry;
    }

    private static class BackgroundEntry extends NavigationItem {

        public BackgroundEntry(String text) {
            this.set("text", text);
            setIcon("imgs/bullet.png");
        }
    }

}
