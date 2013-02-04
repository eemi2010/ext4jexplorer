package com.nttdata.ext4j.explorer.client.ui.docentries;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Frame;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.explorer.client.core.Constants;

@SuppressWarnings("unchecked")
public class SenchaDocsDocEntry extends DocEntryBase {

    public static final String TITLE = "Official Sencha Documentation";

    public SenchaDocsDocEntry() {
        this.setLayout(Layout.FIT);
        this.setAutoScroll(false);
        Frame frame = new Frame(Constants.EXT4J_DOCS_LINK);
        frame.getElement().getStyle().setBorderWidth(0, Unit.PX);
        this.add(frame);
    }

    @Override
    public String getDocTitle() {
        return TITLE;
    }

}
