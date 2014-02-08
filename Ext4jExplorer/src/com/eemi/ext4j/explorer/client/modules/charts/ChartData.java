package com.eemi.ext4j.explorer.client.modules.charts;

import java.util.ArrayList;
import java.util.List;

import com.eemi.ext4j.client.data.BeanModel;
import com.eemi.ext4j.client.data.ModelLocator;

public class ChartData {

    private int id;
    private int data1;
    private int data2;
    private int data3;
    private int data4;
    private int data5;
    private int data6;
    private int data7;
    private int data8;
    private int data9;
    private String name;
    private static double seed = 1.3;

    private static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "Novemver", "December" };

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the data1
     */
    public int getData1() {
        return data1;
    }

    /**
     * @param data1
     *            the data1 to set
     */
    public void setData1(int data1) {
        this.data1 = data1;
    }

    /**
     * @return the data2
     */
    public int getData2() {
        return data2;
    }

    /**
     * @param data2
     *            the data2 to set
     */
    public void setData2(int data2) {
        this.data2 = data2;
    }

    /**
     * @return the data3
     */
    public int getData3() {
        return data3;
    }

    /**
     * @param data3
     *            the data3 to set
     */
    public void setData3(int data3) {
        this.data3 = data3;
    }

    /**
     * @return the data4
     */
    public int getData4() {
        return data4;
    }

    /**
     * @param data4
     *            the data4 to set
     */
    public void setData4(int data4) {
        this.data4 = data4;
    }

    /**
     * @return the data5
     */
    public int getData5() {
        return data5;
    }

    /**
     * @param data5
     *            the data5 to set
     */
    public void setData5(int data5) {
        this.data5 = data5;
    }

    /**
     * @return the data6
     */
    public int getData6() {
        return data6;
    }

    /**
     * @param data6
     *            the data6 to set
     */
    public void setData6(int data6) {
        this.data6 = data6;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public static List<BeanModel> generateData(int count) {

        ChartData value = new ChartData();
        List<ChartData> data = new ArrayList<ChartData>();

        for (int i = 1; i < count; i++) {
            ChartData v = new ChartData();
            v.setId(i);

            v.setData1((int) (Math.abs(value.data1 + 300 * random() - 140)));
            v.setData2((int) (Math.abs(value.data2 + 300 * random() - 140)));
            v.setData3((int) (Math.abs(value.data3 + 300 * random() - 140)));
            v.setData4((int) (Math.abs(value.data4 + 300 * random() - 140)));
            v.setData5((int) (Math.abs(value.data5 + 300 * random() - 140)));
            v.setData6((int) (Math.abs(value.data6 + 300 * random() - 140)));
            v.setData7((int) (Math.abs(value.data7 + 300 * random() - 140)));
            v.setData8((int) (Math.abs(value.data8 + 300 * random() - 140)));
            v.setData9((int) (Math.abs(value.data9 + 300 * random() - 140)));

            v.setName(months[i % 12]);
            data.add(v);
        }

        List<BeanModel> toReturn = ModelLocator.locate(ChartData.class).createModel(data);
        return toReturn;

    }

    private static double random() {
        seed *= 7.3;
        seed -= Math.floor(seed);
        return seed;
    }

    /**
     * @return the data7
     */
    public int getData7() {
        return data7;
    }

    /**
     * @param data7
     *            the data7 to set
     */
    public void setData7(int data7) {
        this.data7 = data7;
    }

    /**
     * @return the data8
     */
    public int getData8() {
        return data8;
    }

    /**
     * @param data8
     *            the data8 to set
     */
    public void setData8(int data8) {
        this.data8 = data8;
    }

    /**
     * @return the data9
     */
    public int getData9() {
        return data9;
    }

    /**
     * @param data9
     *            the data9 to set
     */
    public void setData9(int data9) {
        this.data9 = data9;
    }

}
