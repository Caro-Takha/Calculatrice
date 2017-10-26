package aube.macalculatrice;

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
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bMult;
    private Button bDiv;
    private Button bPlus;
    private Button bMoins;
    private Button bVirgule;
    private double val;
    private double valprecedent;
    private String operateurPrecedent;
    private ArrayList<Button> ListeBoutons;
    private String operateur="";
    private int decim=0;


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

        for (int i = 0; i < 10; i++){
            final int valb=i;
            ListeBoutons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (decim==0) {
                        val = val * 10 + valb;
                    }
                    else{
                        val=val+valb/(decim*10);
                        decim=decim+1;
                    }
                    mViewText.setText(String.valueOf(val));
                }
            });
        }

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent,val)));
                valprecedent=egal(valprecedent,val);
                operateur="+";
                val=0;
            }
        });


        bMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent,val)));
                valprecedent=egal(valprecedent,val);
                operateur="-";
                val=0;
            }
        });

        bMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent,val)));
                valprecedent=egal(valprecedent,val);
                operateur="x";
                val=0;
            }
        });


        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent,val)));
                valprecedent=egal(valprecedent,val);
                operateur="/";
                val=0;
            }
        });


        mGenerateEgalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewText.setText(String.valueOf(egal(valprecedent,val)));
                operateur="";
                val=0;
            }
        });

        bVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decim=1;
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
}