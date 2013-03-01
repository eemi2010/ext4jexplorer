package com.nttdata.ext4j.explorer.client.desktop.modules;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.resources.client.ImageResource;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.data.BaseModel;
import com.nttdata.ext4j.client.data.TableItem;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.events.handlers.panel.CloseHandler;
import com.nttdata.ext4j.client.events.handlers.table.ItemEventHandler;
import com.nttdata.ext4j.client.events.handlers.window.WindowEventHandler;
import com.nttdata.ext4j.client.laf.ButtonScale;
import com.nttdata.ext4j.client.layout.BorderRegion;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.DataView;
import com.nttdata.ext4j.client.ui.Image;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.client.ui.TreePanel;
import com.nttdata.ext4j.client.ui.Window;
import com.nttdata.ext4j.webdesktop.client.models.ModuleConfig;
import com.nttdata.ext4j.webdesktop.client.resources.Resources;
import com.nttdata.ext4j.webdesktop.client.views.core.Desktop;
import com.nttdata.ext4j.webdesktop.client.views.core.DesktopModule;
import com.nttdata.ext4j.webdesktop.client.views.core.DesktopModuleWindow;

/**
 * Gives informations about the current system
 * 
 * @author alainekambi
 * 
 */
public class SettingsModule extends DesktopModule {

    private DesktopModuleWindow window;
    private Button okButton;
    private Button cancelButton;
    private Image prevImage;
    private Image currentPreview;
    private Panel prevPanel;
    private ImageResource selectedBg;
    private ImageResource currentBg;

    // private ImageResource ;

    public SettingsModule() {
        selectedBg = Resources.WALLPAPERS.dummy();
        currentBg = Resources.WALLPAPERS.dummy();
        prevImage = new Image(selectedBg);
        currentPreview = new Image(currentBg);

    }

    @Override
    protected ModuleConfig createModuleConfig() {
        ModuleConfig c = new ModuleConfig();
        c.setModuleTitle(Resources.TEXT.settings());
        c.setIcon(Resources.ICONS.settings());
        return c;
    };

    @Override
    protected void createModuleWindow() {
        ensureWindowIsCreated();
        window.show();

    }

    private void ensureWindowIsCreated() {
        if (window == null) {

            window = new DesktopModuleWindow();
            window.setLayout(Layout.BORDER);
            window.setTitle(Resources.TEXT.settings());
            window.setTitleAlign(Position.CENTER);
            window.setSize(900, 600);
            window.setAnimateTarget(this.shortCut);
            window.addCloseHandler(new CloseHandler() {
                @Override
                public void onEvent(Panel panel) {
                    window = null;
                }
            });
            window.addMinimizeHandler(new WindowEventHandler() {
                @Override
                public void onEvent(Window window) {
                    window.hide();
                }
            });
            window.add(getBgPanel());
            window.add(getPreviewPanel());

            okButton = new Button("OK", new InteractionHandler() {
                @Override
                public void onEvent(Button button, EventObject event) {
                    window.hide();
                    Desktop.get().setWallPaper(selectedBg);
                }
            });
            okButton.setWidth(100);
            okButton.setScale(ButtonScale.MEDIUM);

            cancelButton = new Button("Cancel", new InteractionHandler() {
                @Override
                public void onEvent(Button button, EventObject event) {
                    window.hide();
                }
            });
            cancelButton.setWidth(100);
            cancelButton.setScale(ButtonScale.MEDIUM);

            window.addButtons(cancelButton, okButton);
            window.setModal(true);
        }
    }

    private Panel getBgPanel() {

        Panel leftPanel = new Panel("Desktop Background");
        leftPanel.setRegion(BorderRegion.WEST);
        leftPanel.setWidth(300);
        leftPanel.setLayout(Layout.BORDER);
        leftPanel.setSplit(true);

        TreePanel bgPanel = new TreePanel(BackgroundTreeStore.get());
        bgPanel.setRegion(BorderRegion.CENTER);
        bgPanel.setRootVisible(false);
        bgPanel.setSplit(true);
        bgPanel.addItemClickHandler(new ItemEventHandler() {
            @Override
            public void onEvent(DataView view, TableItem record, JavaScriptObject htmlElement, int index,
                            EventObject event) {
                BaseModel model = record.getRaw();
                String text = model.get("text");
                selectedBg = getImageResource(text);
                prevImage.setSrc(selectedBg);

            }
        });
        bgPanel.addItemDoubleClickHandler(new ItemEventHandler() {
            @Override
            public void onEvent(DataView view, TableItem record, JavaScriptObject htmlElement, int index,
                            EventObject event) {
                BaseModel model = record.getRaw();
                String text = model.get("text");
                selectedBg = getImageResource(text);
                window.hide();
                Desktop.get().setWallPaper(selectedBg);
            }
        });
        bgPanel.addItemMouseEnterHandler(new ItemEventHandler() {
            @Override
            public void onEvent(DataView view, TableItem record, JavaScriptObject htmlElement, int index,
                            EventObject event) {
                BaseModel model = record.getRaw();
                String text = model.get("text");
                currentBg = getImageResource(text);
                currentPreview.setSrc(currentBg);
            }
        });

        leftPanel.add(bgPanel);

        Panel currentImagePanel = new Panel(Layout.FIT);
        currentImagePanel.setHeight(200);
        currentImagePanel.setRegion(BorderRegion.SOUTH);
        currentImagePanel.add(currentPreview);
        leftPanel.add(currentImagePanel);

        return leftPanel;
    }

    private Panel getPreviewPanel() {
        prevPanel = new Panel("Preview");
        prevPanel.setRegion(BorderRegion.CENTER);
        prevPanel.setLayout(Layout.FIT);
        prevPanel.add(prevImage);
        return prevPanel;
    }

    private ImageResource getImageResource(String name) {
        if (name.equalsIgnoreCase("blue sencha")) {
            return Resources.WALLPAPERS.blueSencha();
        } else if (name.equalsIgnoreCase("wood sencha")) {
            return Resources.WALLPAPERS.woodSencha();
        } else if (name.equalsIgnoreCase("blue")) {
            return Resources.WALLPAPERS.blue();
        } else if (name.equalsIgnoreCase("desk")) {
            return Resources.WALLPAPERS.desk();
        } else if (name.equalsIgnoreCase("desktop")) {
            return Resources.WALLPAPERS.desktop();
        } else if (name.equalsIgnoreCase("desktop2")) {
            return Resources.WALLPAPERS.desktop2();
        } else if (name.equalsIgnoreCase("sky")) {
            return Resources.WALLPAPERS.sky();
        } else if (name.equalsIgnoreCase("bmw")) {
            return Resources.WALLPAPERS.bmw();
        } else if (name.equalsIgnoreCase("stone")) {
            return Resources.WALLPAPERS.stone();
        } else if (name.equalsIgnoreCase("toy")) {
            return Resources.WALLPAPERS.dummy();
        } else if (name.equalsIgnoreCase("leopard")) {
            return Resources.WALLPAPERS.leopard();
        } else if (name.equalsIgnoreCase("sahara")) {
            return Resources.WALLPAPERS.sahara();
        } else if (name.equalsIgnoreCase("standalone")) {
            return Resources.WALLPAPERS.standalone();
        } else if (name.equalsIgnoreCase("stonehenge")) {
            return Resources.WALLPAPERS.stonehenge();
        } else if (name.equalsIgnoreCase("water")) {
            return Resources.WALLPAPERS.water();
        }
        return Resources.WALLPAPERS.dummy();

    }
}
