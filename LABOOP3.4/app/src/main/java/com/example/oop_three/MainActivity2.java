package com.example.oop_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button next2;
    Button back;
    TextView textview4;
    EditText nameeducation, specialization;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d("Lab3", "MainActivity: onCreate()");

        next2 =  findViewById(R.id.next2);
        back =  findViewById(R.id.back);
        textview4 =  findViewById(R.id.textView4);
        nameeducation =  findViewById(R.id.nameeducation);
        specialization =  findViewById(R.id.specialization);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null){
            String name = arguments.get("name").toString();
            String surname = arguments.get("surname").toString();
            String spinner = arguments.getString("spinner");

            textview4.setText("Имя: " + name + "\nФамилия: " + surname +
                    "\nОбразование: " + spinner);
        }
    }
    protected void onStart() {
        super.onStart();
        Log.d("Lab3", "MainActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lab3", "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lab3", "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lab3", "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lab3", "MainActivity: onDestroy()");
    }

    public void Onclick(View view){
        switch (view.getId()){
            case R.id.next2:
                String nameEducation = nameeducation.getText().toString();
                String specializations = specialization.getText().toString();
                Boolean getBox = checkBox.isChecked();
                String getValues = textview4.getText().toString();

                Intent intent = new Intent(this, MainActivity3.class);
                intent.putExtra("nameEducation", nameEducation);
                intent.putExtra("specialization", specializations);
                intent.putExtra("getBox", getBox);
                intent.putExtra("getValues", getValues);

                startActivity(intent);
                break;
            case R.id.back:
                Intent intentBack = new Intent(this, MainActivity.class);

                startActivity(intentBack);
                break;
            default:
                break;
        }
    }
}