package com.antran.expressfootball.service;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by AnTran on 13/12/2015.
 */
public class LeagueDataHelper {
    private static final String Class = "leagues";

    public static void getLeagues(final FindCallback<ParseObject> callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(Class);
        query.findInBackground(callback);
    }
}
