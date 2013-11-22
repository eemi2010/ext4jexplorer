package com.eemi.ext4j.explorer.client.resources.images;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Images extends ClientBundle {

    public static final Images INSTANCE = GWT.create(Images.class);

    public ImageResource gift();
}
