package com.nttdata.ext4j.explorer.client.ui.demos.layout;

import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.gwt4ext.client.core.EventObject;
import com.nttdata.gwt4ext.client.core.config.Dock;
import com.nttdata.gwt4ext.client.core.config.Position;
import com.nttdata.gwt4ext.client.events.handlers.button.InteractionHandler;
import com.nttdata.gwt4ext.client.layout.Layout;
import com.nttdata.gwt4ext.client.ui.Button;
import com.nttdata.gwt4ext.client.ui.Panel;
import com.nttdata.gwt4ext.client.ui.ToolBar;
import com.nttdata.gwt4ext.client.ui.ToolBarFill;

public class CardLayoutDemo extends DemoBase {

    public static final String TITLE = "Card";
    private int index = 0;
    Button prevButton;
    Button nextButton;
    private Panel container;

    public CardLayoutDemo() {

        container = new Panel("Card Layout");
        container.setLayout(Layout.CARD);
        container.setSize(1000, 600);
        container.setCollapsible(true);
        container.setXY(30, 50);
        container.setTitleAlign(Position.CENTER);

        Panel card1 = new Panel();
        card1.setBodyPadding(10);
        card1.setHtml("<b>Welcome to the Demo Wizard</b><br/> Step 1of 3<br/>Please click the 'next' button to continue...");
        container.add(card1);

        Panel card2 = new Panel();
        card2.setHtml("Step 2 of 3<br/>Almost there please click the 'next' button to continue ...");
        card2.setBodyPadding(10);
        container.add(card2);

        Panel card3 = new Panel();
        card3.setBodyPadding(10);
        card3.setHtml("<b>Congratulations!</b><br/>Step 3 of 3 - Complete");
        container.add(card3);

        prevButton = new Button("&laquo; Previous");
        prevButton.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                index--;
                container.setActiveItem(index);
                nextButton.setDisabled(false);
                if (index <= 0) {
                    button.setDisabled(true);
                }
            }
        });
        prevButton.setDisabled(true);

        nextButton = new Button("Next &raquo;");
        nextButton.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                index++;
                container.setActiveItem(index);
                prevButton.setDisabled(false);
                if (index >= 2) {
                    button.setDisabled(true);
                }
            }
        });

        ToolBar footer = new ToolBar(Dock.BOTTOM);
        footer.add(new ToolBarFill(), prevButton, nextButton);
        container.addDocked(footer);

        demoPanel.add(container);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
