package com.example.redion.suitmedia_test.model;

import java.util.List;

/**
 * Created by redion on 25/02/18.
 */

public class Value {
    List<GuestModel> result;
    String value;
    String message;

    public List<GuestModel> getResult(){
        return result;
    }
    public String getMessage(){
        return message;
    }

    public String getValue(){
        return value;
    }
}
