package com.wmy.lib_common.base;

import android.support.annotation.Keep;

/**
 * @author wmy
 * @Description: 数据回调接口
 * @FileName: InfoCallback
 * @Date 2018/6/8/008 10:16
 */
@Keep
public interface InfoCallback<T> {

    void onSuccess(T info);

    void onError(int code, String message);

}
