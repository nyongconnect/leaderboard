package com.nyongconnect.leaderboard.services;

import com.nyongconnect.leaderboard.pojo.TopLearner;
import com.nyongconnect.leaderboard.pojo.TopSkill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningService {
    @GET("hours")
    Call<List<TopLearner>> getHours();

}
