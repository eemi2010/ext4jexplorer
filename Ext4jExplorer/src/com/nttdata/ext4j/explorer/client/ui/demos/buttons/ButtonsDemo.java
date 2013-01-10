package com.nttdata.ext4j.explorer.client.ui.demos.buttons;

import com.google.gwt.user.client.Window;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.gwt4ext.client.core.EventObject;
import com.nttdata.gwt4ext.client.events.handlers.button.InteractionHandler;
import com.nttdata.gwt4ext.client.events.handlers.menu.item.ItemClickHandler;
import com.nttdata.gwt4ext.client.laf.Alignment;
import com.nttdata.gwt4ext.client.laf.ButtonScale;
import com.nttdata.gwt4ext.client.ui.Button;
import com.nttdata.gwt4ext.client.ui.Menu;
import com.nttdata.gwt4ext.client.ui.MenuItem;
import com.nttdata.gwt4ext.client.ui.SplitButton;

public class ButtonsDemo extends DemoBase {

    public static final String TITLE = "Buttons";

    public static ButtonsDemo get() {
        return new ButtonsDemo();
    }

    private ButtonsDemo() {
        Button button = new Button("Ext Button");
        button.setScale(ButtonScale.LARGE);
        button.setXY(100, 100);
        button.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                Window.alert("Button was clicked !");
            }
        });
        demoPanel.add(button);

        Button menuButton = new Button("Menu Button");
        menuButton.setArrowAlign(Alignment.BOTTOM);

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Item 1"));
        menu.addItem(new MenuItem("Item 2"));
        menu.addItem(new MenuItem("Item 3"));
        menu.addItem(new MenuItem("Item 4"));
        menuButton.setMenu(menu);
        menuButton.setXY(150, 100);

        demoPanel.add(menuButton);

        SplitButton splitButton = new SplitButton("Split Button");
        splitButton.setXY(200, 100);

        menu = new Menu();
        MenuItem item = new MenuItem("Item 1");
        item.addClickHandler(new ItemClickHandler() {
            @Override
            public void onEvent(MenuItem item, EventObject event) {
                Window.alert("Item 1 waw clicked !!");
            }
        });
        menu.addItem(item);
        menu.addItem(new MenuItem("Item 2"));
        menu.addItem(new MenuItem("Item 3"));

        splitButton.setMenu(menu);

        demoPanel.add(splitButton);

        Button buttonWithIcon = new Button("Button with icon");
        buttonWithIcon.setScale(ButtonScale.MEDIUM);
        buttonWithIcon.setIcon("imgs/quit.png");
        buttonWithIcon.setXY(250, 100);
        demoPanel.add(buttonWithIcon);

        buttonWithIcon = new Button("Toggle Button with icon");
        buttonWithIcon.setScale(ButtonScale.MEDIUM);
        buttonWithIcon.setIcon("imgs/quit.png");
        buttonWithIcon.setXY(300, 100);
        buttonWithIcon.setEnableToggle(true);
        buttonWithIcon.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                if (button.isPressed()) {
                    Window.alert("I m pressed");
                }
            }
        });
        demoPanel.add(buttonWithIcon);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
