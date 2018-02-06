package com.yazhi1992.moon.viewmodel;

import com.avos.avoscloud.AVObject;
import com.yazhi1992.moon.constant.TableConstant;

/**
 * Created by zengyazhi on 2018/2/6.
 *
 * 首页数据包装类：文本
 */

public class TextBeanWrapper extends IHistoryBean<TextBean> {

    public TextBeanWrapper(AVObject loveHistoryItemData) {
        super(loveHistoryItemData);
    }

    @Override
    TextBean transformAvObject(AVObject loveHistoryItemData) {
        //纪念日类型
        AVObject textItemData = loveHistoryItemData.getAVObject(TableConstant.LoveHistory.TEXT);
        TextBean textBean = new TextBean(textItemData.getString(TableConstant.Text.CONTENT));
        textBean.setObjectId(textItemData.getObjectId());
        return textBean;
    }
}
