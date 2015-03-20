package pe.friki.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by studio on 20/03/15.
 */
public class ConfigureApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "umD4JVENws0dAZrf9M5PaXXMwbGKGkN65PcVUU71","g8JKdqyVV7BPDGrtHIHmQsvU4uTNSutrwaEwbQqo");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
