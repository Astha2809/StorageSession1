package com.example.storagesession1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button read;
    private Button write;
    private final static String FILE_NAME = "example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUi();
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readInFile();

            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeInFile();

            }
        });
    }

    void initUi() {
        textView = findViewById(R.id.text4);
        editText = findViewById(R.id.text3);
        read = findViewById(R.id.button4);
        write = findViewById(R.id.button5);

    }

    void writeInFile() {
        String text = editText.getText().toString();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            editText.getText().clear();
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void readInFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuilder.append(text).append("\n");
            }
            textView.setText(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
