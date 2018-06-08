package com.wmy.modulelottery.mian;

import com.wmy.lib_common.base.BasePresenter;
import com.wmy.lib_common.base.BaseView;
import com.wmy.modulelottery.bean.LotteryBean;

import java.util.List;
/**
 * @author wmy
 * @Description: 定义观察接口
 * @FileName: LotteryContract
 * @Date 2018/6/8/008 10:34
 */
public interface LotteryContract {

    interface View<T> extends BaseView<Presenter> {

        /**
         * View 的存活状态
         *
         * @return true or false
         */
        boolean isActive();

        void refresh(List<T> data);

        void load(List<T> data);

        void showError();

        void showNormal();

    }

    interface Presenter extends BasePresenter {

        void getData(int page, int size, boolean isRefresh);

    }


}
