package com.nyongconnect.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    EditText mTxtLastName, mTxtFirstName, mTxtGitHub, mTxtEmail;

    Button btnSubmit;
    public String mGithubRepo;
    public String mLastName;
    public String mFirstNmae;
    public String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        btnSubmit = findViewById(R.id.btn_submit_form);
        mTxtEmail = findViewById(R.id.et_email_address);
        mTxtFirstName = findViewById(R.id.et_first_name);
        mTxtLastName = findViewById(R.id.et_last_name);
        mTxtGitHub = findViewById(R.id.et_github);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputFromUser();
                ConfirmationFragment confirmationFragment = ConfirmationFragment.newInstance();
                confirmationFragment.show(getSupportFragmentManager(), "Confirmation Fragment");
            }
        });
    }

    private void getInputFromUser() {

        mGithubRepo = mTxtGitHub.getText().toString();
        mLastName = mTxtLastName.getText().toString();
        mFirstNmae = mTxtFirstName.getText().toString();
        mEmail = mTxtEmail.getText().toString();
    }
}