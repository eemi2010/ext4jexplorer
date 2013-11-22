package com.eemi.ext4j.explorer.client.bindery.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to the game start event
 */
public interface DocEntryLoadEventHandler extends EventHandler {
    public void onEvent(DocEntryLoadEvent event);
}
