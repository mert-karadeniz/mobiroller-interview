package com.blackseapps.interview.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.blackseapps.interview.data.network.model.Product;

import com.blackseapps.interview.di.PerActivity;
import com.blackseapps.interview.ui.activity.details.DetailsMvpPresenter;
import com.blackseapps.interview.ui.activity.details.DetailsMvpView;
import com.blackseapps.interview.ui.activity.details.DetailsPresenter;
import com.blackseapps.interview.ui.activity.splash.SplashMvpPresenter;
import com.blackseapps.interview.ui.activity.splash.SplashMvpView;
import com.blackseapps.interview.ui.activity.splash.SplashPresenter;
import com.blackseapps.interview.ui.activity.update.ProductUpdateMvpPresenter;
import com.blackseapps.interview.ui.activity.update.ProductUpdateMvpView;
import com.blackseapps.interview.ui.activity.update.ProductUpdatePresenter;
import com.blackseapps.interview.ui.fragment.listing.ListingAdapter;
import com.blackseapps.interview.ui.fragment.adding.AddingMvpPresenter;
import com.blackseapps.interview.ui.fragment.adding.AddingMvpView;
import com.blackseapps.interview.ui.fragment.adding.AddingPresenter;
import com.blackseapps.interview.ui.fragment.listing.ListingMvpPresenter;
import com.blackseapps.interview.ui.fragment.listing.ListingMvpView;
import com.blackseapps.interview.ui.fragment.listing.ListingPresenter;
import com.blackseapps.interview.ui.main.MainMvpPresenter;
import com.blackseapps.interview.ui.main.MainMvpView;
import com.blackseapps.interview.ui.main.MainPresenter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    @Provides
    @PerActivity
    AddingMvpPresenter<AddingMvpView> provideAddingPresenter(
            AddingPresenter<AddingMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ListingMvpPresenter<ListingMvpView> provideListingPresenter(
            ListingPresenter<ListingMvpView> presenter) {
        return presenter;
    }


    @Provides
    Product provideProduct() {
        return new Product();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    ListingAdapter provideAddingAdapter() {
        return new ListingAdapter(new ArrayList<>());
    }

    @Provides
    GridLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new GridLayoutManager(activity, 1);
    }

    @Provides
    @PerActivity
    DetailsMvpPresenter<DetailsMvpView> provideDetailsPresenter(
            DetailsPresenter<DetailsMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProductUpdateMvpPresenter<ProductUpdateMvpView> provideProductUpdatePresenter(
            ProductUpdatePresenter<ProductUpdateMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }
}