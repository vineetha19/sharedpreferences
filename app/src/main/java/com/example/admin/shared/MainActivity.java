package com.example.admin.shared;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    String str;


    public static final String NAME = "NAME";

    public static final String COLLEGENAME = "COLLEGENAME";

    public static final String BRANCH = "BRANCH";


    private SharedPreferences name;
    private SharedPreferences collegename;
    private SharedPreferences branch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.buttonID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText valueOneTxt = (EditText)findViewById(R.id.valueOne);
                EditText valueTwoTxt = (EditText)findViewById(R.id.valueTwo);
                EditText valueThreeTxt = (EditText)findViewById(R.id.valueThree);




              RadioGroup radioGroup = findViewById(R.id.group);
           radioGroup.clearCheck();

               radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  @SuppressLint("ResourceType")
                  @Override
                   public void onCheckedChanged(RadioGroup radioGroup, int i) {
                       RadioButton rb = radioGroup.findViewById(i);
                        if(null!=rb &&  i > -1){
                     Toast.makeText(MainActivity.this, rb.getText(),Toast.LENGTH_SHORT).show();
                           str = rb.getText().toString();
                       }
                   }
               });

               final Spinner spinner = (Spinner)findViewById(R.id.spinner);
               spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)MainActivity.this);
               List<String> a1 = new ArrayList<>();
               a1.add("chennai");
               a1.add("hyderabad");
               a1.add("banglore");
               a1.add("mumbai");

               ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item);
               adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               spinner.setAdapter(adapter);

                name = getSharedPreferences(MainActivity.NAME, Context.MODE_PRIVATE);
                collegename = getSharedPreferences(MainActivity.COLLEGENAME, Context.MODE_PRIVATE);
                branch = getSharedPreferences(MainActivity.BRANCH, Context.MODE_PRIVATE);
                SharedPreferences.Editor c =collegename.edit();
                SharedPreferences.Editor n = name.edit();
                SharedPreferences.Editor b = branch.edit();

                n.putString(MainActivity.NAME,valueOneTxt.getText().toString());
                c.putString(MainActivity.COLLEGENAME,valueTwoTxt.getText().toString());
                b.putString(MainActivity.BRANCH,valueThreeTxt.getText().toString());

                n.commit();
                c.commit();
                b.commit();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
