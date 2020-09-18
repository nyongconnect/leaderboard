package com.nyongconnect.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubmissionFailedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubmissionFailedFragment extends DialogFragment {


    public SubmissionFailedFragment() {
        // Required empty public constructor
    }

    public static SubmissionFailedFragment newInstance() {
        SubmissionFailedFragment fragment = new SubmissionFailedFragment();
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
        return inflater.inflate(R.layout.fragment_submission_failed, container, false);
    }
}