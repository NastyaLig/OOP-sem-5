package com.example.oop_three;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button next;
    EditText name, surname;
    Spinner spinner;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Lab3", "MainActivity: onCreate()");

        next = findViewById(R.id.next);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        spinner = findViewById(R.id.spinner);
        link = findViewById(R.id.textView9);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                String names = name.getText().toString();
                String surnames = surname.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("name", names);
                intent.putExtra("surname", surnames);
                intent.putExtra("spinner", spinner.getSelectedItem().toString());

                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void ClickLink (View view){
        Uri address = Uri.parse("https://www.instagram.com/nastyalig/");
        Intent openlink = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlink);
    }

    public void ClickImg(View view){
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setType("image/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}