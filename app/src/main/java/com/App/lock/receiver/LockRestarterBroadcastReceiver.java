package com.App.lock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.App.lock.base.AppConstants;
import com.App.lock.services.BackgroundManager;
import com.App.lock.services.LockService;
import com.App.lock.utils.SpUtil;

public class LockRestarterBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean lockState=SpUtil.getInstance().getBoolean(AppConstants.LOCK_STATE);
        if (intent != null && lockState) {
            String type = intent.getStringExtra("type");
            if (type.contentEquals("lockservice"))
                //context.startService(new Intent(context, LockService.class));
                BackgroundManager.getInstance().init(context).startService(LockService.class);
           /* else if (SpUtil.getInstance().getBoolean(AppConstants.LOCK_TYPE, false))
                BackgroundManager.getInstance().init(context).startService(LockAccessibilityService.class);*/
            else if (type.contentEquals("startlockserviceFromAM")) {
                if (!BackgroundManager.getInstance().init(context).isServiceRunning(LockService.class)) {
                    BackgroundManager.getInstance().init(context).startService(LockService.class);
                }
                //repeat
                BackgroundManager.getInstance().init(context).startAlarmManager();
            }
        }
    }
}
