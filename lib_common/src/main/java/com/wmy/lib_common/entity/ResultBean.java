package com.wmy.lib_common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/5/30/030.
 */

public class ResultBean<T> implements Serializable {
    public List<T> result;
    public Long ret_code;

    public Long getRet_code() {
        return ret_code;
    }

    public void setRet_code(Long ret_code) {
        this.ret_code = ret_code;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult( List<T> result) {
        this.result = result;
    }
}
