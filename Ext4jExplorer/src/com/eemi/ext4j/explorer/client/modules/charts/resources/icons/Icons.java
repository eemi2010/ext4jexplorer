package com.eemi.ext4j.explorer.client.modules.charts.resources.icons;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Icons extends ClientBundle {

    public static final Icons INSTANCE = GWT.create(Icons.class);

    @Source("area128.png")
    public ImageResource getIcon128();

    @Source("area16.png")
    public ImageResource getIcon16();

    @Source("area24.png")
    public ImageResource getIcon24();

    public ImageResource bar128();

    public ImageResource bar24();

    public ImageResource bar16();

    public ImageResource customBar128();

    public ImageResource customBar24();

    public ImageResource customBar16();

    public ImageResource custom128();

    public ImageResource custom24();

    public ImageResource custom16();

    public ImageResource pie128();

    public ImageResource pie24();

    public ImageResource pie16();

}
