/**
 * Copyright (c) 2012 Emitrom LLC. All rights reserved. For licensing questions,
 * please contact us at licensing@emitrom.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.emitrom.pilot.maps.client.core;

public enum MapTypeId {

    ROADMAP("ROADMAP"), HYBRID("HYBRID"), TERRAIN("TERRAIN"), SATELLITE("SATELLITE");

    private String value;

    public String getValue() {
        return value;
    }

    private MapTypeId(String id) {
        value = createPeer(id);
    }

    private static native String createPeer(String id) /*-{
		return $wnd.google.maps.MapTypeId[id];
    }-*/;

    public static native MapTypeId fromValue(String value) /*-{
		switch (value) {
		case 'ROADMAP':
			return @com.emitrom.pilot.maps.client.core.MapTypeId::ROADMAP;

		case 'HYBRID':
			return @com.emitrom.pilot.maps.client.core.MapTypeId::HYBRID;

		case 'TERRAIN':
			return @com.emitrom.pilot.maps.client.core.MapTypeId::TERRAIN;

		case 'SATELLITE':
			return @com.emitrom.pilot.maps.client.core.MapTypeId::SATELLITE;
		}
    }-*/;

}
