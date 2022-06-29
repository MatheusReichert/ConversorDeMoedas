package com.example.conversordemoedas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.valor_em_reais);
        this.mViewHolder.dolarTextView = findViewById(R.id.valor_em_dolar);
        this.mViewHolder.euroTextView = findViewById(R.id.valor_em_euro);
        this.mViewHolder.calcularButton = findViewById(R.id.button_calcular);

        this.clearValues();

        this.mViewHolder.calcularButton.setOnClickListener(view -> {

            String stringValorEmReais = this.mViewHolder.editValue.getText()
                    .toString();
            if("".equals(stringValorEmReais)){
                Toast.makeText(this, "Digite algum valor...", Toast.LENGTH_LONG).show();
            }
            else{

                Double valorEmReais = Double.valueOf(stringValorEmReais);


                this.mViewHolder.dolarTextView.setText(String.format("%.2f", valorEmReais/5.25));
                this.mViewHolder.euroTextView.setText(String.format("%.2f", valorEmReais/5.50));
            }

        });
    }

    private void clearValues(){
        this.mViewHolder.euroTextView.setText("");
        this.mViewHolder.dolarTextView.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView dolarTextView;
        TextView euroTextView;
        Button calcularButton;
    }
}