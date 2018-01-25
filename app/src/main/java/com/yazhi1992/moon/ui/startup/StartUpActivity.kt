package com.yazhi1992.moon.ui.startup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yazhi1992.moon.R
import com.yazhi1992.moon.sql.DatabaseManager
import com.yazhi1992.moon.widget.PageRouter
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class StartUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up)

        Observable.timer(500, TimeUnit.MILLISECONDS)
                .subscribe { start() }
    }

    private fun start() {
        val userDao = DatabaseManager.getInstance().userDao
        if (userDao.size == 0) {
            //未登录
            PageRouter.gotoLogin()
        } else {
            PageRouter.gotoHomePage()
        }
        finish()
    }

}
