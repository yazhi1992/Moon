package com.yazhi1992.moon.sql;

import java.util.List;

/**
 * Created by zengyazhi on 2018/1/26.
 */

public class UserDaoUtil extends BaseDao<User> {

    public void clear() {
        deleteAll(User.class);
    }

    public void  getUserDaoAsyn(DaoCallback.QueryCallback<User> callback) {
        queryAllAsyn(User.class, null, result -> {
            if(result != null && result.size() > 0) {
                callback.onCallback(result.get(0));
            } else {
                callback.onCallback(null);
            }
        });
    }

    public User getUserDao() {
        List<User> result = queryAll(User.class, null);
        if(result != null && result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public void updateLoveId(String loverId) {
        User userDao = getUserDao();
        userDao.setHaveLover(true);
        userDao.setLoverId(loverId);
        update(userDao);
    }

    public void updateLoveInfo(String name, String headUrl) {
        User userDao = getUserDao();
        userDao.setLoverName(name);
        userDao.setLoverHeadUrl(headUrl);
        update(userDao);
    }

    public void updateGender(int gender) {
        User userDao = getUserDao();
        userDao.setGender(gender);
        update(userDao);
    }

    public void updateUserName(String userName) {
        User userDao = getUserDao();
        userDao.setName(userName);
        update(userDao);
    }

    public void updateUserHeadUrl(String url) {
        User userDao = getUserDao();
        userDao.setHeadUrl(url);
        update(userDao);
    }

    public void updateEmailStatus(boolean valid) {
        User userDao = getUserDao();
        userDao.setEmailVerified(valid);
        update(userDao);
    }

    public void update(User user) {
        updateSingle(user);
    }
}
