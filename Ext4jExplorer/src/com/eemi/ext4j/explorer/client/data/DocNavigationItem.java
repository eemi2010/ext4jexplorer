package com.eemi.ext4j.explorer.client.data;

import com.eemi.ext4j.explorer.client.core.Constants;

public class DocNavigationItem extends NavigationItem {

    private String sourcePath;

    public DocNavigationItem(String text) {
        setText(text);
        setContent(Constants.DOC_ENTRY);
        setSourcePath(text + ".html");
        setIcon("imgs/next.png");
        setLeaf(true);
    }

    public void setSourcePath(String path) {
        this.sourcePath = path;
        set("src", path);
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

}
