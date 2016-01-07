package com.antran.expressfootball.model;

import com.parse.ParseException;
import com.parse.ParseObject;

/**
 * Created by AnTran on 12/12/2015.
 */
public class Team {

    private String teamId;
    private String teamName;
    private String logo;
    private League league;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public static Team parse(ParseObject object) {
        Team team = new Team();
        team.setTeamId(object.getObjectId());
        team.setTeamName(object.getString("name"));
//        team.setLogo(object.getParseFile("thumbnail").getUrl());
        try {
            team.setLeague(League.parse(object.getParseObject("league").fetchIfNeeded()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return team;
    }
}
