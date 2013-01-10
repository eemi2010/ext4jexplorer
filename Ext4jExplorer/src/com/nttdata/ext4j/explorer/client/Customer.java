package com.nttdata.ext4j.explorer.client;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.gwt4ext.client.data.BaseModel;

public class Customer extends BaseModel {

    public static final String NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String PHONE = "Phone";
    public static final String DEPARTMENT = "department";

    public Customer(String name, String email, String phone) {
        this.set(NAME, name);
        this.set(EMAIL, email);
        this.set(PHONE, phone);
    }

    public Customer(String name, String email, String phone, String dpt) {
        this.set(NAME, name);
        this.set(EMAIL, email);
        this.set(PHONE, phone);
        this.set(DEPARTMENT, dpt);
    }

    public void setName(String name) {
        this.set(Customer.NAME, name);
    }

    public static List<Customer> getValues() {
        List<Customer> v = new ArrayList<Customer>();
        v.add(new Customer("Marc", "marc@emitrom.com", "555-111-222", "IT"));
        v.add(new Customer("Alain", "alain@emitrom.com", "555-111-222", "Manamegement"));
        v.add(new Customer("Alfredo", "alfredo@emitrom.com", "555-111-222", "Sales"));
        v.add(new Customer("David", "david@emitrom.com", "555-111-222", "Sales"));
        v.add(new Customer("Enno", "enno@emitrom.com", "555-111-222", "IT"));
        v.add(new Customer("Dean", "dean@emitrom.com", "555-111-222", "Accouting"));

        return v;
    }
}
