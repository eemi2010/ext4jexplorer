/*******************************************************************************
 * This file is part of Gwt4Titanium Mobile
 * 
 * Copyright (c) 2011 Alain Ekambi. All rights reserved.
 * 
 * Gwt4Titanium Mobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package com.nttdata.ext4j.explorer.client.ui.app;

import com.nttdata.ext4j.explorer.client.core.Constants;
import com.nttdata.gwt4ext.client.layout.BorderRegion;
import com.nttdata.gwt4ext.client.ui.BoxComponent;

/**
 * Implements the header of the application.
 * 
 * @author alainekambi
 * 
 */
public class Header extends BoxComponent {
    private static final Header INSTANCE = new Header();

    public static Header get() {
        return INSTANCE;
    }

    private Header() {
        this.setId(Constants.APP_HEADER_ID);
        this.setRegion(BorderRegion.NORTH);
        this.setHeight(40);
        this.setHtml(Constants.APP_TITLE);
    }

}
