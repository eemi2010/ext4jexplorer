package com.nttdata.ext4j.explorer.client;

import com.google.gwt.user.client.Window;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.ExtEntryPoint;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Viewport;

public class Demo extends ExtEntryPoint {

    @Override
    public void onLoad() {
        Button button = new Button("Click Me");
        button.setText("Hello Word");
        button.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                Window.alert("I was clicked");

            }
        });
        button.setXY(100, 100);
        Viewport.get().add(button);
    }

}