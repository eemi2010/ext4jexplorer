package com.nttdata.ext4j.explorer.client;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.ext4j.client.data.BaseModel;

public class Temperature extends BaseModel {

    public static final String TEMP = "temperature";
    public static final String TIME = "time";

    Temperature(int temperature, int time) {
        this.set(TEMP, temperature);
        this.set(TIME, time);
    }

    public static List<Temperature> getValues() {
        List<Temperature> v = new ArrayList<Temperature>();
        v.add(new Temperature(58, 10));
        v.add(new Temperature(63, 20));
        v.add(new Temperature(73, 30));
        v.add(new Temperature(78, 40));
        v.add(new Temperature(81, 80));
        v.add(new Temperature(90, 90));
        v.add(new Temperature(100, 100));
        return v;
    }

    // // create a portal
    // Portal portal = new Portal();
    //
    // // create portal columns
    // PortalColumn firstCol = new PortalColumn();
    // firstCol.setPaddings(10, 10, 0, 10);
    //
    // // add portlets to portal columns
    // Portlet gridPortlet = new Portlet();
    // gridPortlet.setTitle("Grid in a Portlet");
    // gridPortlet.setLayout(new FitLayout());
    // gridPortlet.setHeight(300);
    //
    // final GMapPanel p = new GMapPanel();
    // p.addMapReadyHandler(new MapReadyHandler() {
    // @Override
    // public void onReady() {
    // GMap googleMap = new GMap(p.getMap());
    //
    // LatLng position = googleMap.getCenter();
    // Marker marker = new Marker(googleMap, position);
    // marker.setDraggable(true);
    //
    // InfoWindow info = new InfoWindow();
    // info.setContent("Ext4j and Emitrom's Pilot  for the win !");
    // info.open(googleMap, marker);
    // }
    // });
    //
    // gridPortlet.add(p);
    //
    // firstCol.add(gridPortlet);
    //
    // Portlet portlet = new Portlet("Another NotificationContainer 1", getShortBogusMarkup());
    // firstCol.add(portlet);
    //
    // // add portal column to portal
    // portal.add(firstCol, new ColumnLayoutData(.33));
    //
    // // another column
    // PortalColumn secondCol = new PortalColumn();
    // secondCol.setPaddings(10, 10, 0, 10);
    // secondCol.add(new Portlet("NotificationContainer 2", getShortBogusMarkup()));
    // secondCol.add(new Portlet("Another NotificationContainer 2", getShortBogusMarkup()));
    // portal.add(secondCol, new ColumnLayoutData(.33));
    //
    // // third column
    // PortalColumn thirdCol = new PortalColumn();
    // thirdCol.setPaddings(10, 10, 0, 10);
    // thirdCol.add(new Portlet("NotificationContainer 3", getShortBogusMarkup()));
    // thirdCol.add(new Portlet("Another NotificationContainer 3", getShortBogusMarkup()));
    // portal.add(thirdCol, new ColumnLayoutData(.33));
    //
    // Viewport.get(Layout.FIT).add(portal);
}
