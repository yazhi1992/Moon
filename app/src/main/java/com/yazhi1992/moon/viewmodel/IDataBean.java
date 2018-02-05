package com.yazhi1992.moon.viewmodel;

import java.util.Date;

/**
 * Created by zengyazhi on 2018/2/5.
 */

public class IDataBean {
    private String mObjectId;
    private Date mCreateTime;
    private Date mUpdateTime;

    public String getObjectId() {
        return mObjectId;
    }

    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

    public Date getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(Date createTime) {
        mCreateTime = createTime;
    }

    public Date getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        mUpdateTime = updateTime;
    }
}