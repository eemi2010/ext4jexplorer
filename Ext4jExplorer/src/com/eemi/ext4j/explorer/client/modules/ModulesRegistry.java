package com.eemi.ext4j.explorer.client.modules;

import com.eemi.ext4j.explorer.client.Ext4jExplorer;
import com.eemi.ext4j.explorer.client.modules.about.AboutExt4jModule;
import com.eemi.ext4j.explorer.client.modules.button.ButtonModule;
import com.eemi.ext4j.explorer.client.modules.charts.AreaChartModule;
import com.eemi.ext4j.explorer.client.modules.charts.BarChartModule;
import com.eemi.ext4j.explorer.client.modules.charts.CustomBarChartModule;
import com.eemi.ext4j.explorer.client.modules.charts.MixedSeriesChartModule;
import com.eemi.ext4j.explorer.client.modules.charts.PieChartModule;
import com.eemi.ext4j.explorer.client.modules.combinations.ChartExportModule;
import com.eemi.ext4j.explorer.client.modules.combinations.ClientIOModule;
import com.eemi.ext4j.explorer.client.modules.combinations.GridExportModule;
import com.eemi.ext4j.explorer.client.modules.combinations.MapsModule;
import com.eemi.ext4j.explorer.client.modules.combinations.MessageBoxModule;
import com.eemi.ext4j.explorer.client.modules.combinations.PortalModule;
import com.eemi.ext4j.explorer.client.modules.gettingstarted.GettingStartedModule;
import com.eemi.ext4j.explorer.client.modules.grids.GridCellEditingModule;
import com.eemi.ext4j.explorer.client.modules.grids.GridRowEditingModule;
import com.eemi.ext4j.explorer.client.modules.grids.LockedGridModule;
import com.eemi.ext4j.explorer.client.modules.grids.SimpleGridModule;
import com.eemi.ext4j.explorer.client.modules.senchadocs.SenchaDocsModule;
import com.eemi.ext4j.webdesktop.client.modules.settings.SettingsModule;
import com.eemi.ext4j.webdesktop.client.ui.Desktop;
import com.google.gwt.user.client.Timer;

/**
 * Utility class to ass module on the Desktop
 */
public class ModulesRegistry {

    private ModulesRegistry() {

    }

    public static void loadModules() {
        Desktop.get().addModule(AboutExt4jModule.INSTANCE);
        Desktop.get().addModule(GettingStartedModule.INSTANCE);
        Desktop.get().addModule(SenchaDocsModule.INSTANCE);
        Desktop.get().addModule(ButtonModule.INSTANCE);
        Desktop.get().addModule(AreaChartModule.INSTANCE);
        Desktop.get().addModule(PieChartModule.INSTANCE);
        Desktop.get().addModule(BarChartModule.INSTANCE);
        Desktop.get().addModule(SimpleGridModule.INSTANCE);
        Desktop.get().addModule(GridRowEditingModule.INSTANCE);
        Desktop.get().addModule(LockedGridModule.INSTANCE);
        Desktop.get().addModule(CustomBarChartModule.INSTANCE);
        Desktop.get().addModule(GridCellEditingModule.INSTANCE);
        Desktop.get().addModule(MixedSeriesChartModule.INSTANCE);
        Desktop.get().addModule(PortalModule.INSTANCE);
        Desktop.get().addModule(MapsModule.INSTANCE);
        Desktop.get().addModule(GridExportModule.INSTANCE);
        Desktop.get().addModule(ChartExportModule.INSTANCE);
        Desktop.get().addModule(MessageBoxModule.INSTANCE);
        Desktop.get().addModule(ClientIOModule.INSTANCE);
        Desktop.get().addModule(SettingsModule.get());

        lauchStartModule();

        // startTour();
    }

    private static void lauchStartModule() {
        new Timer() {
            @Override
            public void run() {
                if (Ext4jExplorer.START_MODULE.equalsIgnoreCase("gridexport")) {
                    GridExportModule.INSTANCE.launchModule();
                } else if (Ext4jExplorer.START_MODULE.equalsIgnoreCase("chartexport")) {
                    ChartExportModule.INSTANCE.launchModule();
                } else if (Ext4jExplorer.START_MODULE.equalsIgnoreCase("gettingstarted")) {
                    GettingStartedModule.INSTANCE.launchModule();
                }
            }
        }.schedule(500);
    }

    /*
     * private static void startTour() { Tour tour = new Tour("ext4j-tour"); //
     * tour.setScrollTopMargin(100); tour.setShowPrevButton(true);
     * 
     * TourStep step = new TourStep(Placement.RIGHT,
     * AboutExt4jModule.INSTANCE.getShortCut());
     * step.setTitle("About the Ext4j Project !"); step.setContent(
     * "Before getting started read about the idea behind the Ext4j project and the <b>problems we are trying to solve.</b>Double click on this module."
     * ); // step.centerXOffset(); // step.centerArrowOffset(); //
     * step.setMultiPage(true); tour.addStep(step);
     * 
     * step = new TourStep(Placement.RIGHT,
     * GettingStartedModule.INSTANCE.getShortCut());
     * step.setTitle("Getting started with Ext4j."); step.setContent(
     * "Now that you know why we created Ext4j, read how to <b>get started with the library</b>. This guide will show you all the components you need to run the framework and <b>walk you through</b> a <b>simple 'Hello World'</b> example."
     * ); tour.addStep(step);
     * 
     * step = new TourStep(Placement.RIGHT,
     * SenchaDocsModule.INSTANCE.getShortCut());
     * step.setTitle("Official Sencha Documentation."); step.setContent(
     * "Ext4j is based on <b>Ext JS</b>. So the <b>official Sencha Documentation</b> is an unvaluable resource. Whenever you need to read the official documentation you click on this module."
     * ); tour.addStep(step);
     * 
     * step = new TourStep(Placement.RIGHT,
     * ButtonModule.INSTANCE.getShortCut()); step.setTitle("Ext4j Demos");
     * step.setContent(
     * "Starting with this module we have implemented a lot of demos to illustrate how to work with the framework. Make sure you click on the <b>Source Button</b> to see the source code for each demo."
     * ); tour.addStep(step);
     * 
     * step = new TourStep(Placement.RIGHT, SettingsModule.get().getShortCut());
     * step.setTitle("Customize your experience"); step.setContent(
     * "Here you have the opportunity to configure your user experience. Enjoy the Ext4j library."
     * ); tour.addStep(step);
     * 
     * GwtTour.startTour(tour); }
     */
}
