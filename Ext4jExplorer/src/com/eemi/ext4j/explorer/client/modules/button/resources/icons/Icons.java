package com.eemi.ext4j.explorer.client.modules.button.resources.icons;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Icons extends ClientBundle {

    public static final Icons INSTANCE = GWT.create(Icons.class);

    @Source("button128.png")
    public ImageResource getIcon128();

    @Source("button16.png")
    public ImageResource getIcon16();

    @Source("button24.png")
    public ImageResource getIcon24();

    public ImageResource source();

}
