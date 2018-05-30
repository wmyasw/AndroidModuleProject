package com.wmy.module_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wmy.lib_common.base.BaseActionBarActivity;

@Route(path = "/login")
public class LoginActivity extends BaseActionBarActivity {

    @Override
    protected int setTitleId() {
        return R.string.app_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
