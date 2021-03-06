package com.yazhi1992.moon.dialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.yazhi1992.moon.R;
import com.yazhi1992.moon.databinding.DialogDatePickerBinding;
import com.yazhi1992.moon.util.AppUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zengyazhi on 2018/1/23.
 * <p>
 * 日期选择弹窗
 */

public class DatePickerDialog extends DialogFragment {

    private DialogDatePickerBinding mBinding;
    private long mTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_date_picker, null, false);
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);
        return mBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        //设置 dialog 的背景为 null
        getDialog().getWindow().setBackgroundDrawable(null);
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mBinding.tvComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mComfirmlistener != null) {
                    mComfirmlistener.comfirm(mBinding.datePicker.getYear() + "-" + (mBinding.datePicker.getMonth() + 1) + "-" + mBinding.datePicker.getDayOfMonth());
                }
                dismiss();
            }
        });

        if (mTime != 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(mTime));
            mBinding.datePicker.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        }
    }

    public void show(FragmentManager manager) {
        manager.executePendingTransactions();
        if (!isAdded()) {
            show(manager, DatePickerDialog.class.getName());
        }
    }

    /**
     * 修改日期，原来就带了时间
     *
     * @param manager
     * @param time
     */
    public void show(FragmentManager manager, long time) {
        mTime = time;
        manager.executePendingTransactions();
        if (!isAdded()) {
            show(manager, DatePickerDialog.class.getName());
        }
    }

    Comfirmlistener mComfirmlistener;

    public void setComfirmlistener(Comfirmlistener comfirmlistener) {
        mComfirmlistener = comfirmlistener;
    }

    public interface Comfirmlistener {
        /**
         * 点击确定
         *
         * @param timeStr 返回日期字符串格式 yyyy-MM-dd
         */
        void comfirm(String timeStr);
    }
}
