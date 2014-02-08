package com.eemi.ext4j.explorer.client.modules.button;

import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.events.menu.ItemClickEvent;
import com.eemi.ext4j.client.laf.Alignment;
import com.eemi.ext4j.client.laf.ButtonScale;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Menu;
import com.eemi.ext4j.client.ui.MenuItem;
import com.eemi.ext4j.client.ui.Panel;
import com.eemi.ext4j.client.ui.SplitButton;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.button.resources.ButtonModuleResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.google.gwt.user.client.Window;

/**
 * Module for the button example
 */
public class ButtonModule extends BaseDemoModule {

    public static final ButtonModule INSTANCE = new ButtonModule();
    private Panel demoPanel;
    private final String DESCRIPTION = "Create Buttons with Extj";

    private ButtonModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle("Buttons");
        moduleConfig.setModuleDescription(DESCRIPTION);
        moduleConfig.setDeletable(false);
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(ButtonModuleResources.ICONS.getIcon128());
        moduleConfig.setToolbarIcon(ButtonModuleResources.ICONS.getIcon24());
        moduleConfig.setMenuItemIcon(ButtonModuleResources.ICONS.getIcon16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setLayout(Layout.FIT);

        demoPanel = new Panel();
        win.add(demoPanel);

        Button button = new Button("Ext Button");
        button.setScale(ButtonScale.LARGE);
        button.setXY(100, 100);
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
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
        item.addItemClickHandler(new com.eemi.ext4j.client.events.menu.ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
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
        buttonWithIcon.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (event.getSource().isPressed()) {
                    Window.alert("I m pressed");
                }
            }
        });

        demoPanel.add(buttonWithIcon);

        return win;
    }

}
