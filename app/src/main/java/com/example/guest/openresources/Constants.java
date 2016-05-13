package com.example.guest.openresources;

/**
 * Created by owner on 5/5/16.
 */
public class Constants {
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_LOCATIONS = "locations";
    public static final String FIREBASE_URL_LOCATIONS = FIREBASE_URL + "/" + FIREBASE_LOCATIONS;

    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String KEY_UID = "UID";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
}
