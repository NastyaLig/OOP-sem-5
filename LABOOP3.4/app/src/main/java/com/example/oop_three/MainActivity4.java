package com.example.oop_three;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity4 extends AppCompatActivity {

    TextView result, resultEmail, resultPhone;
    Button back3, accept;
    String file_name = "Laba.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        result = (TextView) findViewById(R.id.textView6);
        resultEmail = (TextView) findViewById(R.id.textView8);
        back3 = (Button) findViewById(R.id.back3);
        resultPhone = (TextView) findViewById(R.id.textView7);

        Bundle arg = getIntent().getExtras();

        if (arg != null) {
            String company = arg.getString("company");
            String job = arg.getString("job");
            String email = arg.getString("email");
            String text = arg.getString("text");
            Boolean val = arg.getBoolean("val");
            String phone = arg.getString("phone");

            result.setText("Результат:" + "\n" + text + "\nНазвание организации:"
                    + company + "\nДолжность:" + job + "\nОпыт работы на удалённой основе:"
                    + val);

            resultEmail.setText("\nРабочий Email:" + email);

            resultPhone.setText("\nНомер телефона:" + phone);

            File f = new File(MainActivity4.super.getFilesDir(), file_name);
            try {
                f.createNewFile();
                Log.d("Log_02", "Файл" + file_name + "создан");
            } catch (IOException e) {
                Log.d("Log_02", "Файл" + file_name + " не создан");
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Создание файла" + file_name)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Log.d("Log_02", "Создание файла" + file_name);
                        dialogInterface.cancel();
                    }
                });
        AlertDialog ad = builder.create();
        ad.show();

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
            case R.id.back3:
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                break;
        }
    }

    public void WriteFile(View view) {
        FileOutputStream fos = null;
        try {
            result = (TextView) findViewById(R.id.textView6);
            resultEmail = (TextView) findViewById(R.id.textView8);
            resultPhone = (TextView) findViewById(R.id.textView7);
            String text = result.getText().toString();
            String resultemail = resultEmail.getText().toString();
            String resultphone = resultPhone.getText().toString();
            fos = openFileOutput(file_name, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.write(resultemail.getBytes());
            fos.write(resultphone.getBytes());
            Log.d("Lab_3", "Данные записаны");
        } catch (IOException ex) {
            Log.d("Lab_3", "Данные не записаны");
        }
    }



    public void ClickEmail(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Send");
        intent.setType("text/plain");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void ClickPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
