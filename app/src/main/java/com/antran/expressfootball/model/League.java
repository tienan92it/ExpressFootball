package com.antran.expressfootball.model;

import android.graphics.Bitmap;

import com.parse.ParseException;
import com.parse.ParseObject;

/**
 * Created by AnTran on 12/12/2015.
 */
public class League {

    private String leagueId;
    private String leagueName;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    private String logo;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public static League parse(ParseObject object) {
        League league = new League();
        league.setLeagueId(object.getObjectId());
        league.setLeagueName(object.getString("name"));
//        league.setLogo(object.getParseFile("thumbnail").getUrl());
        return league;
    }
}
