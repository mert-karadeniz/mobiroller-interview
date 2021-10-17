package com.blackseapps.interview.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.blackseapps.interview.di.PerActivity;
import com.blackseapps.interview.ui.fragment.adding.AddingMvpPresenter;
import com.blackseapps.interview.ui.fragment.adding.AddingMvpView;
import com.blackseapps.interview.ui.fragment.adding.AddingPresenter;
import com.blackseapps.interview.ui.main.MainMvpPresenter;
import com.blackseapps.interview.ui.main.MainMvpView;
import com.blackseapps.interview.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

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
    AddingMvpPresenter<AddingMvpView> provideFeedPresenter(
            AddingPresenter<AddingMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}