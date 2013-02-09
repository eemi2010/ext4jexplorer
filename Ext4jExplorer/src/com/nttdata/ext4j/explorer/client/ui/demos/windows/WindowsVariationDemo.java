package com.nttdata.ext4j.explorer.client.ui.demos.windows;

import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.laf.ButtonScale;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Window;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;

public class WindowsVariationDemo extends DemoBase {

    public static final String TITLE = "Variation Windows";

    public static WindowsVariationDemo get() {
        return new WindowsVariationDemo();
    }

    private WindowsVariationDemo() {
        Button button = new Button("Show windows");
        button.setXY(100, 100);
        button.setScale(ButtonScale.LARGE);
        button.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                showWindows();
            }
        });
        demoPanel.add(button);
    }

    protected void showWindows() {
        Window window1 = new Window();
        window1.setTitle("Constraining Window, plain: true");
        window1.setXY(100, 100);
        window1.setPlain(true);
        window1.setLayout(Layout.FIT);
        window1.setSize(400, 200);
        window1.setModal(true);

        Window constrainedWindow1 = new Window("Constrained Window");
        constrainedWindow1.setSize(200, 100);
        constrainedWindow1.setXY(1000, 20);
        constrainedWindow1.setLayout(Layout.FIT);
        // Constraining will pull the Window leftwards so that it's within the
        // parent Window
        constrainedWindow1.setConstrain(true);

        window1.add(constrainedWindow1);

        Window constrainedWindow2 = new Window("Header-Constrained Window");
        constrainedWindow2.setSize(200, 100);
        constrainedWindow2.setXY(120, 100);
        constrainedWindow2.setLayout(Layout.FIT);
        // Constraining will pull the Window leftwards so that it's within the
        // parent Window
        constrainedWindow2.setConstrainHeader(true);

        window1.add(constrainedWindow2);

        window1.show();
        constrainedWindow1.show();
        constrainedWindow2.show();

        Window w = new Window("Left Header, plain true");
        w.setSize(400, 200);
        w.setXY(500, 300);
        w.setPlain(true);
        w.setHeaderPosition(Position.LEFT);
        w.setLayout(Layout.FIT);
        w.show();

        w = new Window("Right Header, plain true");
        w.setSize(400, 200);
        w.setXY(500, 100);
        w.setPlain(true);
        w.setHeaderPosition(Position.RIGHT);
        w.setLayout(Layout.FIT);
        w.show();

        w = new Window("Bottom Header, plain true");
        w.setSize(400, 200);
        w.setXY(100, 400);
        w.setPlain(true);
        w.setHeaderPosition(Position.BOTTOM);
        w.setLayout(Layout.FIT);
        w.show();

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
