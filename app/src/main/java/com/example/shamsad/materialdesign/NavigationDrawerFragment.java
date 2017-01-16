package com.example.shamsad.materialdesign;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    /*ActionBarDrawerToggle is a class that tie together DrawerLayout and ActionBar to
    *implement design.
    *
     */

    private RecyclerView recyclerView;
    public static final String pref_file_name = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer"; // key to decide save or read to Sharedpref

    private ActionBarDrawerToggle mdrawerToggle;
    private DrawerLayout mdrawerLayout;

    private boolean muserLearnedDrawer; //user knows @ drawer?
    private boolean mFromSavedInstanceState; //Drawer for the 1st time or coming from rotation

    private View containerView;



    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //true means user opened the drawer, false means not
        muserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        //mFromSaved... track if the activity started very 1st time or coming back from phone/tab rotation
        if(savedInstanceState!=null){
            mFromSavedInstanceState=true; // it means coming back from rotation
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        View layout=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
                recyclerView= (RecyclerView) layout.findViewById(R.id.drawerList);
                return layout;
    }

    public void setUp(int id_fragment_navigation_drawer, DrawerLayout drawerlayout, Toolbar toolbar) {
        mdrawerLayout = drawerlayout;
        containerView = getActivity().findViewById(id_fragment_navigation_drawer);
        mdrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerlayout,toolbar,R.string.drawerOpen,R.string.drawerClose){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!muserLearnedDrawer){
                    muserLearnedDrawer=true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,muserLearnedDrawer+"");
                    getActivity().invalidateOptionsMenu();
                    /*It declares that the options menu has changed, so should be recreated. The onCreateOptionsMenu(Menu) method will be called the next time it needs to be displayed.
                      Does it affects the ActionBar tabs in any way?
                      It will redraw them.*/
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
        };

        if(!muserLearnedDrawer && !mFromSavedInstanceState){
            mdrawerLayout.openDrawer(containerView);
        }

        mdrawerLayout.addDrawerListener(mdrawerToggle); //to add a listener and removeDrawerListener(DrawerLayout.DrawerListener) to remove a registered listener.
        mdrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mdrawerToggle.syncState();
            }
        });
    }

    private static void  saveToPreferences(Context context, String preferenceName, String preferenceValue){
        SharedPreferences sharedpreferences = context.getSharedPreferences(pref_file_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(preferenceName,preferenceValue);
        editor.apply();
        /* editor.commit() also works that notifies if edit has been performed. It's slow. .apply()
        is faster but doesn't notify if the editing has been finished.
         */
    }

    private static String readFromPreferences(Context context, String preferenceName, String defaultValue){
        SharedPreferences sharedpreferences = context.getSharedPreferences(pref_file_name,Context.MODE_PRIVATE);
        return sharedpreferences.getString(preferenceName,defaultValue);
    }
}
