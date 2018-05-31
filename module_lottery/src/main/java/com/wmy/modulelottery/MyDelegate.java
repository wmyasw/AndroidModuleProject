package com.wmy.modulelottery;

import android.support.annotation.Keep;

import com.orhanobut.logger.Logger;
import com.wmy.lib_common.base.IApplicationDelegate;
import com.wmy.lib_common.base.ViewManager;
import com.wmy.modulelottery.frament.OneFragment;
import com.wmy.modulelottery.frament.OpenPrizeFragment;
import com.wmy.modulelottery.frament.TowFragment;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/9/20 22:29
 * @version V2.8.3
 * @name MyDelegate
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

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
