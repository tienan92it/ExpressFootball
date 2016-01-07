package com.antran.expressfootball.service;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by AnTran on 12/12/2015.
 */
public class MatchDataHelper {

    private static final String ClassMatch = "match";
    private static final String ClassLeague = "leagues";

    public static void getMatchesFrom(String leagueId,final FindCallback<ParseObject> callback){
        ParseQuery<ParseObject> queryMatch = ParseQuery.getQuery(ClassMatch);
        ParseQuery<ParseObject> queryLeague = ParseQuery.getQuery(ClassLeague);
        queryLeague.whereEqualTo("objectId", leagueId);
        queryMatch.whereMatchesQuery("league", queryLeague);
        queryMatch.include("league");
        queryMatch.include("team1");
        queryMatch.include("team2");
        queryMatch.orderByDescending("dateMatch");
        queryMatch.findInBackground(callback);
    }

    public static void getAllMatches(final FindCallback<ParseObject> callback){
        ParseQuery<ParseObject> queryMatch = ParseQuery.getQuery(ClassMatch);
        queryMatch.include("league");
        queryMatch.include("team1");
        queryMatch.include("team2");
        queryMatch.orderByDescending("dateMatch");
        queryMatch.findInBackground(callback);
    }
}
