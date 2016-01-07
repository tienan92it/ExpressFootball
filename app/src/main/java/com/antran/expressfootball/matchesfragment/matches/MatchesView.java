package com.antran.expressfootball.matchesfragment.matches;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by AnTran on 05/12/2015.
 */
public class MatchesView {

    private RecyclerView recyclerView;

    public MatchesView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.recyclerView.getContext());
        this.recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void setListener(MatchesViewListener ltn) {

    }

    public void setAdapter(MatchesController adapter){
        recyclerView.setAdapter(adapter);
    }
}
