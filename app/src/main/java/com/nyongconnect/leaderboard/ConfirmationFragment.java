package com.nyongconnect.leaderboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nyongconnect.leaderboard.pojo.FormField;
import com.nyongconnect.leaderboard.services.DocService;
import com.nyongconnect.leaderboard.services.ServicesBuilder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmationFragment extends DialogFragment {

    Button btnYes;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mGithub;

    public ConfirmationFragment() {
        // Required empty public constructor
    }

    public static ConfirmationFragment newInstance() {
        ConfirmationFragment fragment = new ConfirmationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FormActivity myActivity = (FormActivity) getActivity();
        if (myActivity != null){
            mFirstName = myActivity.mFirstNmae;
            mLastName = myActivity.mLastName;
            mEmail = myActivity.mLastName;
            mGithub = myActivity.mGithubRepo;
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmation, container, false);
        btnYes = view.findViewById(R.id.btn_yes);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DocService docService = ServicesBuilder.buildMyService(DocService.class);

                Call<FormField> postDoc = docService.postDoc(mFirstName, mLastName, mEmail, mGithub);
                postDoc.enqueue(new Callback<FormField>() {
                    @Override
                    public void onResponse(Call<FormField> call, Response<FormField> response) {
                        SubmissionSuccessfulFragment dialog = SubmissionSuccessfulFragment.newInstance();
                        dialog.show(getFragmentManager(), "Submission Successful");
                        dismiss();
                    }

                    @Override
                    public void onFailure(Call<FormField> call, Throwable t) {
                        SubmissionFailedFragment dialog2  = SubmissionFailedFragment.newInstance();
                        dialog2.show(getFragmentManager(), "Submission Failed");
                    }
                });


            }
        });
    }
}