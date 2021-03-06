package aube.macalculatrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mGenerateEgalButton;
    private TextView mViewText;
    private Button bMult;
    private Button bDiv;
    private Button bPlus;
    private Button bMoins;
    private Button bVirgule;
    private Button bClear;
    private Button bPercent;
    public static double val;
    public static String aff;
    public static String valS;
    public static double valprecedent;
    private ArrayList<Button> ListeBoutons;
    public static String operateur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        bPlus= (Button) findViewById(R.id.bPlus);
        bMoins= (Button) findViewById(R.id.bMoins);
        bMult= (Button) findViewById(R.id.bMult);
        bDiv= (Button) findViewById(R.id.bDiv);
        bVirgule=(Button) findViewById(R.id.bVirgule);
        bClear=(Button) findViewById(R.id.bClear);
        bPercent=(Button) findViewById(R.id.bPercent);

        if (valS==null){
            valS="";
        }
        if (aff==null){
            aff="";
        }
        if (operateur==null){
            operateur="";
        }

        mViewText.setText(aff);
        aff="";


        for (int i = 0; i < 10; i++){
            final int valb=i;
            ListeBoutons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    valS=valS+String.valueOf(valb);
                    Log.v("valS APP TAG",valS);
                    //val = val * 10 + valb;
                    val=Double.parseDouble(valS);
                    aff=valS;
                    Log.v("val APP TAG",String.valueOf(val));
                    mViewText.setText(valS);
                }
            });
        }

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff=String.valueOf(egal(valprecedent,val));
                mViewText.setText(aff);
                valprecedent=egal(valprecedent,val);
                operateur="+";
                val=0;
                valS="";
            }
        });


        bMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff=String.valueOf(egal(valprecedent,val));
                mViewText.setText(aff);
                valprecedent=egal(valprecedent,val);
                operateur="-";
                val=0;
                valS="";
            }
        });

        bMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff=String.valueOf(egal(valprecedent,val));
                mViewText.setText(aff);
                valprecedent=egal(valprecedent,val);
                operateur="x";
                val=0;
                valS="";
            }
        });


        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff=String.valueOf(egal(valprecedent,val));
                mViewText.setText(aff);
                valprecedent=egal(valprecedent,val);
                operateur="/";
                val=0;
                valS="";
            }
        });


        mGenerateEgalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff=String.valueOf(egal(valprecedent,val));
                mViewText.setText(aff);
                operateur="";
                val=0;
                valS="";
            }
        });

        bVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valS=valS+String.valueOf(".");
                val=Double.parseDouble(valS);
                mViewText.setText(valS);
            }
        });

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aff="";
                valS="";
                val=0;
                valprecedent=0;
                mViewText.setText(valS);
            }
        });

        bPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valS=valS+"%";
                if (operateur.equals("+")){
                    val=valprecedent*(val/100);
                }
                if (operateur.equals("-")){
                    val=valprecedent*(val/100);
                }
                if (operateur.equals("x")) {
                    val = val / 100;
                }
                mViewText.setText(valS);
            }
        });


    }

    public double egal(double v1, double v2){
        double resultat= 0;
        if (operateur.equals("+")){
            resultat=v1+v2;
        }
        if (operateur.equals("-")){
            resultat=v1-v2;
        }
        if (operateur.equals("x")){
            resultat=v1*v2;
        }
        if (operateur.equals("/")){
            resultat=v1/v2;
        }
        if (operateur.equals("")) {
            resultat = val;
        }

        return resultat;
    }

    public void affichScientifiq(View view){
        Intent intent = new Intent(this, AffichScientifiq.class);
        startActivity(intent);
    }

}
