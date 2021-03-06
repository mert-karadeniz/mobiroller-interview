package com.blackseapps.interview.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.blackseapps.interview.R;
import com.blackseapps.interview.ui.base.BaseActivity;
import com.blackseapps.interview.ui.fragment.adding.AddingFragment;
import com.blackseapps.interview.ui.fragment.listing.ListingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {


    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.nav_view)
    BottomNavigationView mNavigationView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        setupNavMenu();
        mPresenter.onOpenListingFragment();
    }


    @Override
    public void showAddingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.nav_host_fragment_activity_main, AddingFragment.newInstance(), AddingFragment.TAG)
                .commit();
    }

    @Override
    public void showListingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.nav_host_fragment_activity_main, ListingFragment.newInstance(), ListingFragment.TAG)
                .commit();
    }


    @SuppressLint("NonConstantResourceId")
    void setupNavMenu() {
        mNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_listing:
                    mPresenter.onOpenListingFragment();
                    return true;
                case R.id.navigation_adding:
                    mPresenter.onOpenAddingFragment();
                    return true;
                default:
                    return false;
            }
        });
    }



    @Override
    public void onFragmentDetached(String tag) {
        super.onFragmentDetached(tag);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .remove(fragment)
                    .commitNow();
        }
    }
}