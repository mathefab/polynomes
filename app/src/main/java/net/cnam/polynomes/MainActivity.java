package net.cnam.polynomes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //float saisie;
    //float saisie;
    float saisiea;
    float saisieb;
    float saisiec;
    float delta;
    TextView afficheresultat;
    ImageView parabole;
    Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        buttonGo = findViewById (R.id.go);
        buttonGo.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                EditText textesaisiea = (EditText) findViewById (R.id.Saisiea);
                saisiea = Float.valueOf(textesaisiea.getText().toString());
                EditText textesaisieb = (EditText) findViewById (R.id.Saisieb);
                saisieb = Float.parseFloat (textesaisieb.getText ().toString ());
                EditText textesaisiec = (EditText) findViewById (R.id.Saisiec);
                saisiec = Float.valueOf(textesaisiec.getText().toString());
                delta = (saisieb * saisieb) - (4 * saisiea * saisiec);
                afficheresultat = findViewById (R.id.resultat);
                afficheresultat.setText (String.valueOf (delta));
                // On recupÃ¨re l'ImageView
                ImageView vue = (ImageView) findViewById (R.id.parabole);

                // CrÃ©er une BitMap de taille 750x1500 qui servira de support pour le dessin
                Bitmap pixels = Bitmap.createBitmap (600, 400, Bitmap.Config.ARGB_8888);
                Canvas dessin = new Canvas (pixels);

                // On peint en noir le dessin
                dessin.drawColor (Color.BLACK);

                // Un pinceau pour ... dessiner
                Paint pinceau = new Paint ();
                // On selectionne la couleur blanche
                pinceau.setColor (Color.WHITE);

                for (float i = -300; i < 300; i = (float) (i + 0.1)) {
                    pinceau.setColor (Color.WHITE);
                    dessin.drawCircle (1 * i + 300, -(saisiea * i * i + saisieb * i + saisiec) / 100 + 200, 3, pinceau);
                }

                vue.setImageBitmap (pixels);


            }
        });


    }

    Canvas can_parab = new Canvas ();

    @Override
    protected void onResume() {
        super.onResume ();

        parabole = findViewById (R.id.parabole);
        parabole.draw (can_parab);
        can_parab.drawColor (Color.BLACK);

    }


}

