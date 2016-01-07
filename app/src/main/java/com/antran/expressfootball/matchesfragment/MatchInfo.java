package com.antran.expressfootball.matchesfragment;

import com.antran.expressfootball.model.League;
import com.antran.expressfootball.model.Team;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by AnTran on 12/12/2015.
 */
public class MatchInfo {

    private String matchId;
    private League league;
    private Date date;
    private String linkVideo;
    private int round;
    private int homeTeamScore;
    private int awayTeamScore;
    private String stadium;
    private Team homeTeam;
    private Team awayTeam;

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public static MatchInfo parse(ParseObject object) {
        MatchInfo matchInfo = new MatchInfo();

        matchInfo.setMatchId(object.getObjectId());
        matchInfo.setLeague(League.parse(object.getParseObject("league")));
        matchInfo.setDate(object.getDate("dateMatch"));
        matchInfo.setLinkVideo(object.getString("linkVideo"));
        matchInfo.setRound(object.getInt("round"));
        matchInfo.setHomeTeamScore(object.getInt("score1"));
        matchInfo.setAwayTeamScore(object.getInt("score2"));
        matchInfo.setHomeTeam(Team.parse(object.getParseObject("team1")));
        matchInfo.setAwayTeam(Team.parse(object.getParseObject("team2")));
        matchInfo.setStadium(object.getString("stadium"));
        return matchInfo;
    }
}
