package com.example.redion.suitmedia_test.model.people;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by redion on 25/02/18.
 */

public class ResponsePeople {
    @SerializedName("data")
    @Expose
    private List<DataPeople> data = null;

    public List<DataPeople> getData() {
        return data;
    }

    public void setData(List<DataPeople> data) {
        this.data = data;
    }
}
