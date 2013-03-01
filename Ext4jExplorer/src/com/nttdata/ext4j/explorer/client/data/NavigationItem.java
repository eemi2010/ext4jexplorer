package com.nttdata.ext4j.explorer.client.data;

import com.nttdata.ext4j.client.data.TableItem;

public class NavigationItem extends TableItem {

    private String sourcePath;

    public NavigationItem() {
        setText("");
        setContent("data");
        setLeaf(true);
    }

    public NavigationItem(String text) {
        setText(text);
        setContent("data");
        setSourcePath(text + ".html");
        setIcon("imgs/next.png");
        setLeaf(true);
    }

    public NavigationItem(String text, String data) {
        this(text);
        setContent(data);
    }

    public void setSourcePath(String path) {
        this.sourcePath = path;
        set("src", path);
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

}
