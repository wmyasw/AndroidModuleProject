package com.wmy.lib_common.base;

import android.support.annotation.Keep;

/**
 * @author wmy
 * @Description: 类说明
 * @FileName: IApplicationDelegate
 * @Date 2018/6/8/008 10:16
 */
@Keep
public interface IApplicationDelegate {

    void onCreate();

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

}
