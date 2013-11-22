package com.eemi.ext4j.explorer.client.modules.grids.resources.icons;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Icons extends ClientBundle {

    public static final Icons INSTANCE = GWT.create(Icons.class);

    public ImageResource grid128();

    public ImageResource grid24();

    public ImageResource grid16();

    public ImageResource simpleGrid128();

    public ImageResource simpleGrid24();

    public ImageResource simpleGrid16();

    public ImageResource lockedGrid128();

    public ImageResource lockedGrid24();

    public ImageResource lockedGrid16();

    public ImageResource gridRowEdit128();

    public ImageResource gridRowEdit24();

    public ImageResource gridRowEdit16();

}
