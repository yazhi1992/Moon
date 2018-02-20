package com.yazhi1992.moon.viewmodel;

/**
 * Created by zengyazhi on 2018/2/19.
 */

public class ConfigBean {
    private boolean canPushImg = true;
    private int mcGoMinDay= 25;
    private int mcGoMaxDay= 37;
    private int mcComeMaxDay = 3;

    public int getMcGoMinDay() {
        return mcGoMinDay;
    }

    public void setMcGoMinDay(int mcGoMinDay) {
        this.mcGoMinDay = mcGoMinDay;
    }

    public int getMcGoMaxDay() {
        return mcGoMaxDay;
    }

    public void setMcGoMaxDay(int mcGoMaxDay) {
        this.mcGoMaxDay = mcGoMaxDay;
    }

    public int getMcComeMaxDay() {
        return mcComeMaxDay;
    }

    public void setMcComeMaxDay(int mcComeMaxDay) {
        this.mcComeMaxDay = mcComeMaxDay;
    }

    public boolean isCanPushImg() {
        return canPushImg;
    }

    public void setCanPushImg(boolean canPushImg) {
        this.canPushImg = canPushImg;
    }
}
