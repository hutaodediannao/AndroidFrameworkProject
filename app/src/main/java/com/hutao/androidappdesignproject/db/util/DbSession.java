package com.hutao.androidappdesignproject.db.util;

import android.content.Context;

import com.hutao.androidappdesignproject.db.dbHelper.DaoMaster;
import com.hutao.androidappdesignproject.db.dbHelper.DaoSession;

/**
 * Created by hutao on 2018-10-18.
 */

public class DbSession {

    private static final String TAG = "BaseDbHelper";
    private static final String DB_NAME = "HuTao.db";
    private static DbSession dbHelperInstance;
    private DaoSession daoSession;
    private Context mContext;

    public static DbSession getDbHelperInstance(Context context) {
        if (dbHelperInstance == null) {
            synchronized (DbSession.class) {
                if (dbHelperInstance == null) {
                    dbHelperInstance = new DbSession(context);
                }
            }
        }
        return dbHelperInstance;
    }

    private DbSession(Context context) {
        this.mContext = context;
//        daoSession = DaoMaster.newDevSession(context, DB_NAME);//daoSession不能使用单例，否则会出现无法修改的bug
    }

    public DaoSession getDaoSession() {
        return DaoMaster.newDevSession(mContext, DB_NAME);
    }
}
