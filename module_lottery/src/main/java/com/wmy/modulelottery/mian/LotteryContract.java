package com.wmy.modulelottery.mian;

import com.wmy.lib_common.base.BasePresenter;
import com.wmy.lib_common.base.BaseView;
import com.wmy.modulelottery.bean.LotteryBean;

import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/22 20:33
 * @version V1.2.0
 * @name GirlsContract
 */
public interface LotteryContract {

    interface View extends BaseView<Presenter> {

        /**
         * View 的存活状态
         *
         * @return true or false
         */
        boolean isActive();

        void refresh(List<LotteryBean> data);

        void load(List<LotteryBean> data);

        void showError();

        void showNormal();

    }

    interface Presenter extends BasePresenter {

        void getData(int page, int size, boolean isRefresh);

    }


}
