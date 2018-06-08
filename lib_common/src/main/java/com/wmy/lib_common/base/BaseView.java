package com.wmy.lib_common.base;


import android.support.annotation.Keep;

/**
 * @author wmy
 * @Description: View接口的基类
 * @FileName: BaseView
 * @Date 2018/6/8/008 10:15
 */
@Keep
public interface BaseView<T> {

    void setPresenter(T presenter);

}
