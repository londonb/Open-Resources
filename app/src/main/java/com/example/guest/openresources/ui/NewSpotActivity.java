package com.example.guest.openresources.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.openresources.Constants;
import com.example.guest.openresources.Models.Location;
import com.example.guest.openresources.R;
import com.firebase.client.Firebase;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewSpotActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = NewSpotActivity.class.getSimpleName();
    private String latLong;

    private PlacePicker.IntentBuilder builder;
    private static final int PLACE_PICKER_FLAG = 1;
    @Bind(R.id.pickerBtn) Button mPickerBtn;
    @Bind(R.id.myLocation) AutoCompleteTextView mMyLocation;
    @Bind(R.id.commentEditText) EditText mCommentEditText;
    @Bind(R.id.addCommentButton)Button mAddCommentButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspot);
        ButterKnife.bind(this);
        builder = new PlacePicker.IntentBuilder();
        mPickerBtn.setOnClickListener(this);
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Places.GEO_DATA_API)
                .build();

        mAddCommentButton.setOnClickListener(this);




    }
    @Override
    public void onClick(View v) {
        if(v == mPickerBtn) {
            try {
                builder = new PlacePicker.IntentBuilder();
                Intent intent = builder.build(NewSpotActivity.this);
                startActivityForResult(intent, PLACE_PICKER_FLAG);
            } catch (GooglePlayServicesRepairableException e) {
                GooglePlayServicesUtil.getErrorDialog(e.getConnectionStatusCode(), NewSpotActivity.this, 0);
            } catch (GooglePlayServicesNotAvailableException e) {
                Toast.makeText(NewSpotActivity.this, "Google Play Services is not available.",
                        Toast.LENGTH_LONG)
                        .show();
            }
        }
        if(v == mAddCommentButton) {
           showNewPostDialog();
        }
    }

    public void showNewPostDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText namePlace = (EditText) dialogView.findViewById(R.id.newPostTitleEditText);
        final EditText comment = (EditText) dialogView.findViewById(R.id.newPostBodyEditText);

        dialogBuilder.setTitle("New Location");
        dialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String newNamePlace = namePlace.getText().toString();
                String newComment = comment.getText().toString();
                String newLatLong = latLong.toString();

                Location newLocation = new Location(newNamePlace,newComment, newLatLong);


                saveLocationToFirebase(newLocation);
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //cancel
            }
        });
        AlertDialog b =dialogBuilder.create();
        b.show();
    }
    public void saveLocationToFirebase(Location location) {
        Firebase addedPostRef = new Firebase(Constants.FIREBASE_URL_LOCATIONS);
        addedPostRef.push().setValue(location);
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
