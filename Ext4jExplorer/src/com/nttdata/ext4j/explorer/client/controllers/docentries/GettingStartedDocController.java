package com.nttdata.ext4j.explorer.client.controllers.docentries;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDocController;
import com.nttdata.ext4j.explorer.client.ui.docentries.DocEntryBase;
import com.nttdata.ext4j.explorer.client.ui.docentries.GettingStartedDocEntry;

public class GettingStartedDocController extends AbstractDocController {

    private static final GettingStartedDocController INSTANCE = new GettingStartedDocController();

    public static GettingStartedDocController get() {
        return INSTANCE;
    }

    private GettingStartedDocController() {

    }

    @Override
    public DocEntryBase getDocEntry() {
        return new GettingStartedDocEntry();
    }

}
