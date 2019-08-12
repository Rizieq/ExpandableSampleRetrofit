package com.rizieq.expandablesampleretrofit.network;


import com.rizieq.expandablesampleretrofit.modelsecond.ResponseSecond;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("v1/links")
    Call<ResponseSecond> getListSecond(@Field("account_id")String account_id,
                                        @Field("mobile")String mobile,
                                        @Header("Authorization")String auth);
}
