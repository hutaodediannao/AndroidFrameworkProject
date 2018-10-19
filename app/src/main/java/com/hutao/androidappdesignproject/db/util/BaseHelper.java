package com.hutao.androidappdesignproject.db.util;

import android.content.Context;
import android.database.SQLException;

import com.hutao.androidappdesignproject.util.ToastUtil;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.rx.RxDao;

import java.util.List;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by hutao on 2018-10-18.
 */

public class BaseHelper<T, K> {

    public Context mContext;
    public RxDao rxDao;

    public Database mDatabase;

    public BaseHelper(Context mContext) {
        this.mContext = mContext;
        mDatabase = DbSession.getDbHelperInstance(mContext).getDaoSession().getDatabase();
    }

    /**
     * 增加一条数据
     */
    public void insert(final T t) {
        if (rxDao != null)
        rxDao.insert(t)
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(mContext, "插入失败：" + throwable.getMessage());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        ToastUtil.showToast(mContext, "插入成功");
                    }
                });
    }

    /**
     * 删除一条数据
     */
    public void delete(final T t) {
        if (rxDao != null)
        rxDao.delete(t)
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(mContext, "删除失败：" + throwable.getMessage());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        ToastUtil.showToast(mContext, "删除成功");
                    }
                });
    }

    /**
     * 修改一条数据
     */
    public void update(final T t) {
        if (rxDao != null)
        rxDao.update(t)
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(mContext, "修改失败：" + throwable.getMessage());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        ToastUtil.showToast(mContext, "修改成功");
                    }
                });
    }

    /**
     * 查询一条数据
     */
    public void query(final K k) {
        if (rxDao != null)
        rxDao.load(k)
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        ToastUtil.showToast(mContext, o.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(mContext, "查询失败：" + throwable.getMessage());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        ToastUtil.showToast(mContext, "查询成功");
                    }
                });
    }

    /**
     * 执行自定义Sql语句
     */
    public void excuteSql(String sql) throws SQLException{
        mDatabase.execSQL(sql);
    }

    /**
     * 执行之定义Sql语句
     */
    public void excuteSql(String sql, String[] args) throws SQLException{
        mDatabase.execSQL(sql, args);
    }

}
