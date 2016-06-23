package com.example.guest.openresources.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.openresources.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.SeeButton)Button mSeeButton;
    @Bind(R.id.AddButton) Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");


        mSeeButton.setOnClickListener(this);
        mAddButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SeeButton:
                Intent intent = new Intent(WelcomeActivity.this, LocationsActivity.class);
                startActivity(intent);
                break;
            case R.id.AddButton:
                Intent intent1 = new Intent(WelcomeActivity.this, NewSpotActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}


