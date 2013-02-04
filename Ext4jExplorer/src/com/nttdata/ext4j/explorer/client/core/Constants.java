package com.nttdata.ext4j.explorer.client.core;

/**
 * Contains application wide constants.
 * 
 * @author alainekambi
 * 
 */
public class Constants {

    public static final String APP_TITLE = "NTT DATA - Ext 4 Java Documentation and Examples";
    public static final String APP_HEADER_ID = "app-header";
    public static final String EXT4J_KS = "http://ext4j.appspot.com/";
    public static final String EXT4J = "Ext4j";
    public static final String DOC_ENTRY = "Doc Entry";
    public static final String EXT4J_CURRENT_VERSION = "4-1";
    public static final String EXT4J_DOCS_LINK = "http://docs.sencha.com/ext-js/" + EXT4J_CURRENT_VERSION + "/";

    private Constants() {

    }

    public static String getShortBogusMarkup() {
        return "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui.  In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna.";
    }
}
