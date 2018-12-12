package com.up.problemrepair.hellogithub;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.up.problemrepair.CircleTransform;
import com.up.problemrepair.RecyclerViewAdapter;
import com.up.problemrepair.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DrawActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private View content;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    public static final String AVATAR_URL = "http://lorempixel.com/200/200/people/1/";
    private static List<ViewModel> items = new ArrayList<>();
    static {
        for (int i = 1; i <= 10; i++) {
            items.add(new ViewModel("Item " + i, "http://lorempixel.com/500/500/animals/" + i));
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        setRecyclerAdapter(mRecyclerView);
        mRecyclerView.scheduleLayoutAnimation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        initRecyclerView();
        initFab();
        initToobar();
        initDrayLayout();

        content = findViewById(R.id.content);

        ImageView imageView = mNavigationView.getHeaderView(0).findViewById(R.id.avatar);
        Picasso.with(this).load(AVATAR_URL).transform(new CircleTransform()).into(imageView);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            setRecyclerAdapter(mRecyclerView);
        }
    }
    private void setRecyclerAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public void initRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    public void initFab(){
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(content,"fab Clicked",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void initToobar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void initDrayLayout(){
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Snackbar.make(content,item.getTitle(),Snackbar.LENGTH_SHORT).show();
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void onItemClick(View view, ViewModel viewModel) {
        Snackbar.make(content,"id = "+view.getId(),Snackbar.LENGTH_SHORT).show();
    }
}
