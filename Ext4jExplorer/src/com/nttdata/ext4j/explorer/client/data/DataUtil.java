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
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.nttdata.ext4j.client.data.BaseModel;
import com.nttdata.ext4j.client.data.JsonStore;

public class DataUtil {

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

    public static List<Company> getCompanyList() {
        return Company.getList();
    }

    public static class Company extends BaseModel {
        public static final String COMPANY_NAME = "company";
        public static final String PRICE = "price";
        public static final String CHANGE = "change";
        public static final String CHANGE_IN_PERCENT = "pctChange";
        public static final String LAST_UPDATE = "lastChange";
        public static final String ID = "id";
        public static final String VISIBLE = "visible";

        public Company(String name, double price, double change, double percentChange, String lastChange) {
            this.set(COMPANY_NAME, name);
            this.set(PRICE, price);
            this.set(CHANGE, change);
            this.set(CHANGE_IN_PERCENT, percentChange);
            this.set(LAST_UPDATE, lastChange);
        }

        public static List<Company> getList() {
            List<Company> list = new ArrayList<DataUtil.Company>();
            list.add(new Company("3m Co", 71.72, 0.02, 0.03, "9/1/2013"));
            list.add(new Company("Alcoa Inc", 29.01, 0.42, 1.47, "9/1/2013"));
            list.add(new Company("Altria Group Inc", 83.81, 0.28, 0.34, "9/1/2013"));
            list.add(new Company("American Express Company", 52.55, 0.01, 0.02, "9/1/2013"));
            list.add(new Company("American International Group, Inc.", 64.13, 0.31, 0.49, "9/1/2013"));
            list.add(new Company("AT&T Inc.", 31.61, -0.48, -1.54, "9/1/2013"));
            list.add(new Company("Boeing Co.", 75.43, 0.53, 0.71, "9/1/2013"));
            list.add(new Company("Caterpillar Inc.", 67.27, 0.92, 1.39, "9/1/2013"));
            list.add(new Company("Citigroup, Inc.", 49.37, 0.02, 0.04, "9/1/2013"));
            list.add(new Company("E.I. du Pont de Nemours and Company", 40.48, 0.51, 1.28, "9/1/2013"));
            list.add(new Company("Exxon Mobil Corp", 68.1, -0.43, -0.64, "9/1/2013"));
            list.add(new Company("General Electric Company", 34.14, -0.08, -0.23, "9/1/2013"));
            list.add(new Company("General Motors Corporation", 30.27, 1.09, 3.74, "9/1/2013"));
            list.add(new Company("Hewlett-Packard Co.", 36.53, -0.03, -0.08, "9/1/2013"));
            list.add(new Company("Honeywell Intl Inc", 38.77, 0.05, 0.13, "9/1/2013"));
            list.add(new Company("Intel Corporation", 19.88, 0.31, 1.58, "9/1/2013"));
            list.add(new Company("International Business Machines", 81.41, 0.44, 0.54, "9/1/2013"));
            list.add(new Company("Johnson & Johnson", 64.72, 0.06, 0.09, "9/1/2013"));
            list.add(new Company("JP Morgan & Chase & Co", 45.73, 0.07, 0.15, "9/1/2013"));
            list.add(new Company("McDonald\"s Corporation", 36.76, 0.86, 2.40, "9/1/2013"));
            list.add(new Company("Merck & Co., Inc.", 40.96, 0.41, 1.01, "9/1/2013"));
            list.add(new Company("Microsoft Corporation", 25.84, 0.14, 0.54, "9/1/2013"));
            list.add(new Company("Pfizer Inc", 27.96, 0.4, 1.45, "9/1/2013"));
            list.add(new Company("The Coca-Cola Company", 45.07, 0.26, 0.58, "9/1/2013"));
            list.add(new Company("The Home Depot, Inc.", 34.64, 0.35, 1.02, "9/1/2013"));
            list.add(new Company("The Procter & Gamble Company", 61.91, 0.01, 0.02, "9/1/2013"));
            list.add(new Company("United Technologies Corporation", 63.26, 0.55, 0.88, "9/1/2013"));
            list.add(new Company("Verizon Communications", 35.57, 0.39, 1.11, "9/1/2013"));
            list.add(new Company("Wal-Mart Stores, Inc.", 45.45, 0.73, 1.63, "9/1/2013"));

            int id = 1;
            for (Company c : list) {
                c.set(ID, id);
                if (id % 2 == 0) {
                    c.set(VISIBLE, true);
                } else {
                    c.set(VISIBLE, false);
                }
                id++;
            }

            return list;

        }

    }

}
