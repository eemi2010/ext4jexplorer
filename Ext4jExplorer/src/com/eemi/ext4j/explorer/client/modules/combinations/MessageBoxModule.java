package com.eemi.ext4j.explorer.client.modules.combinations;

import com.eemi.ext4j.client.core.config.ButtonText;
import com.eemi.ext4j.client.core.config.MessageBoxConfig;
import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.events.menu.ItemClickEvent;
import com.eemi.ext4j.client.events.menu.ItemClickHandler;
import com.eemi.ext4j.client.events.messagebox.ConfirmCallback;
import com.eemi.ext4j.client.events.messagebox.PromptCallback;
import com.eemi.ext4j.client.fx.easing.Easing;
import com.eemi.ext4j.client.laf.Alignment;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Menu;
import com.eemi.ext4j.client.ui.MenuItem;
import com.eemi.ext4j.client.ui.MessageBox;
import com.eemi.ext4j.client.ui.Panel;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.combinations.resources.CombinationModulesResources;
import com.eemi.ext4j.ux.notification.client.Notification;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.google.gwt.user.client.Timer;

public class MessageBoxModule extends BaseDemoModule {

    private final String MODULE_TITLE = "MessageBox";

    private Notification notification;
    private ItemClickHandler itemClickHandler;

    public static final MessageBoxModule INSTANCE = new MessageBoxModule();

    private MessageBoxModule() {

        itemClickHandler = new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                processEvent(event.getSource().getText());
            }
        };
        notification = new Notification().setAutoCloseDelay(3000).setSlideInAnimation(Easing.ELASTIC_IN)
                        .setPosition("t").setTitle("Button Click").setClosable(false)
                        .setIconCls("ux-notification-icon-information").setCls("ux-notification-light");

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Ext4j MessageBox Demo");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(CombinationModulesResources.ICONS.messageBox128());
        moduleConfig.setToolbarIcon(CombinationModulesResources.ICONS.messageBox24());
        moduleConfig.setMenuItemIcon(CombinationModulesResources.ICONS.messageBox16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setLayout(Layout.FIT);

        Panel demoPanel = new Panel();
        win.add(demoPanel);

        Button confirmButton = new Button("Confirm");
        confirmButton.setXY(50, 100);
        confirmButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBox.confirm("Confirm", "Are you sure you want to do that ?", new ConfirmCallback() {
                    @Override
                    public void execute(String btnID) {
                        displayMessage("You clicked the " + btnID + " button.");
                    }
                });
            }
        });
        demoPanel.add(confirmButton);

        Button iconsButton = new Button("Icons");
        iconsButton.setArrowAlign(Alignment.BOTTOM);

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Error", itemClickHandler));
        menu.addItem(new MenuItem("Informational", itemClickHandler));
        menu.addItem(new MenuItem("Question", itemClickHandler));
        menu.addItem(new MenuItem("Warning", itemClickHandler));
        iconsButton.setMenu(menu);
        iconsButton.setXY(100, 100);

        demoPanel.add(iconsButton);

        Button promptButton = new Button("Prompt");
        promptButton.setXY(150, 100);
        promptButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBox.prompt("Name", "Please enter your name", new PromptCallback() {
                    @Override
                    public void execute(String btnID, String text) {
                        displayMessage("You clicked the " + btnID + " button and entered the text " + text);
                    }
                });
            }
        });
        demoPanel.add(promptButton);

        Button multiLinePromptButton = new Button("Multiline Prompt");
        multiLinePromptButton.setXY(200, 100);
        multiLinePromptButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBoxConfig config = new MessageBoxConfig();
                config.setTitle("Address");
                config.setMultiline(true);
                config.setButtons(MessageBox.YESNOCANCEL);
                config.setMessage("Please enter your address");
                config.setCallback(new PromptCallback() {
                    @Override
                    public void execute(String btnID, String text) {
                        displayMessage("You clicked the " + btnID + " button and entered the text " + text);
                    }
                });

                MessageBox.show(config);
            }
        });
        demoPanel.add(multiLinePromptButton);

        Button yesNoCancelButton = new Button("YES/No/Cancel");
        yesNoCancelButton.setXY(250, 100);
        yesNoCancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBoxConfig config = new MessageBoxConfig();
                config.setTitle("Save changes ?");
                config.setButtons(MessageBox.YESNOCANCEL);
                config.setIcon(MessageBox.QUESTION);
                config.setMessage("You are closing a tab that has unsaved changes. <br />Would you like to save your changes?");
                config.setCallback(new ConfirmCallback() {
                    @Override
                    public void execute(String btnID) {
                        displayMessage("You clicked the " + btnID + " button.");
                    }
                });

                MessageBox.show(config);
            }
        });
        demoPanel.add(yesNoCancelButton);

        Button waitButton = new Button("Wait Dialog");
        waitButton.setXY(300, 100);
        waitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBoxConfig config = new MessageBoxConfig();
                config.setTitle("Please wait");
                config.setMessage("Saving your data, please wait ...");
                config.setProgressText("Saving ...");
                config.setWidth(300);
                config.setWait(true);
                config.setWaitInterval(200);
                config.setClosable(false);
                MessageBox.show(config);

                new Timer() {
                    @Override
                    public void run() {
                        MessageBox.hide();
                        displayMessage("You data was saved !");
                    }
                }.schedule(4000);
            }
        });
        demoPanel.add(waitButton);

        Button alertButton = new Button("Alert");
        alertButton.setXY(350, 100);
        alertButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBox.alert("Status", "Changes saved successfully");
            }
        });
        demoPanel.add(alertButton);

        Button customTextButton = new Button("Custom button text");
        customTextButton.setXY(400, 100);
        customTextButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MessageBoxConfig config = new MessageBoxConfig();
                config.setTitle("What really ?");
                config.setMessage("Are you sure ?");
                config.setButtons(MessageBox.YESNO);
                config.setButtonText(new ButtonText("Definitely !", "No Chance"));
                config.setCallback(new ConfirmCallback() {
                    @Override
                    public void execute(String btnID) {
                        displayMessage("You clicked the " + btnID + " button.");
                    }
                });
                MessageBox.show(config);
            }
        });
        demoPanel.add(customTextButton);

        return win;
    }

    private void displayMessage(String message) {
        notification.setMessage(message).show();
    }

    private void processEvent(String value) {
        showMessageBoxWithIcon(value);
    }

    private void showMessageBoxWithIcon(String value) {
        String icon = MessageBox.ERROR;
        if (value.equalsIgnoreCase("Informational")) {
            icon = MessageBox.INFO;
        } else if (value.equalsIgnoreCase("Question")) {
            icon = MessageBox.QUESTION;
        } else if (value.equalsIgnoreCase("Warning")) {
            icon = MessageBox.WARNING;
        }
        MessageBoxConfig config = new MessageBoxConfig();
        config.setTitle("Icon support");
        config.setIcon(icon);
        config.setButtons(MessageBox.OK);
        config.setMessage("Here is a message with an icon !");
        config.setCallback(new ConfirmCallback() {
            @Override
            public void execute(String btnID) {
                displayMessage("You clicked the " + btnID + " button.");
            }
        });

        MessageBox.show(config);
    }

}
