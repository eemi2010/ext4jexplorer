package com.eemi.ext4j.explorer.client.modules.senchadocs;

import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.explorer.client.modules.senchadocs.resources.SenchaDocsResources;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModule;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Frame;

public class SenchaDocsModule extends DesktopModule {

    private final String MODULE_TITLE = "Sencha Docs";
    private final String EXT_DOC_LINK = "http://docs.sencha.com/extjs/4.2.2/";

    public static final SenchaDocsModule INSTANCE = new SenchaDocsModule();

    private SenchaDocsModule() {

    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Official Sencha Documentation");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(SenchaDocsResources.ICONS.getIcon128());
        moduleConfig.setToolbarIcon(SenchaDocsResources.ICONS.getIcon24());
        moduleConfig.setMenuItemIcon(SenchaDocsResources.ICONS.getIcon16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {
        DesktopModuleWindow win = super.createModuleWindow();
        win.setSize(1200, 600);
        win.setLayout(Layout.FIT);

        Frame frame = new Frame(EXT_DOC_LINK);
        frame.getElement().getStyle().setBorderWidth(0, Unit.PX);
        win.add(frame);

        return win;
    }

}
