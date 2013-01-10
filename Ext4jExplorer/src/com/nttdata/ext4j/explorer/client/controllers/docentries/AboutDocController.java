package com.nttdata.ext4j.explorer.client.controllers.docentries;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDocController;
import com.nttdata.ext4j.explorer.client.ui.docentries.AboutDocEntry;
import com.nttdata.ext4j.explorer.client.ui.docentries.DocEntryBase;

public class AboutDocController extends AbstractDocController {

    private static final AboutDocController INSTANCE = new AboutDocController();

    public static AboutDocController get() {
        return INSTANCE;
    }

    private AboutDocController() {

    }

    @Override
    public DocEntryBase getDocEntry() {
        return new AboutDocEntry();
    }

}
