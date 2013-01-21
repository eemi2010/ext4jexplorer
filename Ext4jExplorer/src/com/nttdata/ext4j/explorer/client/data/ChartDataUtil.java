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
package com.nttdata.ext4j.explorer.client.data;

import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.nttdata.ext4j.client.data.JsonStore;

public class ChartDataUtil {

    public static native JavaScriptObject generateData(int n, int floor)/*-{
		var data = [], i;
		var months = [ 'January', 'February', 'March', 'April', 'May', 'June',
				'July', 'August', 'September', 'October', 'Novemver',
				'December' ];

		floor = (!floor && floor !== 0) ? 20 : floor;

		for (i = 0; i < n; i++) {
			data.push({
				name : months[i % 12],
				data1 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data2 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data3 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data4 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data5 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data6 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data7 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data8 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor)),
				data9 : $wnd.Math.floor($wnd.Math.max(
						($wnd.Math.random() * 100), floor))
			});
		}
		return data;
    }-*/;

    public static native JavaScriptObject generateDataNegative(int n, int floor)/*-{
		var data = [], p = ($wnd.Math.random() * 11) + 1, i;
		var months = [ 'January', 'February', 'March', 'April', 'May', 'June',
				'July', 'August', 'September', 'Novemver', 'December' ];

		floor = (!floor && floor !== 0) ? 20 : floor;

		for (i = 0; i < n; i++) {
			data.push({
				name : months[i % 12],
				data1 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data2 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data3 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data4 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data5 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data6 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data7 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data8 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor)),
				data9 : $wnd.Math.floor($wnd.Math.max(
						(($wnd.Math.random() - 0.5) * 100), floor))
			});
		}
		return data;
    }-*/;

    private static native JsArrayString getF()/*-{
		return [ 'name', 'data1', 'data2', 'data3', 'data4', 'data5', 'data6',
				'data7', 'data8', 'data9' ];
    }-*/;

    private static ArrayList<String> getFields() {
        ArrayList<String> fields = new ArrayList<String>();
        JsArrayString values = getF();
        for (int i = 0; i < values.length(); i++) {
            fields.add(values.get(i));
        }
        return fields;
    }

    public static JsonStore getStore() {
        return new JsonStore(generateData(6, 20), getF());
    }

    public static JsonStore getStore(int n, int floor) {
        return new JsonStore(generateData(n, floor), getF());
    }

    public static JsonStore getSoreNegative() {
        return new JsonStore(generateDataNegative(6, 20), getF());
    }

}
