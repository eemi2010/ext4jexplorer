package com.eemi.ext4j.explorer.client.modules.combinations;

import com.eemi.ext4j.client.core.config.Dock;
import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.events.menu.ItemClickEvent;
import com.eemi.ext4j.client.events.menu.ItemClickHandler;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.HtmlEditor;
import com.eemi.ext4j.client.ui.Menu;
import com.eemi.ext4j.client.ui.MenuItem;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.combinations.resources.CombinationModulesResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.emitrom.flash4j.alivepdf.client.colors.RGBColor;
import com.emitrom.flash4j.alivepdf.client.fonts.CoreFont;
import com.emitrom.flash4j.alivepdf.client.pdf.PDF;
import com.emitrom.flash4j.clientio.client.ClientIO;
import com.emitrom.flash4j.core.client.events.Event;
import com.emitrom.flash4j.core.client.events.handlers.EventHandler;
import com.emitrom.flash4j.core.client.net.FileFilter;
import com.emitrom.flash4j.core.client.net.FileReference;
import com.emitrom.flash4j.core.client.utils.ByteArray;
import com.google.gwt.user.client.Timer;

public class ClientIOModule extends BaseDemoModule {

    private final String MODULE_TITLE = "Clientside IO";
    private HtmlEditor editor;
    private DesktopModuleWindow window;

    public static final ClientIOModule INSTANCE = new ClientIOModule();

    private ClientIOModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Read and Write files on the client");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(CombinationModulesResources.ICONS.io128());
        moduleConfig.setToolbarIcon(CombinationModulesResources.ICONS.io24());
        moduleConfig.setMenuItemIcon(CombinationModulesResources.ICONS.io16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        window = super.createModuleWindow();
        sourceButton.setDisabled(true);

        window.setSize(1200, 600);
        window.setLayout(Layout.FIT);

        ToolBar tb = new ToolBar();
        tb.setDocked(Dock.TOP);
        window.addDocked(tb);

        editor = new HtmlEditor();
        window.add(editor);

        Button saveButton = new Button("Save as...");
        saveButton.setCls("x-btn-default-small");

        ItemClickHandler handler = new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                String saveFormat = event.getSource().getText();
                saveFile(saveFormat);
            }
        };

        Menu menu = new Menu();
        menu.addItem(new MenuItem("PDF", handler));
        menu.addItem(new MenuItem("Text", handler));
        menu.addItem(new MenuItem("HTML", handler));
        saveButton.setMenu(menu);

        tb.add(saveButton);

        Button importButton = new Button("Import...");
        importButton.setCls("x-btn-default-small");
        importButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                readFile();
            }
        });
        tb.add(importButton);

        return window;
    }

    private void saveFile(String format) {
        if (format.equalsIgnoreCase("pdf")) {
            saveToPDF();
        }

        else if (format.equalsIgnoreCase("text")) {
            saveToText();
        } else if (format.equalsIgnoreCase("html")) {
            saveToHtml();
        }
    }

    private void saveToPDF() {
        window.getEl().mask("Generating file ...");
        new Timer() {
            @Override
            public void run() {
                PDF pdf = new PDF();
                pdf.addPage();
                pdf.setTextStyle(new RGBColor(0x000000));
                pdf.setFont(new CoreFont(), 10);
                pdf.addText(editor.getValue());
                ClientIO.saveFile(pdf.save(), "file.pdf");

            }
        }.schedule(1500);

    }

    private void saveToText() {
        window.getEl().mask("Generating file ...");
        new Timer() {
            @Override
            public void run() {
                ClientIO.saveFile(editor.getValue(), "file.txt");

            }
        }.schedule(1500);

    }

    private void saveToHtml() {
        window.getEl().mask("Generating file ...");
        new Timer() {
            @Override
            public void run() {
                ClientIO.saveFile(editor.getValue(), "file.html");

            }
        }.schedule(1500);

    }

    private void readFile() {
        final FileReference fileReference = ClientIO.browse(new FileFilter("Text File", ".txt"), new FileFilter(
                        "HTML File", ".html"));
        fileReference.addEventHandler(Event.SELECT, new EventHandler() {
            @Override
            public void onEvent(Event event) {
                fileReference.load();
                fileReference.addEventHandler(Event.COMPLETE, new EventHandler() {
                    @Override
                    public void onEvent(Event event) {
                        ByteArray data = fileReference.getData();
                        String content = data.readUTFBytes(data.getBytesAvailable());
                        editor.setValue(content);
                    }
                });
            }
        });
    }

}
