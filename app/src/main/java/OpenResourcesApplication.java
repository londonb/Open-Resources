import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by owner on 5/4/16.
 */
public class OpenResourcesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
