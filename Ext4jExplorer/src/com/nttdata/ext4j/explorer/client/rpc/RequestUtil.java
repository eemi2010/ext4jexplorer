package com.nttdata.ext4j.explorer.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.nttdata.ext4j.client.ui.Panel;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.AreaChartDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.BarChartDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.CustomBarChartDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.LineChartDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.MixedSeriesChartDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.charts.PieChartDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.combinationexamples.MapDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.combinationexamples.PortalDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.component.ButtonsDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.GridCellEditingDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.GridDataBindingDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.GridFilteringDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.GridRowEditingDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.GroupingGridDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.LockedGridDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.PagingGridDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.grid.SimpleGridDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AbsoluteLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AccordionLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.AnchorLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.BorderLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.CardLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.layouts.ColumnLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.tabs.AdvancedTabsDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.tabs.BasicTabsDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.tabs.TabScrollerMenuDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.windows.MessageBoxDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.windows.WindowLayoutDemoController;
import com.nttdata.ext4j.explorer.client.controllers.demos.windows.WindowsVariationDemoController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.AboutDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.GettingStartedDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.RequirementsDocController;
import com.nttdata.ext4j.explorer.client.controllers.docentries.SenchaDocsDocEntryController;

/**
 * Utility class for RPC calls
 * 
 * @author alainekambi
 * 
 */
public class RequestUtil {

    private RequestUtil() {
    }

    private static String getFileUrl(String fileName) {
        String path = "content/ext4j/" + fileName.toLowerCase();
        return GWT.getHostPageBaseURL() + path;
    }

    public static void loadContent(String htmlFile, final Panel target) {
        target.getEl().mask("Loading content ...");
        RequestBuilder req = new RequestBuilder(RequestBuilder.GET, getFileUrl(htmlFile));
        try {
            req.sendRequest("", new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    String content = response.getText();
                    target.setHtml(content);
                    prettyPrint();
                    target.getEl().unmask();
                    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                        @Override
                        public void execute() {

                            AboutDocController.get();
                            RequirementsDocController.get();
                            GettingStartedDocController.get();
                            SenchaDocsDocEntryController.get();

                            // Layouts
                            AbsoluteLayoutDemoController.get();
                            AccordionLayoutDemoController.get();
                            AnchorLayoutDemoController.get();
                            BorderLayoutDemoController.get();
                            CardLayoutDemoController.get();
                            ColumnLayoutDemoController.get();

                            // Components
                            ButtonsDemoController.get();
                            CustomBarChartDemoController.get();
                            MessageBoxDemoController.get();
                            PortalDemoController.get();
                            MapDemoController.get();
                            AreaChartDemoController.get();
                            BarChartDemoController.get();
                            LineChartDemoController.get();
                            PieChartDemoController.get();
                            MixedSeriesChartDemoController.get();
                            BasicTabsDemoController.get();
                            AdvancedTabsDemoController.get();
                            TabScrollerMenuDemoController.get();
                            WindowsVariationDemoController.get();
                            WindowLayoutDemoController.get();
                            SimpleGridDemoController.get();
                            PagingGridDemoController.get();
                            GroupingGridDemoController.get();
                            GridFilteringDemoController.get();
                            GridCellEditingDemoController.get();
                            GridDataBindingDemoController.get();
                            LockedGridDemoController.get();
                            GridRowEditingDemoController.get();

                        }
                    });
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    target.setHtml("No content found");
                    target.getEl().unmask();
                }
            });
        } catch (RequestException e) {
            Window.alert(e.getMessage());
        }
    }

    private static native void prettyPrint()/*-{
		$wnd.dp.SyntaxHighlighter.HighlightAll("code");
    }-*/;
}
