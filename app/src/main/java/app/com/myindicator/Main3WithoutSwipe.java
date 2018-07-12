package app.com.myindicator;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.concurrent.ScheduledExecutorService;

import app.com.myindicator.adapter.ViewPagerAdapter;
import app.com.myindicator.fragments.F1;
import app.com.myindicator.fragments.F2;
import app.com.myprogressbar.customization.MyProgressBar;
import app.com.myprogressbar.navigationUi.BottomNavigationBar;
import app.com.myprogressbar.navigationUi.BottomNavigationItem;
import app.com.myprogressbar.navigationUi.ShapeBadgeItem;
import app.com.myprogressbar.navigationUi.TextBadgeItem;

public class Main3WithoutSwipe extends AppCompatActivity  implements BottomNavigationBar.OnTabSelectedListener {
    public static final String TAG=MainWithSwipe.class.getSimpleName();
    private ScheduledExecutorService scheduleTaskExecutor;
    LinearLayout ll_parent;
    public static int counter=25;
    MyProgressBar myProgressBar;
    //    private ActivityStyleBinding bind;
    BottomNavigationBar  bottom_navigation_bar;
    FrameLayout framelt;
    boolean is4theTabisSelected=false;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    MenuItem prevMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bottom_navigation_bar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        bottom_navigation_bar.setTabSelectedListener(this);
        framelt=(FrameLayout)findViewById(R.id.framelt);

        refresh();
      /*  ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProgressBar = MyProgressBar.show(MainWithSwipe.this, "Please Wait . . .",
                        true, false, null, counter);
                counter++;
              *//*  final Timer timer2 = new Timer();
                timer2.schedule(new TimerTask() {
                    public void run() {
                        myProgressBar.dismiss();
                        timer2.cancel(); //this will cancel the timer of the system
                    }
                }, 5000); // the timer will count 5 seconds....*//*
            }
        });
        ll_parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                counter=0;
                return true;
            }
        });

        scheduleTaskExecutor = Executors.newScheduledThreadPool(40);
//        counter=35;
        scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // Do stuff here!

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                               *//* if (counter!=40) {
                                    myProgressBar = MyProgressBar.show(MainWithSwipe.this, "Please Wait . . .",
                                            true, false, null, counter);
                                    counter++;
                                    Log.e(TAG, "<<<<onClick:38>>>" + counter);
                                }else {*//*
                               try {
                                   if (myProgressBar.isShowing()) {
                                       myProgressBar.dismiss();
                                       myProgressBar.hide();
                                       Log.e(TAG, "<<<<onClick:68>>>" + counter + "<<<else>>>");
                                   }
                               }catch (Exception e){
                                   Log.e("80","<<Main>>"+e);
                               }


                    }
                });

            }
        }, 0, 5,TimeUnit.SECONDS);*/
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new F1());
        adapter.addFragment(new F2());
        adapter.addFragment(new F1());
        viewPager.setAdapter(adapter);
    }
    private void refresh() {
//        bottom_navigation_bar.clearAll();
//                bottomNavigationBar.setFab(fabHome, BottomNavigationBar.FAB_BEHAVIOUR_TRANSLATE_AND_STICK);
//        bottom_navigation_bar.setFab(fabHome);
        loadFragment(new F1());
        TextBadgeItem numberBadgeItem = new TextBadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(android.R.color.darker_gray)
                .setText("0")
                .setHideOnSelect(true);
        ShapeBadgeItem shapeBadgeItem = new ShapeBadgeItem();
        shapeBadgeItem.setShape(ShapeBadgeItem.SHAPE_STAR_6_VERTICES);
        shapeBadgeItem.setShapeColorResource(android.R.color.background_dark);
        shapeBadgeItem.setGravity(Gravity.TOP | Gravity.END);
        shapeBadgeItem.setHideOnSelect(false);
        shapeBadgeItem.show();

        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottom_navigation_bar
                .addItem(new BottomNavigationItem(R.drawable.spinner_0, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.spinner_1, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.spinner_2, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.spinner_3, "Movies & TV")
                        .setActiveColorResource(android.R.color.holo_blue_bright)
                        .setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.spinner_4, "Love")
                        .setActiveColorResource(android.R.color.holo_blue_bright)
                        .setBadgeItem(shapeBadgeItem))
                .initialise();
    }

    @Override
    public void onTabSelected(int position) {
//        Toast.makeText(this, ">"+position, Toast.LENGTH_SHORT).show();
        setScrollableText(position);
    }

    private void setScrollableText(int position) {
        switch (position){

            case 0:
                loadFragment(new F1());
                break;
            case 1:
                loadFragment(new F2());
                break;
            case 2:
                loadFragment(new F1());
                break;
            case 3:
                loadFragment(new F2());

                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void loadFragment(Fragment fragment) {
// create a FragmentManager

// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.framelt, fragment);
        fragmentTransaction.commit(); // save the changes
    }

}
