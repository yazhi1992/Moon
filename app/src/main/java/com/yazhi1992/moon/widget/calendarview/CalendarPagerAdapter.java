package com.yazhi1992.moon.widget.calendarview;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * Created by zengyazhi on 2018/3/22.
 */

public class CalendarPagerAdapter extends PagerAdapter {

    private int count;
    private int[] startDate;//日历的开始年、月
    private SparseArray<MonthView> mViews = new SparseArray<>();
    //缓存上一次回收的MonthView
    private LinkedList<MonthView> cache = new LinkedList<>();
    private DateBean lastClickDate;
    private DayView lastClickedView;//记录上次点击的Item
    private boolean mClickble;

    public CalendarPagerAdapter(boolean clickble, int count, int[] startDate) {
        this.count = count;
        this.startDate = startDate;
        this.mClickble = clickble;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public SparseArray<MonthView> getViews() {
        return mViews;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        MonthView view;
        if(!cache.isEmpty()) {
            view = cache.removeFirst();
        } else {
            view = new MonthView(container.getContext());
            view.setOnSingleChooseListener(new OnSingleChooseListener() {
                @Override
                public void onSingleChoose(View view, DateBean date, int position) {
                    if(lastClickedView != null) {
                        lastClickDate.setClicked(false);
                        lastClickedView.setDataBean(lastClickDate);
                    }
                    date.setClicked(true);
                    lastClickedView = (DayView) view;
                    lastClickDate = date;
                    lastClickedView.setDataBean(lastClickDate);
                }
            });
        }
        view.setClickble(mClickble);
        int[] date = CalendarUtil.positionToDate(position, startDate[0], startDate[1]);
        view.setBuildInfo(date[0], date[1], CalendarUtil.getMonthDays(date[0], date[1]));
//        view.setDateList(CalendarUtil.getMonthDate(date[0], date[1]), CalendarUtil.getMonthDays(date[0], date[1]));
        mViews.put(position, view);
        container.addView(view);
        return view;
    }

    public void setClickble(boolean clickble) {
        mClickble = clickble;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((MonthView) object);
        cache.addLast((MonthView) object);
        mViews.remove(position);
    }
}
