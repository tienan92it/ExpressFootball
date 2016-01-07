package com.antran.expressfootball.matchesfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antran.expressfootball.R;
import com.antran.expressfootball.matchesfragment.matches.MatchesController;
import com.antran.expressfootball.matchesfragment.matches.MatchesControllerListener;
import com.antran.expressfootball.matchesfragment.matches.MatchesView;
import com.antran.expressfootball.loading.LoadingController;
import com.antran.expressfootball.loading.LoadingControllerListener;
import com.antran.expressfootball.loading.LoadingView;

/**
 * Created by AnTran on 05/12/2015.
 */
public class LastedHighlightFragment extends Fragment implements LoadingControllerListener, MatchesControllerListener {

    private View rootview;
    private Context context;

    private LoadingController loadingController;
    private MatchesController matchesController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.lasted_high_light_fragment, container, false);

        LoadingView loadingView = new LoadingView(context);
        loadingController = new LoadingController(loadingView, this);

        MatchesView matchesView = new MatchesView((RecyclerView) rootview.findViewById(R.id.recyclerview));
        matchesController = new MatchesController(context, matchesView, this);
        matchesView.setListener(matchesController);
        matchesView.setAdapter(matchesController);

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        matchesController.firstLoadData(null);
    }

    @Override
    public void onLoading() {
        loadingController.showLoading();
    }

    @Override
    public void onLoaded() {
        loadingController.hideLoading();
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onHide() {

    }
}
