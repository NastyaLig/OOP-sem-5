package com.example.oop_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    Button next3;
    Button back2;
    TextView textView5;
    EditText namecompany, post, Email, Phone;
    Switch switch1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.d("Lab3", "MainActivity: onCreate()");
        next3 = (Button) findViewById(R.id.next3);
        back2 = (Button) findViewById(R.id.back2);
        textView5 = (TextView) findViewById(R.id.textView5);
        namecompany = (EditText) findViewById(R.id.namecompany);
        post = (EditText) findViewById(R.id.post);
        Email = (EditText) findViewById(R.id.Email);
        switch1 = (Switch) findViewById(R.id.switch1);
        Phone =  findViewById(R.id.Phone);

        Bundle argument = getIntent().getExtras();
        if (argument != null){
            String nameEducation = argument.get("nameEducation").toString();
            String specialization = argument.get("specialization").toString();
            Boolean getBox = argument.getBoolean("getBox", false);
            String getValues = argument.get("getValues").toString();

            textView5.setText( getValues +"\nУчебное заведение:" + nameEducation +
                    "\nСпециальность:" + specialization + "\nБыл опыт работы во время учёбы:"
                    + getBox);
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
            case R.id.next3:
                String company = namecompany.getText().toString();
                String job = post.getText().toString();
                String email = Email.getText().toString();
                Boolean Val = switch1.isChecked();
                String text = textView5.getText().toString();
                String phone = Phone.getText().toString();

                Intent intent = new Intent(this, MainActivity4.class);
                intent.putExtra("company", company);
                intent.putExtra("job", job);
                intent.putExtra("email", email);
                intent.putExtra("val", Val);
                intent.putExtra("text", text);
                intent.putExtra("phone", phone);

                startActivity(intent);
                break;
            case R.id.back2:
                Intent intent2 = new Intent(this, MainActivity2.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}