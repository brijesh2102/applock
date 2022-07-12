package com.App.lock.mvp.contract;

import android.content.Context;

import com.App.lock.base.BasePresenter;
import com.App.lock.base.BaseView;
import com.App.lock.model.CommLockInfo;
import com.App.lock.mvp.p.LockMainPresenter;

import java.util.List;



public interface LockMainContract {
    interface View extends BaseView<Presenter> {

        void loadAppInfoSuccess(List<CommLockInfo> list);
    }

    interface Presenter extends BasePresenter {
        void loadAppInfo(Context context);

        void searchAppInfo(String search, LockMainPresenter.ISearchResultListener listener);

        void onDestroy();
    }
}
