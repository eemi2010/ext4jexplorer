package com.eemi.ext4j.explorer.client.modules.combinations;

import com.eemi.ext4j.client.core.config.Position;
import com.eemi.ext4j.client.events.button.ClickEvent;
import com.eemi.ext4j.client.events.button.ClickHandler;
import com.eemi.ext4j.client.events.menu.ItemClickEvent;
import com.eemi.ext4j.client.events.menu.ItemClickHandler;
import com.eemi.ext4j.client.fx.easing.Easing;
import com.eemi.ext4j.client.laf.Alignment;
import com.eemi.ext4j.client.layout.Layout;
import com.eemi.ext4j.client.ui.Button;
import com.eemi.ext4j.client.ui.Menu;
import com.eemi.ext4j.client.ui.MenuItem;
import com.eemi.ext4j.client.ui.ToolBar;
import com.eemi.ext4j.explorer.client.modules.base.BaseDemoModule;
import com.eemi.ext4j.explorer.client.modules.combinations.resources.CombinationModulesResources;
import com.eemi.ext4j.ux.gmaps.client.GMapPanel;
import com.eemi.ext4j.ux.gmaps.client.GMapPanel.MapReadyHandler;
import com.eemi.ext4j.ux.notification.client.Notification;
import com.eemi.ext4j.webdesktop.client.core.DesktopModuleConfig;
import com.eemi.ext4j.webdesktop.client.ui.modules.DesktopModuleWindow;
import com.emitrom.pilot.maps.client.GMap;
import com.emitrom.pilot.maps.client.base.LatLng;
import com.emitrom.pilot.maps.client.core.MapTypeId;
import com.emitrom.pilot.maps.client.overlays.InfoWindow;
import com.emitrom.pilot.maps.client.overlays.Marker;

public class MapsModule extends BaseDemoModule {

    private final String MODULE_TITLE = "Maps";
    private ItemClickHandler itemClickHandler;
    private GMap googleMap;
    private GMapPanel panel;

    public static final MapsModule INSTANCE = new MapsModule();

    private MapsModule() {
        GMapPanel.injectPlugin();
        Notification.injectPlugin();

        itemClickHandler = new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                googleMap.setMapType(MapTypeId.fromValue(event.getSource().getText().toUpperCase()));
            }
        };
    }

    @Override
    public DesktopModuleConfig createModuleConfig() {
        DesktopModuleConfig moduleConfig = super.createModuleConfig();
        moduleConfig.setModuleTitle(MODULE_TITLE);
        moduleConfig.setModuleDescription("Ext4j Google Maps Integration");
        moduleConfig.setMutltiple(false);
        moduleConfig.setWallPaperIcon(CombinationModulesResources.ICONS.map128());
        moduleConfig.setToolbarIcon(CombinationModulesResources.ICONS.map24());
        moduleConfig.setMenuItemIcon(CombinationModulesResources.ICONS.map16());
        return moduleConfig;
    }

    @Override
    public DesktopModuleWindow createModuleWindow() {

        DesktopModuleWindow win = super.createModuleWindow();
        win.setLayout(Layout.FIT);

        panel = new GMapPanel("Google Maps");
        panel.setTitleAlign(Position.CENTER);

        ToolBar toolBar = new ToolBar();
        Button currentLocation = new Button("Donut", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                new Notification().setAutoCloseDelay(3000).setSlideInAnimation(Easing.ELASTIC_IN).setPosition("t")
                                .setTitle("Current Location").setClosable(false)
                                .setIconCls("ux-notification-icon-information").setCls("ux-notification-light")
                                .setMessage("Not yet implemented").show();

            }
        });

        currentLocation.setCls("x-btn-default-small");
        toolBar.add(currentLocation);

        Button menuButton = new Button("Map Type");
        menuButton.setCls("x-btn-default-small");

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Terrain", itemClickHandler));
        menu.addItem(new MenuItem("Hybrid", itemClickHandler));
        menu.addItem(new MenuItem("Satellite", itemClickHandler));
        menu.addItem(new MenuItem("Roadmap", itemClickHandler));

        menuButton.setArrowAlign(Alignment.LEFT);
        menuButton.setMenu(menu);
        toolBar.add(menuButton);

        panel.addDocked(toolBar);
        panel.addMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onReady() {
                googleMap = new GMap(panel.getMap());

                LatLng position = googleMap.getCenter();
                Marker marker = new Marker(googleMap, position);

                InfoWindow info = new InfoWindow();
                info.setContent("<b>Ext4j and Google Maps for the win !</b><br/>");
                info.open(googleMap, marker);
            }
        });
        win.add(panel);

        return win;
    }
}
