package com.example.storagesession1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button submit;
    private Button retrieve;
    private Button question2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();

            }
        });
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retreiveData();

            }
        });
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    void initUi() {
        editText = findViewById(R.id.text1);
        textView = findViewById(R.id.text2);
        submit = findViewById(R.id.button1);
        retrieve = findViewById(R.id.button2);
        question2 = findViewById(R.id.button3);
    }

    void submitData() {
        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);//so no other app can access
        // our data
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", editText.getText().toString());
        editor.apply();
        Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    void retreiveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        String name = sharedPreferences.getString("username", " ");
        textView.setText(name);
    }

}
