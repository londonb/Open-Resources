package com.example.guest.openresources;

import com.firebase.client.Firebase;
import android.app.Application;



/**
 * Created by owner on 5/5/16.
 */
public class OpenResourcesApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
