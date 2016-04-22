package com.example.guest.openresources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    public static final String TAG = SearchActivity.class.getSimpleName();

    @Bind(R.id.userNameGreet) TextView mUserNameGreet;
    @Bind(R.id.addCommentButton)ImageButton mAddCommentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        mUserNameGreet.setText("Hello " + userName + ".");

        mAddCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });

    }
}
