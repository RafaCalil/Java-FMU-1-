package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText;

    private EditText editTextText2;

    private EditText editTextText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
    }

    public void somar(View view){
        int x = Integer.parseInt(editTextText.getText().toString());
        int y = Integer.parseInt(editTextText2.getText().toString());
        int soma = x + y;
        String msg = Integer.toString(soma);
        editTextText3.setText(Integer.toString(x+y));




    }
    public void abrirJanela(View view){
        int x = Integer.parseInt(editTextText.getText().toString());
        int y = Integer.parseInt(editTextText2.getText().toString());
        int soma = x + y;
        String msg = Integer.toString(soma);
        Intent intent = new Intent (this, MainActivity2.class);
        startActivity(intent);
        intent.putExtra("soma",msg);
        startActivity(intent);


    }



}