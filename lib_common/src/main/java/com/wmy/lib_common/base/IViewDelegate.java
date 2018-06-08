package com.wmy.lib_common.base;


import android.support.annotation.Keep;
import android.view.View;

/**
 * @author wmy
 * @Description: 类说明
 * @FileName: IViewDelegate
 * @Date 2018/6/8/008 10:18
 */
@Keep
public interface IViewDelegate {

    BaseFragment getFragment(String name);

    View getView(String name);

}
