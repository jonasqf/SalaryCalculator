package com.example.salarycalculator;

import java.text.DecimalFormat;

public class CalcularSalarioCLT {
    private float salarioBruto=0;
    private float outrosDescontos=0;
    private int   numeroDependentes=0;
    private float INSS = 0;
    private float IRRF = 0;
    private float salarioLiquido =0;
    private float totalDescontos =0;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public void calcularSalario (float salarioBruto, float outrosDescontos, int numeroDependentes ) {
        this.salarioBruto = salarioBruto;
        this.outrosDescontos = outrosDescontos;
        this.numeroDependentes = numeroDependentes;
        this.INSS = calculaINSS(salarioBruto);
        this.IRRF = calculaIRRF(salarioBruto, this.INSS, numeroDependentes);
        this.salarioLiquido = calculaSalarioLiquido();
        this.totalDescontos = calculaDescontos();
    }

    private float calculaINSS (float salarioBruto) {

        if (salarioBruto <= 1045) {
            INSS = 0;
        } else if (salarioBruto <= 2089.60) {
            INSS = salarioBruto * (float) 0.09 - (float) 15.67;
        } else if (salarioBruto <= 3134.40) {
            INSS = salarioBruto * (float) 0.12 - (float) 78.36;
        } else {
            INSS = salarioBruto * (float) 0.14 - (float) 141.05;
        }

        return Float.parseFloat(df.format(INSS));
    }

    private float calculaIRRF (float salarioBruto, float INSS, int numeroDependentes) {

        float base = salarioBruto - INSS - (numeroDependentes * (float) 189.59);

        if (base <= 1903.38) {
            IRRF = 0;
        } else if (base <= 2826.65) {
            IRRF = base * (float) 0.075 - (float) 142.80;
        } else if (base <= 3751.05) {
            IRRF = base * (float) 0.15 - (float) 354.80;
        } else if (base <= 4664.68) {
            IRRF = base * (float) 0.225 - (float) 636.13;
        } else {
            IRRF = base * (float) 0.275 - (float) 869.36;
        }
        return Float.parseFloat(df.format(IRRF));
    }

    private float calculaSalarioLiquido () {

        float liquido = this.salarioBruto - this.INSS - this.IRRF - this.outrosDescontos;

        return Float.parseFloat(df.format(liquido));
    }

    private float calculaDescontos () {

        float descontos = ((this.INSS + this.IRRF + this.outrosDescontos) / this.salarioBruto)*100;

        return Float.parseFloat(df.format(descontos));
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getOutrosDescontos() {
        return outrosDescontos;
    }

    public void setOutrosDescontos(float outrosDescontos) {
        this.outrosDescontos = outrosDescontos;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    public float getINSS() {
        return INSS;
    }

    public void setINSS(float INSS) {
        this.INSS = INSS;
    }

    public float getIRRF() {
        return IRRF;
    }

    public void setIRRF(float IRRF) {
        this.IRRF = IRRF;
    }

    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(float salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public float getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos(float totalDescontos) {
        this.totalDescontos = totalDescontos;
    }
}
