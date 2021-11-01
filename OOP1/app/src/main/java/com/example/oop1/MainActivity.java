package com.example.oop1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.oop1.txt.TextFunction;

public class MainActivity extends AppCompatActivity {
//TODO Add new method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int count = 0; count < 10; count++) {
            Log.d("MainActivity", "counter=" + count);
        }
        displayText();
    }
   private void displayText() {
        TextFunction tf = new TextFunction();
        TextView nt=findViewById(R.id.newtest);
        nt.setText(tf.getValue());
    }
}