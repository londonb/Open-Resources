package com.example.guest.openresources.ui;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.openresources.Constants;
import com.example.guest.openresources.R;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Firebase mFirebaseLocationsRef;
    private Query mQuery;

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
//        drawLocations();
        LatLng sydney = new LatLng(45.5231, -122.677);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Waterfront Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

//    private void drawLocations() {
//        LatLng latLong = mFirebaseLocationsRef.getLatLong;
//        mQuery = new Firebase(latLong);
//        MarkerOptions mMarkerOptions = new MarkerOptions()
//            .position(latLong);
//    }
}
