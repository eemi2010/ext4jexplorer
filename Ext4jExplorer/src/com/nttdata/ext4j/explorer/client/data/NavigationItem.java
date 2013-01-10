package com.nttdata.ext4j.explorer.client.data;

import com.nttdata.gwt4ext.client.data.TableItem;

public class NavigationItem extends TableItem {

    private String sourcePath;

    public NavigationItem() {
        setText("");
        setData("data");
        setLeaf(true);
    }

    public NavigationItem(String text) {
        setText(text);
        setData("data");
        setSourcePath(text + ".html");
        setIcon("imgs/next.png");
        setLeaf(true);
    }

    public NavigationItem(String text, String data) {
        this(text);
        setData(data);
    }

    public void setSourcePath(String path) {
        this.sourcePath = path;
        set("src", path);
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

}
