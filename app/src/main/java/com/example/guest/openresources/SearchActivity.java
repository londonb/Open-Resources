package com.example.guest.openresources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = SearchActivity.class.getSimpleName();
    private String latLong;

    private PlacePicker.IntentBuilder builder;
    private static final int PLACE_PICKER_FLAG = 1;
    @Bind(R.id.pickerBtn) Button mPickerBtn;
    @Bind(R.id.myLocation) AutoCompleteTextView mMyLocation;
    @Bind(R.id.commentEditText) EditText mCommentEditText;
    @Bind(R.id.userNameGreet) TextView mUserNameGreet;
    @Bind(R.id.addCommentButton)Button mAddCommentButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        builder = new PlacePicker.IntentBuilder();
        mPickerBtn.setOnClickListener(this);
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Places.GEO_DATA_API)
                .build();

        mAddCommentButton.setOnClickListener(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        mUserNameGreet.setText("Hello " + userName + ".");



    }
    @Override
    public void onClick(View v) {
        if(v == mPickerBtn) {
            try {
                builder = new PlacePicker.IntentBuilder();
                Intent intent = builder.build(SearchActivity.this);
                startActivityForResult(intent, PLACE_PICKER_FLAG);
            } catch (GooglePlayServicesRepairableException e) {
                GooglePlayServicesUtil.getErrorDialog(e.getConnectionStatusCode(), SearchActivity.this, 0);
            } catch (GooglePlayServicesNotAvailableException e) {
                Toast.makeText(SearchActivity.this, "Google Play Services is not available.",
                        Toast.LENGTH_LONG)
                        .show();
            }
        }
        if(v == mAddCommentButton) {
           String comment = mCommentEditText.getText().toString();

            Intent intent = new Intent(SearchActivity.this, CommentActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PLACE_PICKER_FLAG:
                    Place place = PlacePicker.getPlace(this, intent);
                    latLong = place.getLatLng().toString();
                    latLong = latLong.substring(10);
                    latLong = latLong.substring(0, latLong.length() - 1);
                    Log.d(TAG, latLong);
                    mMyLocation.setText(place.getName() + ", " + place.getAddress());
                    break;
            }
        }
    }

}
