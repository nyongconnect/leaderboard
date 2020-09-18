package com.nyongconnect.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SubmissionSuccessfulFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubmissionSuccessfulFragment extends DialogFragment {

    public SubmissionSuccessfulFragment() {
        // Required empty public constructor
    }


    public static SubmissionSuccessfulFragment newInstance() {
        SubmissionSuccessfulFragment fragment = new SubmissionSuccessfulFragment();
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
        return inflater.inflate(R.layout.fragment_submission_successful, container, false);
    }
}