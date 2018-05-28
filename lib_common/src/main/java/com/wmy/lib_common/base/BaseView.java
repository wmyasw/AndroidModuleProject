package com.wmy.lib_common.base;


import android.support.annotation.Keep;

/**
 * <p>View接口的基类</p>
 *
 * @author wmy
 * @name BaseView
 */
@Keep
public interface BaseView<T> {

    void setPresenter(T presenter);

}
