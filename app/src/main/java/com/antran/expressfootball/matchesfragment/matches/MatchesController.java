package com.antran.expressfootball.matchesfragment.matches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.antran.expressfootball.matchesfragment.MatchInfo;
import com.antran.expressfootball.matchesfragment.matchitem.MatchItemController;
import com.antran.expressfootball.matchesfragment.matchitem.MatchItemView;
import com.antran.expressfootball.service.MatchDataHelper;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnTran on 05/12/2015.
 */
public class MatchesController extends RecyclerView.Adapter<MatchItemController> implements MatchesViewListener {

    private Context context;
    private List<MatchInfo> matches;
    private MatchesView matchesView;
    private MatchesControllerListener listener;

    public MatchesController(Context context, MatchesView matchesView, MatchesControllerListener ltn) {
        this.context = context;
        this.matchesView = matchesView;
        this.listener = ltn;
        this.matches = new ArrayList<MatchInfo>();
    }

    /**
     * Called when RecyclerView needs a new {@link MatchItemController} of the given type to represent
     * an item.
     * <p/>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p/>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(MatchItemController, int)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(MatchItemController, int)
     */
    @Override
    public MatchItemController onCreateViewHolder(ViewGroup parent, int viewType) {
        MatchItemController matchItemController = null;

        MatchItemView matchItemView = new MatchItemView(parent);
        matchItemController = new MatchItemController(matchItemView);
        matchItemView.setListener(matchItemController);

        return matchItemController;
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link MatchItemController#itemView} to reflect the item at the given
     * position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link MatchItemController#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p/>
     * Override {@link #onBindViewHolder(MatchItemController, int)} instead if Adapter can
     * handle effcient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(MatchItemController holder, int position) {
        holder.bindData(matches.get(position));
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return matches.size();
    }

    public void firstLoadData(String leagueId) {
        listener.onLoading();
        matches.clear();
        if (leagueId != null && leagueId.compareTo("") != 0) {
            MatchDataHelper.getMatchesFrom(leagueId, new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null && objects.size() > 0) {
                        for (ParseObject match : objects) {
                            matches.add(MatchInfo.parse(match));
                        }
                        notifyDataSetChanged();
                    } else {
                        e.printStackTrace();
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                    listener.onLoaded();
                }
            });
        } else {
            MatchDataHelper.getAllMatches(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null && objects.size() > 0) {
                        for (ParseObject match : objects) {
                            matches.add(MatchInfo.parse(match));
                        }
                        notifyDataSetChanged();
                    } else {
                        e.printStackTrace();
                        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                    listener.onLoaded();
                }
            });
        }
    }
}
