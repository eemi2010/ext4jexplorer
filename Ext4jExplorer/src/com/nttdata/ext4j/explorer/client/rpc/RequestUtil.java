package com.nttdata.ext4j.explorer.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.nttdata.gwt4ext.client.ui.Panel;

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
