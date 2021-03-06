package com.blackseapps.interview.ui.activity.update;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 23.10.2021
 * <p>
 * This is an interview project.
 */

public class ProductUpdatePresenter<V extends ProductUpdateMvpView> extends BasePresenter<V>
        implements ProductUpdateMvpPresenter<V> {

    @Inject
    public ProductUpdatePresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onClickUpdateButton(Product product) {

        if (product.getCategoryName() == null || product.getCategoryName().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_category);
            return;
        } else if (product.getTitle() == null || product.getTitle().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_title);
            return;
        } else if (product.getDescription() == null || product.getDescription().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_description);
            return;
        } else if (product.getBrandName() == null || product.getBrandName().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_brand);
            return;
        } else if (product.getPrice() == 0) {
            getMvpView().onError(R.string.adding_empty_price);
            return;
        } else if (product.getStockCode() == null || product.getStockCode().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_stock_code);
            return;
        } else if (product.getStockTotal() == 0) {
            getMvpView().onError(R.string.adding_empty_stock_total);
            return;
        }

        getDataManager().updateProductApiCall(product);

        getMvpView().onHandleRequestFinally();

    }
}
