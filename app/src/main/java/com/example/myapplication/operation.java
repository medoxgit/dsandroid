package com.example.myapplication;

public class operation {
   private String expression,resultat;

    public operation(String expression,String resultat) {
        this.resultat = resultat;
        this.expression = expression;
    }

    public String getResultat() {
        return resultat;
    }

    public String getExpression() {
        return expression;
    }
}
