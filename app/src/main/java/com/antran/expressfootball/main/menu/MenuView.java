package com.antran.expressfootball.main.menu;

import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.antran.expressfootball.R;
import com.antran.expressfootball.matchesfragment.LastedHighlightFragment;

/**
 * Created by AnTran on 13/12/2015.
 */
public class MenuView {

    private NavigationView navigationView;
    private Menu menu;
    private SubMenu leagueItems;

    public MenuView(NavigationView navigationView) {
        this.navigationView = navigationView;
        menu = navigationView.getMenu();
        leagueItems = menu.addSubMenu("League");
    }

    public void setListener(final MenuViewListener ltn) {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                ltn.onMenuItemSelected(menuItem);
                return true;
            }
        });
    }

    public void addLeagueMenuItem(int itemId, String title){
        leagueItems.add(Menu.NONE, Menu.NONE, Menu.NONE, title);
//        MenuItem menuItem = leagueItems.findItem(itemId);
//        menuItem.setTitle(title);
//        menuItem.setIcon(R.drawable.ic_premier_league);
    }
}
