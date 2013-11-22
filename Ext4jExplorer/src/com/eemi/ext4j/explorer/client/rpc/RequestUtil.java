package com.eemi.ext4j.explorer.client.rpc;

import com.eemi.ext4j.client.core.Component;
import com.eemi.ext4j.client.events.handlers.component.EventHandler;
import com.eemi.ext4j.client.ui.Panel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

/**
 * Utility class for Ajax calls
 */
public class RequestUtil {

    private RequestUtil() {
    }

    private static String getFileUrl(String fileName) {
        String path = "content/ext4j/" + fileName.toLowerCase();
        return GWT.getHostPageBaseURL() + path;
    }

    public static void load(final String htmlFile, final Panel target) {
        target.addAfterRenderHandler(new EventHandler() {
            @Override
            public void onEvent(Component component) {
                target.getEl().mask("Loading content ...");
                loadContent(htmlFile, target);
            }
        });

    }

    public static void loadContent(String htmlFile, final Panel target) {
        htmlFile = htmlFile.replaceAll(" ", "_");
        if (htmlFile.indexOf("ext4j") < 0) {
            htmlFile = "ext4j_" + htmlFile;
        }
        RequestBuilder req = new RequestBuilder(RequestBuilder.GET, getFileUrl(htmlFile));
        try {
            req.sendRequest("", new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    String content = response.getText();
                    target.setHtml(content);
                    prettyPrint();
                    target.getEl().unmask();

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
