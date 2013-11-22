package com.eemi.ext4j.explorer.client.modules.gettingstarted.resources.icons;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Icons extends ClientBundle {

    public static final Icons INSTANCE = GWT.create(Icons.class);

    @Source("started128.png")
    public ImageResource getIcon128();

    @Source("started16.png")
    public ImageResource getIcon16();

    @Source("started24.png")
    public ImageResource getIcon24();

}
