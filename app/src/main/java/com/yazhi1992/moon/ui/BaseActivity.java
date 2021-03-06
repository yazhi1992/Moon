package com.yazhi1992.moon.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.yazhi1992.moon.R;
import com.yazhi1992.yazhilib.utils.LibStatusBarUtils;
import com.yazhi1992.yazhilib.utils.LibUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by zengyazhi on 2018/1/30.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
    }

    protected boolean displayBackBtnInToolber() {
        if (isTaskRoot()) {
            return false;
        } else {
            return true;
        }
    }

    protected void initStatusBar() {
        LibStatusBarUtils.with(this)
                .setColor(getResources().getColor(R.color.colorAccent))
                .init();
    }

    protected void initToolBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (displayBackBtnInToolber()) {
            //显示返回键
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickToolbarBack();
                }
            });
        }
    }

    protected void clickToolbarBack() {
        Observable.timer(300, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> finish());
    }

    private long mExitTime;

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isTaskRoot()) {
            // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - mExitTime > 2000) {
                LibUtils.showToast(this, getString(R.string.finish_app));
                // 将系统当前的时间赋值给exitTime
                mExitTime = System.currentTimeMillis();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
