package com.nttdata.ext4j.explorer.client.controllers.docentries;

import com.nttdata.ext4j.explorer.client.controllers.AbstractDocController;
import com.nttdata.ext4j.explorer.client.ui.docentries.DocEntryBase;
import com.nttdata.ext4j.explorer.client.ui.docentries.RequirementsDocEntry;

public class RequirementsDocController extends AbstractDocController {

    private static final RequirementsDocController INSTANCE = new RequirementsDocController();

    public static RequirementsDocController get() {
        return INSTANCE;
    }

    private RequirementsDocController() {

    }

    @Override
    public DocEntryBase getDocEntry() {
        return new RequirementsDocEntry();
    }

}
