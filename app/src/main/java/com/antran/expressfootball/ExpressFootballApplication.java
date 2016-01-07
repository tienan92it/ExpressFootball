package com.antran.expressfootball;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by AnTran on 12/12/2015.
 */
public class ExpressFootballApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "yzQlOHXEjzXLbv3R9LMoE42ZYQlq9xJ8sVBu0vNy", "ZDeaEXH8m1ul8hVAgIMFhA7hqJf4dKMhGztRH8tl");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
