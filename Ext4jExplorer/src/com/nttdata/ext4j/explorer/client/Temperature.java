package com.nttdata.ext4j.explorer.client;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.ext4j.client.data.BaseModel;

public class Temperature extends BaseModel {

    public static final String TEMP = "temperature";
    public static final String TIME = "time";

    Temperature(int temperature, int time) {
        this.set(TEMP, temperature);
        this.set(TIME, time);
    }

    public static List<Temperature> getValues() {
        List<Temperature> v = new ArrayList<Temperature>();
        v.add(new Temperature(58, 10));
        v.add(new Temperature(63, 20));
        v.add(new Temperature(73, 30));
        v.add(new Temperature(78, 40));
        v.add(new Temperature(81, 80));
        v.add(new Temperature(90, 90));
        v.add(new Temperature(100, 100));
        return v;
    }
}
