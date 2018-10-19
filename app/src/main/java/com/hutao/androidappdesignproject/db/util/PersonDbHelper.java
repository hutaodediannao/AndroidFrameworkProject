package com.hutao.androidappdesignproject.db.util;

import android.content.Context;

import com.hutao.androidappdesignproject.db.dbHelper.PersonDao;
import com.hutao.androidappdesignproject.model.Person;
import com.hutao.androidappdesignproject.util.ToastUtil;

import java.util.List;

import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by hutao on 2018-10-18.
 */

public class PersonDbHelper extends BaseHelper {

    public PersonDbHelper(Context context) {
        super(context);
        rxDao = DbSession.getDbHelperInstance(context).getDaoSession().getPersonDao().rx();
    }

    public void deletePerson(Person person) {
        rxDao.deleteByKey(person.get_id())
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(mContext, "删除失败");
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        ToastUtil.showToast(mContext, "删除成功");
                    }
                });
    }

    /**
     * 根据名字删除person
     */
    public void deletePerson(String name, String age) {
        String sql = "Delete FROM HuTao_person WHERE NAME = ? AND AGE = ?";
        String[] args = {name, age};
        excuteSql(sql, args);
    }

    /**
     * 根据年龄查询条件搜索
     */
    public List<Person> queryPersonList(String age) {
        return DbSession.getDbHelperInstance(mContext)
                .getDaoSession()
                .getPersonDao()
                .queryBuilder()
                .where(PersonDao.Properties.Age.eq(age))
                .build().list();
    }

    /**
     * 分页查询
     */
    public List<Person> queryPersonListByLimit(int offest, int limit) {
        return DbSession.getDbHelperInstance(mContext)
                .getDaoSession()
                .getPersonDao()
                .queryBuilder()
                .offset(offest)
                .limit(limit)
                .build()
                .list();
    }

    public void deleteAll() {
        DbSession.getDbHelperInstance(mContext).getDaoSession().getPersonDao().deleteAll();
    }


    public List<Person> loadAll() {
        return DbSession.getDbHelperInstance(mContext).getDaoSession().getPersonDao().loadAll();
    }


}
