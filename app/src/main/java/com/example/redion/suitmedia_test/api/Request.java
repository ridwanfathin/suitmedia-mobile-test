package com.example.redion.suitmedia_test.api;


import com.example.redion.suitmedia_test.model.Value;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by redion on 25/02/18.
 */

public interface Request {

    @GET("people")
    Call<Value> viewGuest();

}
