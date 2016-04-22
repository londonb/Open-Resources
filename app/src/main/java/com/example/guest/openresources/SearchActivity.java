package com.example.guest.openresources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    public static final String TAG = SearchActivity.class.getSimpleName();

    @Bind(R.id.userNameGreet) TextView mUserNameGreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        mUserNameGreet.setText("Hello " + userName + ".");

    }
}
