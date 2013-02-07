package com.nttdata.ext4j.explorer.client.ui.demos.combination;

import com.emitrom.pilot.maps.client.GMap;
import com.emitrom.pilot.maps.client.base.LatLng;
import com.emitrom.pilot.maps.client.core.MapTypeId;
import com.emitrom.pilot.maps.client.overlays.InfoWindow;
import com.emitrom.pilot.maps.client.overlays.Marker;
import com.nttdata.ext4j.client.core.EventObject;
import com.nttdata.ext4j.client.core.config.Position;
import com.nttdata.ext4j.client.events.handlers.button.InteractionHandler;
import com.nttdata.ext4j.client.events.handlers.menu.item.ItemClickHandler;
import com.nttdata.ext4j.client.fx.easing.Easing;
import com.nttdata.ext4j.client.layout.Layout;
import com.nttdata.ext4j.client.ui.Button;
import com.nttdata.ext4j.client.ui.Menu;
import com.nttdata.ext4j.client.ui.MenuItem;
import com.nttdata.ext4j.client.ui.ToolBar;
import com.nttdata.ext4j.explorer.client.ui.demos.DemoBase;
import com.nttdata.ext4j.ux.gmaps.client.GMapPanel;
import com.nttdata.ext4j.ux.gmaps.client.GMapPanel.MapReadyHandler;
import com.nttdata.ext4j.ux.notification.client.Notification;

public class GoogleMapDemo extends DemoBase {

    public static final String TITLE = "Maps";

    private ItemClickHandler itemClickHandler;
    private GMap googleMap;
    private GMapPanel panel;

    public static GoogleMapDemo get() {
        return new GoogleMapDemo();
    }

    private GoogleMapDemo() {

        itemClickHandler = new ItemClickHandler() {
            @Override
            public void onEvent(MenuItem item, EventObject event) {
                googleMap.setMapType(MapTypeId.fromValue(item.getText().toUpperCase()));
            }
        };
        panel = new GMapPanel("Google Maps");
        panel.setTitleAlign(Position.CENTER);

        ToolBar toolBar = new ToolBar();
        toolBar.add(new Button("Get current location", new InteractionHandler() {
            @Override
            public void onEvent(Button button, EventObject event) {
                new Notification().setAutoCloseDelay(3000).setSlideInAnimation(Easing.ELASTIC_IN).setPosition("t")
                                .setTitle("Button Click").setClosable(false)
                                .setIconCls("ux-notification-icon-information").setCls("ux-notification-light")
                                .setMessage("Not yet implemented").show();
            }
        }));

        Button menuButton = new Button("Map Type");

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Terrain", itemClickHandler));
        menu.addItem(new MenuItem("Hybrid", itemClickHandler));
        menu.addItem(new MenuItem("Satellite", itemClickHandler));
        menu.addItem(new MenuItem("Roadmap", itemClickHandler));

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
                info.setContent("Ext4j and Google Maps for the win !");
                info.open(googleMap, marker);
            }
        });

        demoPanel.setLayout(Layout.FIT);
        demoPanel.add(panel);

    }

    @Override
    public String getDemoTitle() {
        return TITLE;
    }

}
