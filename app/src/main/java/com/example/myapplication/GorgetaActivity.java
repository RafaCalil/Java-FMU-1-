package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class GorgetaActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textViewValor;
    private SeekBar seekBar;
    private TextView textViewPorcentagem;
    private TextView textViewGorgeta;
    private TextView textViewTotal;
    private Double porcentagem = 0.0;
    private Double valor = 0.0;
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat = NumberFormat.getPercentInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gorgeta);
        editTextValor = findViewById(R.id.editTextValor);
        textViewValor = findViewById(R.id.textViewValor);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        seekBar = findViewById(R.id.seekBar);
        textViewGorgeta = findViewById(R.id.textViewGorgeta);
        textViewTotal = findViewById(R.id.textViewTotal);

        editTextValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int valorInt;
                try {
                    valorInt = Integer.parseInt(editTextValor.getText().toString());
                } catch (NumberFormatException e ){
                    valorInt = 0;
                }
                valor = valorInt/100.00;
                atualizarValores();


            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress/100.0;
                atualizarValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



    }
      private void atualizarValores(){
        textViewValor.setText(currencyFormat.format(valor));
        textViewPorcentagem.setText(percentFormat.format(porcentagem));
        double gorgeta = valor * porcentagem;
        textViewGorgeta.setText(currencyFormat.format(gorgeta));
        double total = valor + gorgeta;
        textViewTotal.setText(currencyFormat.format(total));


}

}