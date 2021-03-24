package com.example.salarycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView txtViewSalarioBruto;
    private TextView txtViewNumeroDependentes;
    private TextView txtViewOutrosDescontos;
    private TextView txtViewINSS;
    private TextView txtViewIRRF;

    private TextView txtViewTotalDescontos;

    private TextView txtViewSalarioLiquido;
    private Button btnVoltar;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        txtViewSalarioLiquido = findViewById(R.id.txtViewSalarioLiquido);
        txtViewINSS = findViewById(R.id.txtValorINSS);
        txtViewIRRF = findViewById(R.id.txtValorIRRF);
        txtViewSalarioBruto = findViewById(R.id.txtValorSalarioBruto);
        txtViewOutrosDescontos = findViewById(R.id.txtValorOutrosDescontos);
        txtViewTotalDescontos = findViewById(R.id.txtValorDescontos);


        String salarioLiquido = getIntent().getStringExtra("txtViewSalarioLiquido");
        String INSS = getIntent().getStringExtra("txtValorINSS");
        String IRRF = getIntent().getStringExtra("txtValorIRRF");
        String salarioBruto = getIntent().getStringExtra("txtValorSalarioBruto");
        String outrosDescontos = getIntent().getStringExtra("txtValorOutrosDescontos");
        String descontos = getIntent().getStringExtra("txtValorDescontos");

        txtViewSalarioLiquido.setText(salarioLiquido);
        txtViewSalarioBruto.setText(salarioBruto);
        txtViewINSS.setText(INSS);
        txtViewIRRF.setText(IRRF);
        txtViewOutrosDescontos.setText(outrosDescontos);
        txtViewTotalDescontos.setText(descontos);

        btnVoltar = findViewById(R.id.button_second);

        btnVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
        }
}
