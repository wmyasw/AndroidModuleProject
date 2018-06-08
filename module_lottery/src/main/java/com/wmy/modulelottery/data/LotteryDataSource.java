package com.wmy.modulelottery.data;


import android.provider.SyncStateContract;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.wmy.lib_common.common.Constant;
import com.wmy.lib_common.entity.ResultBean;
import com.wmy.lib_common.entity.ResultEntity;
import com.wmy.lib_common.http.OnResultListener;
import com.wmy.lib_common.http.okhttp.JsonCallback;
import com.wmy.modulelottery.bean.LotteryBean;

/**
 * @author wmy
 * @Description: 实现公共数据接口
 * @FileName: LotteryDataSource
 * @Date 2018/6/8/008 10:39
 */
public class LotteryDataSource implements DataSource {


    @Override
    public void getLotterys(int size, int page, LoadLotteryCallback callback) {
        OkGo.<ResultEntity<ResultBean<LotteryBean>>>post("http://route.showapi.com/44-6")//
                .tag(this)//
                //.isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params("showapi_appid", Constant.appid)        // 这里可以上传参数
                .params("showapi_sign", Constant.APPS)   // 可以添加文件上传
                .execute(new JsonCallback<ResultEntity<ResultBean<LotteryBean>>>() {
                    @Override
                    public void onError(Response<ResultEntity<ResultBean<LotteryBean>>> response) {
                        super.onError(response);

                    }

                    @Override
                    public void onSuccess(Response<ResultEntity<ResultBean<LotteryBean>>> response) {
                        if (callback != null)
                            callback.onDataLoaded(response.body().getShowapi_res_body().getResult());
                    }
                });
    }

    @Override
    public void getLotteryOpenPrizeData(LoadLotteryCallback callback) {
        OkGo.<ResultEntity<ResultBean<LotteryBean>>>post("http://route.showapi.com/44-1")//
                .tag(this)//
                //.isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params("showapi_appid", Constant.appid)        // 这里可以上传参数
                .params("showapi_sign", Constant.APPS)   // 可以添加文件上传
                .params("code","dlt|fc3d|pl3|pl5|qlc|qxc|ssq|zcbqc|zcjqc|zcsfc")
                .execute(new JsonCallback<ResultEntity<ResultBean<LotteryBean>>>() {
                    @Override
                    public void onError(Response<ResultEntity<ResultBean<LotteryBean>>> response) {
                        super.onError(response);
                    }

                    @Override
                    public void onSuccess(Response<ResultEntity<ResultBean<LotteryBean>>> response) {
                        if (callback != null)
                            callback.onDataLoaded(response.body().getShowapi_res_body().getResult());
                    }
                });
    }


}
