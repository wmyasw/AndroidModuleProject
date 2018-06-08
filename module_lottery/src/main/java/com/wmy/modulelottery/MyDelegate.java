package com.wmy.modulelottery;

import android.support.annotation.Keep;

import com.orhanobut.logger.Logger;
import com.wmy.lib_common.base.IApplicationDelegate;
import com.wmy.lib_common.base.ViewManager;
import com.wmy.modulelottery.frament.OneFragment;
import com.wmy.modulelottery.frament.OpenPrizeFragment;
import com.wmy.modulelottery.frament.TowFragment;
/**
 * @author wmy
 * @Description:
 * @FileName: MyDelegate
 * @Date 2018/6/8/008 10:22
 */
@Keep
public class MyDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        Logger.init("pattern");
        //主动添加
        ViewManager.getInstance().addFragment(0, OneFragment.newInstance());
        ViewManager.getInstance().addFragment(1, OpenPrizeFragment.newInstance());
        ViewManager.getInstance().addFragment(2, TowFragment.newInstance());
    }

    @Override
    public void onTerminate() {
        Logger.d("onTerminate");
    }

    @Override
    public void onLowMemory() {
        Logger.d("onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        Logger.d("onTrimMemory level:"+level);
    }
}
