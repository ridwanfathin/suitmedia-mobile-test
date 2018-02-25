package com.example.redion.suitmedia_test.model.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by redion on 25/02/18.
 */

public class ResponseEvent {
    @SerializedName("data")
    @Expose
    private List<DataEvent> data = null;

    public List<DataEvent> getData() {
        return data;
    }

    public void setData(List<DataEvent> data) {
        this.data = data;
    }
}
