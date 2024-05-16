package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.text.TextUtils;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    Button btnzero;
    Button btnun;
    Button btndeux;
    Button btntrois;
    Button btnquatre;

    Button btncinq;
    Button btnsix;
    Button btnsept;
    Button btnhuit;
    Button btnneuf;
    Button btnback;
    Button btnplus;

    Button btndiv;

    Button btnfois;

    Button btnmoin;

    Button btnegal;

    Button btnvirgule;
    Button btnac;

    Button btnparaouv;
    Button btnparafer;

    Button btnpow;

    Button btnsqrt;

    Button btncos;
    Button btnsin;
    Button btntan;

    TextView tvExpr;
    TextView tvres;
    ListView lvoperation;

    SQLiteDatabase db;
    ArrayList<operation> operationsList = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnzero = findViewById(R.id.btnzero);
        btnun = findViewById(R.id.btnun);
        btndeux = findViewById(R.id.btndeux);
        btntrois = findViewById(R.id.btntrois);
        btnquatre = findViewById(R.id.btnquatre);
        btncinq = findViewById(R.id.btncinq);
        btnsix = findViewById(R.id.btnsix);
        btnsept = findViewById(R.id.btnsetp);
        btnhuit = findViewById(R.id.btnhuit);
        btnneuf = findViewById(R.id.btnneuf);
        btnback = findViewById(R.id.btnback);
        btnplus = findViewById(R.id.btnplus);
        btndiv = findViewById(R.id.btndiv);
        btnfois = findViewById(R.id.btnfois);
        btnmoin = findViewById(R.id.btnmoin);
        btnegal = findViewById(R.id.btnegal);
        btnac = findViewById(R.id.btnac);
        btnvirgule = findViewById(R.id.btnvirgule);
        btnparaouv = findViewById(R.id.btnparaouv);
        btnparafer = findViewById(R.id.btnparafer);
        btnpow = findViewById(R.id.btnpow);
        btnsqrt = findViewById(R.id.sqrt);
        btncos = findViewById(R.id.cos);
        btnsin = findViewById(R.id.sin);
        btntan = findViewById(R.id.tan);

        tvExpr = findViewById(R.id.tvExpr);
        tvres = findViewById(R.id.tvres);

        lvoperation=  findViewById(R.id.lvoperation);

        btnback.setOnClickListener(v -> deleteLastCharacter());


        btnparaouv.setOnClickListener(v -> {
            String buttonText = btnparaouv.getText().toString();
            displayOperationMath(buttonText);
        });

        btnparafer.setOnClickListener(v -> {
            String buttonText = btnparafer.getText().toString();
            displayOperationMath(buttonText);
        });


        btncos.setOnClickListener(v -> {
            String buttonText = btncos.getText().toString();
            displayOperationMath(buttonText);
        });

        btnsin.setOnClickListener(v -> {
            String buttonText = btnsin.getText().toString();
            displayOperationMath(buttonText);
        });

        btntan.setOnClickListener(v -> {
            String buttonText = btntan.getText().toString();
            displayOperationMath(buttonText);
        });

        btnpow.setOnClickListener(v -> {
            String buttonText = btnpow.getText().toString();
            displayOperationMath(buttonText);
        });

        btnsqrt.setOnClickListener(v -> {
            String buttonText = btnsqrt.getText().toString();
            displayOperationMath(buttonText);
        });

        btnzero.setOnClickListener(v -> {
            String buttonText = btnzero.getText().toString();
            displayOperationMath(buttonText);
        });
        btnun.setOnClickListener(v -> {
            String buttonText = btnun.getText().toString();
            displayOperationMath(buttonText);
        });
        btndeux.setOnClickListener(v -> {
            String buttonText = btndeux.getText().toString();
            displayOperationMath(buttonText);
        });
        btntrois.setOnClickListener(v -> {
            String buttonText = btntrois.getText().toString();
            displayOperationMath(buttonText);
        });



        btnquatre.setOnClickListener(v -> {
            String buttonText = btnquatre.getText().toString();
            displayOperationMath(buttonText);
        });

        btncinq.setOnClickListener(v -> {
            String buttonText = btncinq.getText().toString();
            displayOperationMath(buttonText);
        });
        btnsix.setOnClickListener(v -> {
            String buttonText = btnsix.getText().toString();
            displayOperationMath(buttonText);
        });
        btnsept.setOnClickListener(v -> {
            String buttonText = btnsept.getText().toString();
            displayOperationMath(buttonText);
        });
        btnhuit.setOnClickListener(v -> {
            String buttonText = btnhuit.getText().toString();
            displayOperationMath(buttonText);
        });
        btnneuf.setOnClickListener(v -> {
            String buttonText = btnneuf.getText().toString();
            displayOperationMath(buttonText);
        });
        btnplus.setOnClickListener(v -> {
            String buttonText = btnplus.getText().toString();
            displayOperationMath(buttonText);
        });

        btndiv.setOnClickListener(v -> {
            String buttonText = btndiv.getText().toString();
            displayOperationMath(buttonText);
        });

        btnfois.setOnClickListener(v -> {
            String buttonText = btnfois.getText().toString();
            displayOperationMath(buttonText);
        });

        btnmoin.setOnClickListener(v -> {
            String buttonText = btnmoin.getText().toString();
            displayOperationMath(buttonText);
        });

        btnvirgule.setOnClickListener(v -> {
            String buttonText = btnvirgule.getText().toString();
            displayOperationMath(buttonText);
        });



        btnac.setOnClickListener(v -> deleteOperationMath());








        btnegal.setOnClickListener(v ->{

            String texte = tvExpr.getText().toString();

            // Vérifier si le texte est null ou vide
            if (TextUtils.isEmpty(texte)) {
                // Si le texte est null ou vide, afficher un message d'erreur
                Toast.makeText(getApplicationContext(), "Le champ est vide", Toast.LENGTH_SHORT).show();
            } else {
                // Si le texte n'est pas null ou vide, évaluer l'expression et afficher le résultat
                double resultat = eval(texte);
                tvres.setText(String.valueOf(resultat));
                //ouvire||creer1
                db = openOrCreateDatabase("dbcalculatrice", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS operations(id INTEGER PRIMARY KEY AUTOINCREMENT, expression TEXT, resultat TEXT)");
                db.execSQL("INSERT INTO operations(expression,resultat) VALUES('" +
                        texte +
                        "','" + resultat+ "');");





                Cursor c = db.rawQuery("SELECT expression,resultat FROM operations", null);
                int a = c.getCount();

                if (c.moveToFirst()) {
                    do {
                        String op = c.getString(0);
                        String res = c.getString(1);

                        operation ope = new operation(op,res);
                        operationsList.add(ope);
                    } while (c.moveToNext());
                }

                c.close();

                 Toast.makeText(getApplicationContext(), "NB record : " + operationsList.size(), Toast.LENGTH_SHORT).show();


                //Collections.reverse(operationsList);

operationAdapter ad = new operationAdapter(this,R.layout.affexp,operationsList);
lvoperation.setAdapter(ad);


            }

        } );






    }



    private void deleteOperationMath() {

        tvExpr.setText("");
        tvres.setText("");


    }

    private void deleteLastCharacter() {

        String text = tvExpr.getText().toString();
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
            tvExpr.setText(text);
        }
    }

    private  String OperationMath(String expression) {
        String currentExp = tvExpr.getText().toString();
        currentExp= currentExp+ expression;
        return currentExp;
    }

    private  void displayOperationMath(String expression) {
        String resultat = OperationMath(expression);
        tvExpr.setText(resultat);
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
            // Grammar:
// expression = term | expression `+` term | expression `-` term
// term = factor | term `*` factor | term `/` factor
// factor = `+` factor | `-` factor | `(` expression `)` | number
// | functionName `(` expression `)` | functionName factor
// | factor `^` factor
            double parseExpression() {
                double x = parseTerm();
                for (;;) {

                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {

                        x = parseFactor();
                    }
                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                return x;
            }
        }.parse();
    }


}





