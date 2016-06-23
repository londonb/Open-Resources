package com.example.guest.openresources.ui;

import android.Manifest;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guest.openresources.Constants;
import com.example.guest.openresources.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class LocationsActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final String TAG = LocationsActivity.class.getSimpleName();
    private static final int MAP_ZOOM_LEVEL = 12;
    private GoogleMap mMap;
    private Firebase mFirebaseLocationsRef;
    private Query mQuery;
    double lat;
    double lng;
    String namePlace;
    String comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFirebaseLocationsRef = new Firebase(Constants.FIREBASE_URL_LOCATIONS);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        drawLocations();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
//       
    }

    private void drawLocations() {
        Query queryRef = new Firebase(Constants.FIREBASE_URL_LOCATIONS);

        queryRef.addChildEventListener(new ChildEventListener() {
            LatLngBounds bounds;
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map data = (Map) dataSnapshot.getValue();
                lat = (double) data.get("lat");
                lng = (double) data.get("lng");
                comment = (String) data.get("comment");
                namePlace = (String) data.get("namePlace");
                LatLng mLatlng = new LatLng(lat, lng);
                Log.d(TAG, "latlong from database: " + mLatlng);
                builder.include(mLatlng);
                bounds = builder.build();

                MarkerOptions mMarkerOption = new MarkerOptions()
                        .title(namePlace)
                        .snippet(comment)
                        .position(mLatlng);
                Marker mMarker = mMap.addMarker(mMarkerOption);
                //mMap.addMarker(mMarkerOption);
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,
                        MAP_ZOOM_LEVEL));

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
