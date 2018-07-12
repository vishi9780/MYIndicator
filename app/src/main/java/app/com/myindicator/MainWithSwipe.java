package app.com.myindicator;





import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.annotation.Nullable;
import android.os.Bundle;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.ScheduledExecutorService;

import app.com.myindicator.adapter.ViewPagerAdapter;
import app.com.myindicator.fragments.F1;
import app.com.myindicator.fragments.F2;
import app.com.myprogressbar.navigationUi.BottomNavigationBar;
import app.com.myprogressbar.navigationUi.BottomNavigationItem;
import app.com.myprogressbar.navigationUi.ShapeBadgeItem;
import app.com.myprogressbar.navigationUi.TextBadgeItem;
import app.com.myprogressbar.customization.MyProgressBar;

/***
 * Created by Vishal Yadav :- 173020181303HRS
 */
public class MainWithSwipe extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
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
    View deviderView;
    private TabLayout tabLayout;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_parent = (LinearLayout) findViewById(R.id.ll_parent);
        bottom_navigation_bar=(BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        bottom_navigation_bar.setTabSelectedListener(this);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        framelt=(FrameLayout)findViewById(R.id.framelt);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_call:
//                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_chat:
//                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_contact:
//                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });
       /* viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

          /*//Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });*/




//        refresh();
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
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));
    }
    /**
     * Adding custom view to tab
     */

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setCustomView(getTabIndicator(tabLayout.getContext(),R.drawable.post_new_project_tab_bg,"1"));
        tabLayout.getTabAt(1).setCustomView(getTabIndicator(tabLayout.getContext(),R.drawable.my_work_tab_bg,"2"));
        tabLayout.getTabAt(2).setCustomView(getTabIndicator(tabLayout.getContext(),R.drawable.notification_tab_bg,"3"));
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if (i==0){
                deviderView.setVisibility(View.GONE);

            }else {
                deviderView.setVisibility(View.VISIBLE);
            }
        }
    }
    private View getTabIndicator(Context context, int icon,String title) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab_layout, null);
         deviderView=(View)view.findViewById(R.id.deviderView);
        ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
         textView=(TextView)view.findViewById(R.id.tv_textTabBar);
        textView.setText(title);
        return view;
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
        ShapeBadgeItem shapeBadgeItem = new ShapeBadgeItem()
                .setShape(ShapeBadgeItem.SHAPE_STAR_6_VERTICES)
                .setShapeColorResource(android.R.color.background_dark)
                .setGravity(Gravity.TOP | Gravity.END)
                .setHideOnSelect(true);

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


