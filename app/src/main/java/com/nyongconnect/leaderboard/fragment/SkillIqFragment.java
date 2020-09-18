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
import com.nyongconnect.leaderboard.adapter.SkillAdapter;
import com.nyongconnect.leaderboard.pojo.TopSkill;
import com.nyongconnect.leaderboard.services.SkillService;
import com.nyongconnect.leaderboard.services.ServicesBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillIqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillIqFragment extends Fragment {

    private List<TopSkill> skills;
    private RecyclerView rvSkillIq;


    public static SkillIqFragment newInstance() {
        SkillIqFragment fragment = new SkillIqFragment();
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
        return inflater.inflate(R.layout.fragment_skill_iq, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSkillIq = view.findViewById(R.id.rv_skill_iq);
        skills = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        final SkillAdapter skillAdapter = new SkillAdapter(getContext(), skills);
        rvSkillIq.setLayoutManager(linearLayoutManager);
        rvSkillIq.setAdapter(skillAdapter);

        SkillService skillService = ServicesBuilder.buildService(SkillService.class);
        Call<List<TopSkill>> call = skillService.getSkill();
        call.enqueue(new Callback<List<TopSkill>>() {
            @Override
            public void onResponse(Call<List<TopSkill>> call, Response<List<TopSkill>> response) {
               rvSkillIq.setAdapter(new SkillAdapter(getContext(), response.body()));
            }


            @Override
            public void onFailure(Call<List<TopSkill>> call, Throwable t) {

            }
        });
    }
}