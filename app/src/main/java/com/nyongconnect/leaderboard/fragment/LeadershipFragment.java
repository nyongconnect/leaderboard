package com.nyongconnect.leaderboard.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nyongconnect.leaderboard.R;
import com.nyongconnect.leaderboard.adapter.LeaderAdapter;
import com.nyongconnect.leaderboard.pojo.TopLearner;
import com.nyongconnect.leaderboard.services.LearningService;
import com.nyongconnect.leaderboard.services.SkillService;
import com.nyongconnect.leaderboard.services.ServicesBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeadershipFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeadershipFragment extends Fragment {

    RecyclerView rvLeaderBoard;
    private List<TopLearner> leaders;

    public LeadershipFragment() {
        // Required empty public constructor
    }


    public static LeadershipFragment newInstance(String param1, String param2) {
        LeadershipFragment fragment = new LeadershipFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leadership, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leaders = new ArrayList<>();
        rvLeaderBoard = view.findViewById(R.id.rv_leaderboard);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        LeaderAdapter leaderAdapter = new LeaderAdapter(getContext(), leaders);
        rvLeaderBoard.setLayoutManager(linearLayoutManager);
        rvLeaderBoard.setAdapter(leaderAdapter);


       LearningService learnerService = ServicesBuilder.buildService(LearningService.class);

        Call<List<TopLearner>> call = learnerService.getHours();
        call.enqueue(new Callback<List<TopLearner>>() {
            @Override
            public void onResponse(Call<List<TopLearner>> call, Response<List<TopLearner>> response) {
                rvLeaderBoard.setAdapter(new LeaderAdapter(getContext(), response.body()));
            }

            @Override
            public void onFailure(Call<List<TopLearner>> call, Throwable t) {

            }
        });

    }
}