package com.nttdata.ext4j.explorer.client.ui.app;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Frame;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.data.BaseModel;
import com.nttdata.ext4j.client.data.NodeInterface;
import com.nttdata.ext4j.client.data.TableItem;
import com.nttdata.ext4j.client.data.TreeStore;
import com.nttdata.ext4j.client.data.handlers.BubbleHandler;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.events.handlers.table.ItemEventHandler;
import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.layout.FitLayout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.DataView;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.ToolBar;
import com.nttdata.ext4j.client.ui.ToolBarSpacer;
import com.nttdata.ext4j.client.ui.TreePanel;
import com.nttdata.ext4j.client.ui.Window;
import com.nttdata.ext4j.explorer.client.bindery.EventBusUtil;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEvent;
import com.nttdata.ext4j.explorer.client.bindery.events.DocEntryLoadEventHandler;
import com.nttdata.ext4j.explorer.client.core.Constants;

public abstract class NavigationBase extends TreePanel implements DocEntryLoadEventHandler {

    protected Button downloadButton;
    protected String downloadUrl = "";
    protected Window downloadWindow;

    public NavigationBase() {
        EventBusUtil.get().addHandler(DocEntryLoadEvent.TYPE, this);
        this.setStore(this.getStore());
        this.setRegion(BorderRegion.WEST);
        this.setCollapsible(true);
        this.setSplit(true);
        this.setRootVisible(false);
        this.setWidth(300);
        this.addItemClickHandler(new ItemEventHandler() {
            @Override
            public void onEvent(DataView view, TableItem record, JavaScriptObject item, int index, EventObject event) {
                BaseModel model = record.getRaw();
                String data = model.get("data");
                String text = model.get("text").replace(" ", "_");
                if (data.equalsIgnoreCase(Constants.DOC_ENTRY)) {
                    text = "Doc_" + text;
                }
                String historyToken = getProductName() + "_" + text;
                History.newItem(historyToken, true);
            }
        });

        ToolBar t = new ToolBar();

        Button discussButton = new Button("Feedback");
        discussButton.setIcon("imgs/talk.png");
        discussButton.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {

            }
        });
        t.add(discussButton);
        t.add(new ToolBarSpacer());

        downloadButton = new Button("Download");
        downloadButton.setIcon("imgs/download.png");
        downloadButton.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                downloadWindow = new Window();
                downloadWindow.setWidth(1000);
                downloadWindow.setHeight(600);
                downloadWindow.setLayout(new FitLayout());
                downloadWindow.setModal(true);
                downloadWindow.setTitle("Download");

                Panel p = new Panel(new FitLayout());
                downloadWindow.add(p);

                Frame f = new Frame(downloadUrl);
                p.add(f);
                downloadWindow.show();
            }
        });
        t.add(downloadButton);

        Button b = new Button();
        b.setTooltip("Expand all");
        b.setIcon("imgs/expand.png");
        b.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                NavigationBase.this.expandAll();
            }
        });
        t.add(b);

        b = new Button();
        b.setTooltip("Collapse all");
        b.setIcon("imgs/collapse.png");
        b.addClickHandler(new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                NavigationBase.this.collapseAll();
            }
        });
        t.add(b);

        this.addDocked(t);
    }

    @Override
    public void onEvent(DocEntryLoadEvent event) {
        String docEntry = event.getDocEntryName();
        if (docEntry != null && !docEntry.isEmpty()) {
            final String treeItemText = docEntry.replace("_", " ");
            int firstWhiteSpace = treeItemText.indexOf(" ");
            final String toUse = treeItemText.substring(firstWhiteSpace + 1);
            final NodeInterface node = this.getRootNode().findChild("text", toUse, true);
            if (node != null && treeItemText.indexOf(getProductName()) >= 0
                            && treeItemText.length() > getProductName().length()) {
                node.bubble(new BubbleHandler() {
                    @Override
                    public void onNodeTraverse(NodeInterface node) {
                        node.expand();
                    }
                });
                Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                    @Override
                    public void execute() {
                        NavigationBase.this.getSelectionModel().select(node);
                    }
                });

            }

        }
    }

    public abstract TreeStore getStore();

    public abstract String getProductName();
}
