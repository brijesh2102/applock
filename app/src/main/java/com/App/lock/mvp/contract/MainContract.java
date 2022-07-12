package com.App.lock.mvp.contract;

import android.content.Context;

import com.App.lock.base.BasePresenter;
import com.App.lock.base.BaseView;
import com.App.lock.model.CommLockInfo;

import java.util.List;



public interface MainContract {
    interface View extends BaseView<Presenter> {
        void loadAppInfoSuccess(List<CommLockInfo> list);
    }

    interface Presenter extends BasePresenter {
        void loadAppInfo(Context context, boolean isSort);

        void loadLockAppInfo(Context context);

        void onDestroy();
    }
}
