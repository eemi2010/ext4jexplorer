package com.eemi.ext4j.explorer.client.bindery.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Dispatched when an asset is loaded
 * 
 */
public class DocEntryLoadEvent extends GwtEvent<DocEntryLoadEventHandler> {

    public static Type<DocEntryLoadEventHandler> TYPE = new Type<DocEntryLoadEventHandler>();

    private String docEntryName;
    private String data;

    public DocEntryLoadEvent(String compomentName) {
        this.docEntryName = compomentName;
    }

    public DocEntryLoadEvent(String compomentName, String data) {
        this.docEntryName = compomentName;
        this.data = data;
    }

    @Override
    public Type<DocEntryLoadEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DocEntryLoadEventHandler handler) {
        handler.onEvent(this);
    }

    public String getDocEntryName() {
        return this.docEntryName;
    }

    public String getData() {
        return this.data;
    }

}
