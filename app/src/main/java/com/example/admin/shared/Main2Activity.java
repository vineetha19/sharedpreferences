package com.example.admin.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private SharedPreferences name;
    private SharedPreferences collegename;
    private SharedPreferences branch;
    private SharedPreferences gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = getSharedPreferences(MainActivity.NAME, Context.MODE_PRIVATE);
        collegename = getSharedPreferences(MainActivity.COLLEGENAME,Context.MODE_PRIVATE);
        branch = getSharedPreferences(MainActivity.BRANCH,Context.MODE_PRIVATE);
        gender = getSharedPreferences(MainActivity.GENDER,Context.MODE_PRIVATE);

        TextView tv1 = (TextView)findViewById(R.id.textview1);
        TextView tv2 = (TextView)findViewById(R.id.textview2);
        TextView tv3 = (TextView)findViewById(R.id.textview3);

        tv1.setText(name.getString(MainActivity.NAME,"NA"));
        tv2.setText(collegename.getString(MainActivity.COLLEGENAME,"NA"));
        tv3.setText(branch.getString(MainActivity.BRANCH,"NA"));
    }
}
