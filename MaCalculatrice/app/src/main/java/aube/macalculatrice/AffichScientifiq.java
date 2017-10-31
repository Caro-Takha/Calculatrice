package aube.macalculatrice;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class AffichScientifiq extends AppCompatActivity {


    private Button mGenerateEgalButton;
    private TextView mViewText;
    private Button bMult;
    private Button bDiv;
    private Button bPlus;
    private Button bMoins;
    private Button bVirgule;
    private Button bClear;
    private Button bPercent;
    private Button bCos;
    private Button bSin;
    private Button bArcsin;
    private Button bArccos;
    private Button bExp;
    private Button bLn;
    private Button bPi;
    private Button bPuissance;
    private double val;
    private String aff="";
    private String valS = "";
    private double valprecedent;
    private double valAvantPuissance=0;
    private ArrayList<Button> ListeBoutons;
    private String operateur = "";
    private String fonction="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientifiq);
        Intent intent = getIntent();
        mViewText = (TextView) findViewById(R.id.textResultat);
        mGenerateEgalButton = (Button) findViewById(R.id.egalButton);
        ListeBoutons = new ArrayList(); //On crÃ©e la liste contenant les 9 boutons
        ListeBoutons.add((Button) findViewById(R.id.b0));
        ListeBoutons.add((Button) findViewById(R.id.b1));
        ListeBoutons.add((Button) findViewById(R.id.b2));
        ListeBoutons.add((Button) findViewById(R.id.b3));
        ListeBoutons.add((Button) findViewById(R.id.b4));
        ListeBoutons.add((Button) findViewById(R.id.b5));
        ListeBoutons.add((Button) findViewById(R.id.b6));
        ListeBoutons.add((Button) findViewById(R.id.b7));
        ListeBoutons.add((Button) findViewById(R.id.b8));
        ListeBoutons.add((Button) findViewById(R.id.b9));
        bPlus = (Button) findViewById(R.id.bPlus);
        bMoins = (Button) findViewById(R.id.bMoins);
        bMult = (Button) findViewById(R.id.bMult);
        bDiv = (Button) findViewById(R.id.bDiv);
        bVirgule = (Button) findViewById(R.id.bVirgule);
        bClear = (Button) findViewById(R.id.bClear);
        bPercent = (Button) findViewById(R.id.bPercent);
        bArccos=(Button) findViewById(R.id.bArccos);
        bArcsin=(Button) findViewById(R.id.bArcsin);
        bCos=(Button) findViewById(R.id.bCos);
        bSin=(Button) findViewById(R.id.bSin);
        bExp=(Button) findViewById(R.id.bExp);
        bLn=(Button) findViewById(R.id.bLn);
        bPi=(Button) findViewById(R.id.bPi);
        bPuissance=(Button) findViewById(R.id.bPuissance);

        for (int i = 0; i < 10; i++) {
            final int valb = i;
            ListeBoutons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    valS = valS + String.valueOf(valb);
                    aff=aff+String.valueOf(valb);
                    Log.v("valS APP TAG", valS);
                    Log.v("aff APP TAG", aff);
                    val = Double.parseDouble(valS);
                    Log.v("val APP TAG", String.valueOf(val));

                    mViewText.setText(aff);
                }
            });
        }

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent, val)));
                valprecedent = egal(valprecedent, val);
                operateur = "+";
                val = 0;
                valS = "";
                aff="";
                fonction="";
            }
        });


        bMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent, val)));
                valprecedent = egal(valprecedent, val);
                operateur = "-";
                val = 0;
                valS = "";
                aff="";
                fonction="";
            }
        });

        bMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent, val)));
                valprecedent = egal(valprecedent, val);
                operateur = "x";
                val = 0;
                valS = "";
                aff="";
                fonction="";
            }
        });


        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent, val)));
                valprecedent = egal(valprecedent, val);
                operateur = "/";
                val = 0;
                valS = "";
                aff="";
                fonction="";
            }
        });


        mGenerateEgalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent, val)));
                operateur = "";
                aff="";
                val = 0;
                valS = "";
                fonction="";
            }
        });

        bVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff=aff + ".";
                valS = valS + ".";
                val = Double.parseDouble(valS);
                mViewText.setText(aff);
            }
        });

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff="";
                valS = "";
                val = 0;
                mViewText.setText(valS);
                fonction="";
                operateur="";
                valprecedent=0;
            }
        });

        bPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff = aff + "%";
                if (operateur.equals("+")) {
                    val = valprecedent * (val / 100);
                }
                if (operateur.equals("-")) {
                    val = valprecedent * (val / 100);
                }
                if (operateur.equals("x")) {
                    val = val / 100;
                }
                mViewText.setText(valS);
            }
        });

        bCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="cos";
                aff = "cos ";
                mViewText.setText(aff);
            }
        });

        bSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="sin";
                aff = "sin ";
                mViewText.setText(aff);
            }
        });

        bArccos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="arccos";
                aff = "arccos ";
                mViewText.setText(aff);
            }
        });

        bArcsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="arcsin";
                aff = "arcsin ";
                mViewText.setText(aff);
            }
        });

        bExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="exp";
                aff = "exp ";
                mViewText.setText(aff);
            }
        });

        bLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="ln";
                aff = "ln ";
                mViewText.setText(aff);
            }
        });

        bPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val=Math.PI;
                aff = String.valueOf(val);
                mViewText.setText(aff);
            }
        });

        bPuissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fonction="^";
                valAvantPuissance=val;
                val=0;
                valS="";
                aff = aff+"^";
                mViewText.setText(aff);
            }
        });
    }

    public double egal(double v1, double v2) {
        double resultat = 0;
        if (fonction.equals("cos")){
            v2=Math.cos(v2);
        }
        if (fonction.equals("sin")){
            v2=Math.sin(v2);
        }
        if (fonction.equals("arccos")){
            v2=Math.acos(v2);
        }
        if (fonction.equals("arcsin")){
            v2=Math.asin(v2);
        }
        if (fonction.equals("exp")){
            v2=Math.exp(v2);
        }
        if (fonction.equals("ln")){
            v2=Math.log(v2);
        }
        if (fonction.equals("^")){
            v2=Math.pow(valAvantPuissance,v2);
        }
        if (operateur.equals("+")) {
            resultat = v1 + v2;
        }
        if (operateur.equals("-")) {
            resultat = v1 - v2;
        }
        if (operateur.equals("x")) {
            resultat = v1 * v2;
        }
        if (operateur.equals("/")) {
            resultat = v1 / v2;
        }
        if (operateur.equals("")) {
            resultat = v2;
        }


        return resultat;
    }

    public void cacheScientifiq(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

