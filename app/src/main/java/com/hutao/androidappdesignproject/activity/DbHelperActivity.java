package com.hutao.androidappdesignproject.activity;

import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hutao.androidappdesignproject.R;
import com.hutao.androidappdesignproject.db.util.PersonDbHelper;
import com.hutao.androidappdesignproject.model.Person;
import com.hutao.androidappdesignproject.util.StringUtil;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public class DbHelperActivity extends ToolBarActivity {

    private Person p;
    private EditText tvName, tvAge, tvAvator, tvCity;
    private TextView tvDisplay;
    private CheckBox cbStudent;
    private PersonDbHelper personDbHelper;

    @Override
    public String getToolbarTitleContent() {
        return "Greendao数据库操作";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_helper);
        initView();

        personDbHelper = new PersonDbHelper(this);
    }

    private void initView() {
        tvDisplay = findViewById(R.id.tvDisplay);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvCity = findViewById(R.id.tvCity);
        tvAvator = findViewById(R.id.tvAvator);
        cbStudent = findViewById(R.id.cbStudent);
    }

    public void insert(View view) {
        if (tvAvator.getText().length() == 0 || tvCity.getText().length() == 0
                || tvAge.getText().length() == 0 || tvName.getText().length() == 0) {
            showToast("数据不能为空");
            return;
        }
        p = new Person(tvCity.getText().toString(), tvAvator.getText().toString(), tvName.getText().toString(), Integer.parseInt(tvAge.getText().toString()), cbStudent.isChecked());
        personDbHelper.insert(p);
        tvDisplay.setText(personDbHelper.loadAll().toString());
    }

    public void update(View view) {
        String content = "'" + (int)(Math.random() * 100) + "hello'";
        String sql = "UPDATE HuTao_person SET name = " + content + " WHERE age > 0";
        try {
            personDbHelper.excuteSql(sql);
            String data = personDbHelper.loadAll().toString();
            tvDisplay.setText(data);
        } catch (SQLException e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void query(View view) {
        tvDisplay.setText(personDbHelper.loadAll().toString());
    }

    public void removeAll(View view) {
        personDbHelper.deleteAll();
        tvDisplay.setText(personDbHelper.loadAll().toString());
    }
}
