package com.nttdata.ext4j.explorer.client.controllers.demos.component;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDemoController;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.explorer.client.ui.demos.components.MessageBoxDemo;

public class MessageBoxDemoController extends AbstractDemoController {

    private static final MessageBoxDemoController INSTANCE = new MessageBoxDemoController();

    public static MessageBoxDemoController get() {
        return INSTANCE;
    }

    private MessageBoxDemoController() {

    }

    @Override
    public DemoBase getDemoBase() {
        return MessageBoxDemo.get();
    }

}
