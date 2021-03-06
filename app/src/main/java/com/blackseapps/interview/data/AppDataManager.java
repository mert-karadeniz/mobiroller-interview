package com.blackseapps.interview.data;

import com.blackseapps.interview.data.network.ApiHelper;
import com.blackseapps.interview.data.network.model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import javax.inject.Inject;


/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(ApiHelper mApiHelper) {
        this.mApiHelper = mApiHelper;
    }

    @Override
    public DatabaseReference getProductApiCall() {
        return mApiHelper.getProductApiCall();
    }

    @Override
    public Product setProductApiCall(Product product) {
        return mApiHelper.setProductApiCall(product);
    }

    @Override
    public Query getSortByNameIncreasingApiCall() {
        return mApiHelper.getSortByNameIncreasingApiCall();
    }

    @Override
    public Query getSortByNameDescendingApiCall() {
        return mApiHelper.getSortByNameDescendingApiCall();
    }

    @Override
    public Query getSortByPriceIncreasingApiCall() {
        return mApiHelper.getSortByPriceIncreasingApiCall();
    }

    @Override
    public Query getSortByPriceDescendingApiCall() {
        return mApiHelper.getSortByPriceDescendingApiCall();
    }

    @Override
    public Query deleteProductApiCall() {
        return mApiHelper.deleteProductApiCall();
    }

    @Override
    public DatabaseReference updateProductApiCall(Product product) {
        return mApiHelper.updateProductApiCall(product);
    }
}
