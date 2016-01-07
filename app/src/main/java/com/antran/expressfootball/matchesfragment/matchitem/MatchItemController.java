package com.antran.expressfootball.matchesfragment.matchitem;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.antran.expressfootball.FootballVideoScreen;
import com.antran.expressfootball.matchesfragment.MatchInfo;
import com.antran.expressfootball.util.Key;

/**
 * Created by AnTran on 05/12/2015.
 */
public class MatchItemController extends RecyclerView.ViewHolder implements MatchItemViewListener {

    private MatchInfo matchInfo;
    private MatchItemView matchItemView;

    public MatchItemController(MatchItemView itemView) {
        super(itemView.getContainer());
        matchItemView = itemView;
        matchInfo = new MatchInfo();
    }

    public void bindData(MatchInfo matchInfo) {
        this.matchInfo = matchInfo;
        matchItemView.bindData(matchInfo);
    }

    @Override
    public void onClickMatch(View v) {
        Intent video = new Intent(v.getContext(), FootballVideoScreen.class);
        video.putExtra(Key.VIDEO_LINK, matchInfo.getLinkVideo());
        v.getContext().startActivity(video);
    }
}
