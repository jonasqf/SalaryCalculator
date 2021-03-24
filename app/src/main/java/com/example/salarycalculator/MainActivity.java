package com.example.salarycalculator;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtSalarioBruto;
    private EditText txtNumeroDepedentes;
    private EditText txtOutrosDescontos;

    private Button btnCalcular;
    private TextView txtResultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtSalarioBruto = findViewById(R.id.textSalarioBruto);
        txtNumeroDepedentes = findViewById(R.id.textNumeroDependentes);
        txtOutrosDescontos = findViewById(R.id.textOutrosDescontos);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.button_first);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txtSalarioBruto.getText().toString().length() == 0) {
                    txtSalarioBruto.setText(Float.toString(0));
                }

                if (txtOutrosDescontos.getText().toString().length() == 0) {
                    txtOutrosDescontos.setText(Float.toString(0));
                }

                if (txtNumeroDepedentes.getText().toString().length() == 0) {
                    txtNumeroDepedentes.setText(Integer.toString(0));
                }

                float salarioBruto = Float.parseFloat(txtSalarioBruto.getText().toString());
                int numeroDependentes = Integer.parseInt(txtNumeroDepedentes.getText().toString());
                float outrosDescontos = Float.parseFloat(txtOutrosDescontos.getText().toString());

                float INSS = 0;
                float IRRF = 0;
                float salarioLiquido = 0;
                float totalDescontos = 0;

                CalcularSalarioCLT calculoCLT = new CalcularSalarioCLT();
                calculoCLT.calcularSalario(salarioBruto, outrosDescontos, numeroDependentes);
                INSS = calculoCLT.getINSS();
                IRRF = calculoCLT.getIRRF();
                totalDescontos = calculoCLT.getTotalDescontos();
                salarioLiquido = calculoCLT.getSalarioLiquido();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("txtViewSalarioLiquido", Float.toString(salarioLiquido));
                intent.putExtra("txtValorDescontos", Float.toString(totalDescontos));
                intent.putExtra("txtValorINSS", Float.toString(INSS));
                intent.putExtra("txtValorIRRF", Float.toString(IRRF));
                intent.putExtra("txtValorSalarioBruto", Float.toString(salarioBruto));
                intent.putExtra("txtValorOutrosDescontos", Float.toString(outrosDescontos));

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}