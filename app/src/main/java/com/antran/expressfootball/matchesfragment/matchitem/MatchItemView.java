package com.antran.expressfootball.matchesfragment.matchitem;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.antran.expressfootball.R;
import com.antran.expressfootball.matchesfragment.MatchInfo;

import java.text.SimpleDateFormat;

/**
 * Created by AnTran on 05/12/2015.
 */
public class MatchItemView {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private static final int LAYOUT_ITEM = R.layout.match_item;

    private View container;
    private CardView cardView;
    private TextView date;
    private ImageView homeLogo;
    private TextView homeScore;
    private ImageView awayLogo;
    private TextView awayScore;
    private TextView league;
    private TextView stadium;
    private TextView round;

    public MatchItemView(ViewGroup parent) {
        container = LayoutInflater.from(parent.getContext()).inflate(LAYOUT_ITEM, parent, false);

        cardView = (CardView) container.findViewById(R.id.cardview);
        date = (TextView) container.findViewById(R.id.date);
        homeLogo = (ImageView) container.findViewById(R.id.home_logo);
        homeScore = (TextView) container.findViewById(R.id.home_score);
        awayLogo = (ImageView) container.findViewById(R.id.away_logo);
        awayScore = (TextView) container.findViewById(R.id.away_score);
        league = (TextView) container.findViewById(R.id.league);
        stadium = (TextView) container.findViewById(R.id.stadium);
        round = (TextView) container.findViewById(R.id.round);
    }

    public View getContainer() {
        return container;
    }

    public void bindData(MatchInfo matchInfo) {
        date.setText(DATE_FORMAT.format(matchInfo.getDate()));
        homeScore.setText(String.valueOf(matchInfo.getHomeTeamScore()));
        awayScore.setText(String.valueOf(matchInfo.getAwayTeamScore()));
        league.setText(matchInfo.getLeague().getLeagueName());
        stadium.setText(matchInfo.getStadium());
        round.setText(String.valueOf(matchInfo.getRound()));
    }

    public void setListener(final MatchItemViewListener ltn) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ltn.onClickMatch(v);
            }
        });
    }
}
