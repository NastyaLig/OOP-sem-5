package com.example.lab_oop2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    public void userLS(User user) {
        RadioGroup LS = findViewById(R.id.radioGroup);
        if(LS.getCheckedRadioButtonId() != -1)
        {
            int bid = LS.getCheckedRadioButtonId();
            Button button = findViewById(bid);
            if(button == findViewById(R.id.radioButton))
            { user.userLifeStyle = 1.2; }
            else if(button == findViewById(R.id.radioButton2))
            { user.userLifeStyle = 1.55; }
            else if(button == findViewById(R.id.radioButton3))
            { user.userLifeStyle = 1.9; }
        }
        else {  }

    }

    public void ButClick(View view) {
        TextView T = findViewById(R.id.textView2);
        T.setText("");
        try
        {
            User user1 = new User();
            userLS(user1);
            TextView T1 = findViewById(R.id.ves);
            user1.userWeigth = Integer.parseInt(T1.getText().toString());
            TextView T2 = findViewById(R.id.rost);
            user1.userWeigth = Integer.parseInt(T2.getText().toString());
            TextView T3 = findViewById(R.id.vozrast);
            user1.userWeigth = Integer.parseInt(T3.getText().toString());
            Switch S1 = findViewById(R.id.switch1);
            user1.userSex = S1.getShowText();
            TextView Tf = findViewById(R.id.textView7);
            Tf.setText(String.valueOf(user1.GetNumberOfCalories(user1)));
        }
        catch(Exception e)
        {
            T.setText("Ошибка при вводе данных");
        }
    }
}