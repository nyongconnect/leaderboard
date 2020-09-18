package com.nyongconnect.leaderboard.services;

import com.nyongconnect.leaderboard.pojo.FormField;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface DocService {
    @FormUrlEncoded
    @PUT("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<FormField> postDoc(@Field("entry.1877115667") String firstName,
                            @Field("entry.2006916086") String lastName,
                            @Field("entry.1824927963") String email,
                            @Field(" entry.284483984") String github
    );
}
