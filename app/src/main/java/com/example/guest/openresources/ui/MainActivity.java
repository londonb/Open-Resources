package com.example.guest.openresources.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.openresources.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.UserNameText) EditText mUserNameText;
    @Bind(R.id.registerTextView) TextView mRegisterTextView;

    public void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyboard(MainActivity.this);
                    return false;
                }
            });
        }

        if(view instanceof ViewGroup) {
            for(int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI(findViewById(R.id.parentContainer));
        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);


        mSubmitButton.setOnClickListener(this);
    }


            @Override
            public void onClick(View v) {
                if (v == mSubmitButton){

                String userName = mUserNameText.getText().toString();
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
                if (v == mRegisterTextView) {
                    Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                    startActivity(intent);
                    finish();
                }

        };
}




