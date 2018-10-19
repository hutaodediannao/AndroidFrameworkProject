package com.hutao.androidappdesignproject.db.dbHelper;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.hutao.androidappdesignproject.model.Person;
import com.hutao.androidappdesignproject.model.Student;

import com.hutao.androidappdesignproject.db.dbHelper.PersonDao;
import com.hutao.androidappdesignproject.db.dbHelper.StudentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personDaoConfig;
    private final DaoConfig studentDaoConfig;

    private final PersonDao personDao;
    private final StudentDao studentDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        personDao = new PersonDao(personDaoConfig, this);
        studentDao = new StudentDao(studentDaoConfig, this);

        registerDao(Person.class, personDao);
        registerDao(Student.class, studentDao);
    }
    
    public void clear() {
        personDaoConfig.clearIdentityScope();
        studentDaoConfig.clearIdentityScope();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

}
